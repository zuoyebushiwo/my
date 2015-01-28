package com.company.target.collections.ch13;

import java.util.*;

public class HashMapOpen extends AbstractMap implements Map, Cloneable,
		java.io.Serializable {
	/**
	 * The hash table data.
	 */
	private transient Entry table[];

	/**
	 * The total number of mappings in the hash table.
	 */
	private transient int count;

	private transient int countPlus;
	/**
	 * The table is rehashed when countPlus reaches this threshold. (The value
	 * of this field is (int)(capacity * loadFactor).)
	 * 
	 * @serial
	 */
	private int threshold;

	/**
	 * The load factor for the hashtable.
	 * 
	 * @serial
	 */
	private float loadFactor;

	private int index;

	private int offset;

	private int hash;

	/**
	 * The number of times this HashMap has been structurally modified
	 * Structural modifications are those that change the number of mappings in
	 * the HashMap or otherwise modify its internal structure (e.g., rehash).
	 * This field is used to make iterators on Collection-views of the HashMap
	 * fail-fast. (See ConcurrentModificationException).
	 */
	private transient int modCount = 0;

	/**
	 * Constructs a new, empty map with the specified initial capacity and the
	 * specified load factor.
	 * 
	 * @param initialCapacity
	 *            the initial capacity of the HashMap.
	 * @param loadFactor
	 *            the load factor of the HashMap
	 * @throws IllegalArgumentException
	 *             if the initial capacity is less than zero, or if the load
	 *             factor is nonpositive.
	 */
	public HashMapOpen(int initialCapacity, float loadFactor) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal Initial Capacity: "
					+ initialCapacity);
		if (loadFactor <= 0)
			throw new IllegalArgumentException("Illegal Load factor: "
					+ loadFactor);
		if (initialCapacity == 0)
			initialCapacity = 1;
		this.loadFactor = loadFactor;
		table = new Entry[initialCapacity];
		threshold = (int) (initialCapacity * loadFactor);
	}

	/**
	 * Constructs a new, empty map with the specified initial capacity and
	 * default load factor, which is <tt>0.75</tt>.
	 * 
	 * @param initialCapacity
	 *            the initial capacity of the HashMap.
	 * @throws IllegalArgumentException
	 *             if the initial capacity is less than zero.
	 */
	public HashMapOpen(int initialCapacity) {
		this(initialCapacity, 0.75f);
	}

	/**
	 * Constructs a new, empty map with a default capacity and load factor,
	 * which is <tt>0.75</tt>.
	 */
	public HashMapOpen() {
		this(101, 0.75f);
	}

	/**
	 * Returns the number of key-value mappings in this map.
	 * 
	 * @return the number of key-value mappings in this map.
	 */
	public int size() {
		return count;
	}

	// Postcondition: the next prime at least twice as large as
	// p has been returned.
	private int nextPrime(int p) {

		int i;

		boolean stillOK;

		p = 2 * p + 1;
		while (true) {

			i = 3;
			stillOK = true;
			while (i * i < p && stillOK)
				if (p % i == 0)
					stillOK = false;
				else
					i += 2;
			if (stillOK)
				return p;
			p += 2;

		} // while prime not found

	} // method nextPrime

	/**
	 * Returns <tt>true</tt> if this map contains no key-value mappings.
	 * 
	 * @return <tt>true</tt> if this map contains no key-value mappings.
	 */
	public boolean isEmpty() {
		return count == 0;
	}

	private void hashKey(Object key) {

		hash = key.hashCode();

		int posHash = hash & 0x7FFFFFFF;
		index = posHash % table.length;
		offset = posHash / table.length;

		if (offset % table.length == 0)
			offset = 1;

	} // method getIndexAndOffset

	public boolean containsKey(Object key) {

		hashKey(key);
		while (true) {

			if (table[index] == null)
				return false;
			Entry e = table[index];
			if (!e.markedForRemoval && hash == hash && key.equals(e.key))
				return true;
			index = (index + offset) % table.length;

		} // while

	} // containsKey

	public Object remove(Object key) {

		hashKey(key);
		while (true) {

			if (table[index] == null)
				return null;
			Entry e = table[index];
			if (!e.markedForRemoval && e.hash == hash && key.equals(e.key)) {

				count--;
				Object oldValue = e.value;
				e.markedForRemoval = true;
				return oldValue;

			} // if match
			index = (index + offset) % table.length;

		} // while

	} // method remove

	private void rehash() {

		int oldCapacity = table.length;
		Entry oldMap[] = table;

		int newCapacity = nextPrime(oldCapacity);
		Entry newMap[] = new Entry[newCapacity];
		threshold = (int) (newCapacity * loadFactor);
		table = newMap;
		count = 0;
		countPlus = 0;

		for (int i = 0; i < oldCapacity; i++)
			if (oldMap[i] != null && !oldMap[i].markedForRemoval)
				put(oldMap[i].key, oldMap[i].value);

	} // method rehash

	public Object put(Object key, Object value) {

		if (countPlus >= threshold)
			rehash();
		hashKey(key);

		while (table[index] != null) {

			Entry e = table[index];
			if (!e.markedForRemoval && e.hash == hash && key.equals(e.key)) {

				Object oldValue = e.value;
				e.value = value;
				return oldValue;

			} // if match
			index = (index + offset) % table.length;

		} // while
		count++;
		countPlus++;
		table[index] = new Entry(hash, key, value);
		return null;

	} // method put

	private transient Set keySet = null;
	private transient Set entrySet = null;
	private transient Collection values = null;

	private final int KEYS = 0;
	private final int VALUES = 1;
	private final int ENTRIES = 2;

	/**
	 * Returns a set view of the keys contained in this map. The set is backed
	 * by the map, so changes to the map are reflected in the set, and
	 * vice-versa. The set supports element removal, which removes the
	 * corresponding mapping from this map, via the <tt>Iterator.remove</tt>,
	 * <tt>Set.remove</tt>, <tt>removeAll</tt>, <tt>retainAll</tt>, and
	 * <tt>clear</tt> operations. It does not support the <tt>add</tt> or
	 * <tt>addAll</tt> operations.
	 * 
	 * @return a set view of the keys contained in this map.
	 */
	public Set keySet() {
		if (keySet == null) {
			keySet = new AbstractSet() {
				public Iterator iterator() {
					return new HashIterator(KEYS);
				}

				public int size() {
					return count;
				}

				public boolean contains(Object o) {
					return containsKey(o);
				}

				public boolean remove(Object o) {
					return true;
				}

				public void clear() {
				}
			};
		}
		return keySet;
	}

	/**
	 * Returns a collection view of the values contained in this map. The
	 * collection is backed by the map, so changes to the map are reflected in
	 * the collection, and vice-versa. The collection supports element removal,
	 * which removes the corresponding mapping from this map, via the
	 * <tt>Iterator.remove</tt>, <tt>Collection.remove</tt>, <tt>removeAll</tt>,
	 * <tt>retainAll</tt>, and <tt>clear</tt> operations. It does not support
	 * the <tt>add</tt> or <tt>addAll</tt> operations.
	 * 
	 * @return a collection view of the values contained in this map.
	 */
	public Collection values() {
		if (values == null) {
			values = new AbstractCollection() {
				public Iterator iterator() {
					return new HashIterator(VALUES);
				}

				public int size() {
					return count;
				}

				public boolean contains(Object o) {
					return containsValue(o);
				}

				public void clear() {
				}
			};
		}
		return values;
	}

	/**
	 * Returns a collection view of the mappings contained in this map. Each
	 * element in the returned collection is a <tt>Map.Entry</tt>. The
	 * collection is backed by the map, so changes to the map are reflected in
	 * the collection, and vice-versa. The collection supports element removal,
	 * which removes the corresponding mapping from the map, via the
	 * <tt>Iterator.remove</tt>, <tt>Collection.remove</tt>, <tt>removeAll</tt>,
	 * <tt>retainAll</tt>, and <tt>clear</tt> operations. It does not support
	 * the <tt>add</tt> or <tt>addAll</tt> operations.
	 * 
	 * @return a collection view of the mappings contained in this map.
	 * @see Map.Entry
	 */
	public Set entrySet() {
		if (entrySet == null) {
			entrySet = new AbstractSet() {
				public Iterator iterator() {
					return new HashIterator(ENTRIES);
				}

				public boolean contains(Object o) {
					return false;
				}

				public boolean remove(Object o) {
					return false;
				}

				public int size() {
					return count;
				}

				public void clear() {
				}
			};
		}

		return entrySet;
	}

	private static class Entry implements Map.Entry {

		int hash;
		Object key;
		Object value;
		boolean markedForRemoval;

		Entry(int hash, Object key, Object value) {

			this.hash = hash;
			this.key = key;
			this.value = value;
			markedForRemoval = false;

		} // constructor

		public Object setValue(Object value) {
			Object oldValue = this.value;
			this.value = value;
			return oldValue;
		}

		public Object getValue() {
			return value;
		}

		public Object getKey() {
			return key;
		}

	} // class Entry

	private class HashIterator implements Iterator {
		Entry[] table = HashMapOpen.this.table;
		int index = table.length;
		Entry entry = null;
		Entry lastReturned = null;
		int type;

		/**
		 * The modCount value that the iterator believes that the backing List
		 * should have. If this expectation is violated, the iterator has
		 * detected concurrent modification.
		 */
		private int expectedModCount = modCount;

		HashIterator(int type) {
			this.type = type;
		}

		public boolean hasNext() {
			while (entry == null && index > 0)
				entry = table[--index];

			return entry != null;
		}

		public Object next() {
			if (modCount != expectedModCount)
				throw new ConcurrentModificationException();

			while ((entry == null || entry.markedForRemoval) && index > 0)
				entry = table[--index];

			if (entry != null) {
				Entry e = lastReturned = entry;
				entry = index == 0 ? null : table[--index];
				return type == KEYS ? e.key : (type == VALUES ? e.value : e);
			}
			throw new NoSuchElementException();
		}

		public void remove() {
		}

	}

} // class HashMapOpen

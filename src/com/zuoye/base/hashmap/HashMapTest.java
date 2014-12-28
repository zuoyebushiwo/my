package com.zuoye.base.hashmap;

import java.util.HashMap;

/**
 * HashMap�����ԭ���ʵ�ַ���
 * 
 * 1.HashMap�����˼·���ڲ��ṹ��� 2.HashMap�е�һЩ���ʲô�Ƿ�ֵ��Ϊʲô���з�ֵ��ʲô�Ǽ������ӣ�������ʲô����
 * 3.HashMap�����������Լ�ʹ������ 4.HashMap��Դ��ʵ�ֺͷ��� 5.ΪʲôJDK����������дObject.equals(Object
 * obj)����ʱ����Ҫ��֤������Է�����ͬ��hashcodeֵ
 * 
 */
public class HashMapTest<K, V> extends HashMap<K, V> {

	/**
	 * 1.HashMap���˼·�Լ��ڲ��ṹ���
	 * 
	 * HashMap���˼·
	 * 
	 * Map<K, V>��һ���Լ�ֵ�Դ洢���ݵ���������HashMap���ǽ����˼�ֵKey��hashcodeֵ����֯�洢��
	 * ʹ�ÿ��Էǳ����ٺ͸�Ч�ظ��ݼ�ֵKey�������ݵĴ�ȡ��
	 * 
	 * ���ڼ�ֵ��<Key, Value>, HashMap�ڲ��Ὣ���װ��һ����Ӧ��Entry<Key, Value>���� ��Entry<Key,
	 * Value>�����Ǽ�ֵ��<Key, Value>����֯��ʽ��
	 * 
	 * ����ÿ��������ԣ�JVM����Ϊ������һ��hashcodeֵ��HashMap�ڴ洢��ֵ��Entry<Key, Value>��ʱ��
	 * �����Key��hashCodeֵ����ĳ��ӳ���ϵ������Ӧ������Լ�ֵ��Entry<Key, Value>�洢��HashMap�е�ʲôλ�ã�
	 * 
	 * ��ͨ��Keyֵȡ���ݵ�ʱ��Ȼ�����Keyֵ��hashcode���Լ��ڲ�ӳ��������ֱ�Ӷ�λ��Key��Ӧ��Valueֵ�����ʲôλ���ϣ�
	 * ���Էǳ���Ч�ؽ�Valueֵȡ����
	 */

	/**
	 * Ϊ��ʵ�����������˼·����HashMap�ڲ�������������+�������ʽ����֯��ֵ��Entry<Key, Value>��
	 * HashMap�ڲ�ά����һ��Entry[] table���飬������ʹ��new HashMap()����һ��HashMapʱ��Entry[]
	 * table��Ĭ�ϳ���Ϊ16��Entry[] table�ĳ����ֱ��� Ϊ���HashMap��������capacity���� ����Entry[]
	 * table��ÿ��Ԫ�ض��ԣ���Ϊnull����Ϊ�����ɸ�Entry<Key, Value>��ɵ�����HashMap�е�Entry<Key,
	 * Value>����Ŀ����ΪHashMap�Ĵ�С ��size��; Entry[] table�е�ĳһ��Ԫ�ؼ����ӦEntry<Key,
	 * Value>�ֱ���ΪͰ(bucket);
	 */
//	public static void main(String[] args) {
//		HashMap<String, String> map = new HashMap<String, String>();
//	}
//
//	/**
//	 * ��<Key, Vlaue>��ֵ�Դ浽HashMap�У����Key��HashMap���Ѿ����ڣ���ô���շ��ر��滻����Valueֵ��
//	 * Key��Value����Ϊ��
//	 */
//	@Override
//	public V put(K key, V value) {
//		// 1.���keyΪnull����ô����value���õ�table[0]������һ��Ͱ��
//		if (key == null) {
//			return putForNullKey(value);
//		}
//		// 2.���¼���hashcode��ֵ��
//		int hash = hash(key.hashCode());
//		// 3.���㵱ǰhashcode��ֵӦ�������䵽��һ��Ͱ�У���ȡͰ������
//		int i = indexFor(hash, table.length);
//		// 4.ѭ��������Ͱ�е�Entry�б�
//		for (Entry<K, V>  e = table[i] : e != null; e = e.next()) {
//			Object k;
//			// 5.����Entry<Key, Value>�������Ƿ��Ѿ�������KeyֵΪKey�洢��Entry<Key, Value>����
//			// �Ѿ����ڣ���Valueֵ���ǵ���Ӧ��Entry<Key, Value>����ڵ���
//			if (e.hash == hash && ((k = e.key) == key || key.equals(k))) { // �����ע������ж��������ǳ���Ҫ
//				V oldValue = e.value;
//				e.value = value;
//				e.recordAccess(this);
//				return oldValue;
//			}
//			
//		}
//		modCount++;
//		
//		// 6.�����ڣ�����ݼ�ֵ��<Key, Value> ����һ���µ�Entry<Key, Value>����Ȼ����ӵ����Ͱ��Entry<Key, Value>�����ͷ����
//		addEntry(hash, key, value, i);
//		return null;
//	}
//
//	/**
//	 * KeyΪNull����Entry<null, Value>���õ���һ��Ͱtable[0]��
//	 * 
//	 * @param value
//	 * @return
//	 */
//	private V putForNullKey(V value) {
//		for (Entry<K, V> e = table[0]; e != null; e = e.next) {
//			if (e.key == null) {
//				V oldValue = e.value;
//				e.value = value;
//				e.recordAccess(this);
//				return oldValue;
//			}
//		}
//		modCount++;
//		addEntry(0, null, value, 0);
//		return null;
//	}
//
//	/** 
//	 * �����ض���hashcode ���¼���hashֵ�� 
//	 * ����JVM���ɵĵ�hashcode�ĵ��ֽ�(lower bits)��ͻ���ʴ󣬣�JDKֻ����ôһ˵������Ϊʲô��Ҳ������� 
//	 * Ϊ��������ܣ�HashMap��Key��hashcode�ټӹ���ȡKey��hashcode�ĸ��ֽڲ������� 
//	 */  
//	static int hash(int h) {  
//	    // This function ensures that hashCodes that differ only by  
//	    // constant multiples at each bit position have a bounded  
//	    // number of collisions (approximately 8 at default load factor).  
//	    h ^= (h >>> 20) ^ (h >>> 12);  
//	    return h ^ (h >>> 7) ^ (h >>> 4);  
//	}  
//	  
//	/** 
//	 * ���ش�hashcodeӦ�����䵽��Ͱ������ 
//	 */  
//	static int indexFor(int h, int length) {  
//	    return h & (length-1);  
//	} 
	
}

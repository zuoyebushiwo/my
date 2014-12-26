package com.zuoye.base.hashmap;

import java.util.HashMap;

/**
 * HashMap�����ԭ���ʵ�ַ���
 * 
 * 1.HashMap�����˼·���ڲ��ṹ���
 * 2.HashMap�е�һЩ���ʲô�Ƿ�ֵ��Ϊʲô���з�ֵ��ʲô�Ǽ������ӣ�������ʲô����
 * 3.HashMap�����������Լ�ʹ������
 * 4.HashMap��Դ��ʵ�ֺͷ���
 * 5.ΪʲôJDK����������дObject.equals(Object obj)����ʱ����Ҫ��֤������Է�����ͬ��hashcodeֵ
 * 
 */
public class HashMapTest {
	
	/**
	 * 1.HashMap���˼·�Լ��ڲ��ṹ��� 
	 * 
	 * 		HashMap���˼·
	 * 
	 * 		Map<K, V>��һ���Լ�ֵ�Դ洢���ݵ���������HashMap���ǽ����˼�ֵKey��hashcodeֵ����֯�洢��
	 * ʹ�ÿ��Էǳ����ٺ͸�Ч�ظ��ݼ�ֵKey�������ݵĴ�ȡ��
	 * 
	 * 		���ڼ�ֵ��<Key, Value>, HashMap�ڲ��Ὣ���װ��һ����Ӧ��Entry<Key, Value>����
	 * ��Entry<Key, Value>�����Ǽ�ֵ��<Key, Value>����֯��ʽ��
	 * 
	 * 		����ÿ��������ԣ�JVM����Ϊ������һ��hashcodeֵ��HashMap�ڴ洢��ֵ��Entry<Key, Value>��ʱ��
	 * �����Key��hashCodeֵ����ĳ��ӳ���ϵ������Ӧ������Լ�ֵ��Entry<Key, Value>�洢��HashMap�е�ʲôλ�ã�
	 * 
	 * 		��ͨ��Keyֵȡ���ݵ�ʱ��Ȼ�����Keyֵ��hashcode���Լ��ڲ�ӳ��������ֱ�Ӷ�λ��Key��Ӧ��Valueֵ�����ʲôλ���ϣ�
	 * ���Էǳ���Ц�ؽ�Valueֵȡ����
	 */

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
	}
	
}

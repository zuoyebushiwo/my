package com.internet.memcache.example.util;

import java.util.Date;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

/**
 * 
 * <pre>
 * <b>����������</b>Memcached�Ĺ����� 
 * 
 * @author ��****(Kevin.xie)<br> 
 * 
 * <b>�޸���ʷ��</b>(�޸��ˣ��޸�ʱ�䣬�޸�ԭ��/����)
 * 
 * </pre>
 */
public class MemcachedUtil {

	/**
	 * <b>���캯����������,��ֹʵ����</b>
	 * 
	 */
	private MemcachedUtil() {

	}

	// ����ȫ�ֵ�Ψһʵ��
	private static MemCachedClient mcc = new MemCachedClient();

	/*
	 * ����ʾ��
	 */
	private static MemcachedUtil memcachedUtil = new MemcachedUtil();

	static {

		// �������б����Ȩ��
		String[] servers = { "192.168.142.128:11211" }; // Ip��ַ�Ͷ˿ں�
		// Ȩ��
		Integer[] weights = { 3 };

		// ��ȡsocket���ӳص�ʵ������
		SockIOPool pool = SockIOPool.getInstance();

		// ���÷�������Ϣ
		pool.setServers(servers);
		pool.setWeights(weights);

		// ���ó�ʼ����������С������������Լ������ʱ��
		pool.setInitConn(5);
		pool.setMinConn(5);
		pool.setMaxConn(250);
		pool.setMaxIdle(1000 * 60 * 60 * 6);

		// �������̵߳�˯��ʱ��
		pool.setMaintSleep(30);

		// ����TCP�Ĳ��������ӳ�ʱ��
		pool.setNagle(false);
		pool.setSocketTO(3000);
		pool.setSocketConnectTO(0);

		// ��ʼ�����ӳ�
		pool.initialize();

		// ѹ�����ã�����ָ����С����λΪK�������ݶ��ᱻѹ��
		// mcc.setCompressEnable(true);
		// mcc.setCompressThreshold(64 * 1024);

		mcc.setPrimitiveAsString(true);// �������л�
	}

	/**
	 * 
	 * <pre>
	 * <b>����������</b>��ȡΨһʵ��. 
	 *  
	 * @author ��****��Kevin.xie�� 
	 * <b>�������� ��</b>2012-4-25 ����10:57:41 
	 * 
	 * @return 
	 * 
	 * <b>�޸���ʷ��</b>(�޸��ˣ��޸�ʱ�䣬�޸�ԭ��/����)
	 * 
	 * </pre>
	 */
	public static MemcachedUtil getInstance() {
		return memcachedUtil;
	}

	/**
	 * 
	 * <pre>
	 * <b>����������</b>����һ���������� 
	 *  
	 * @author ��****��Kevin.xie�� 
	 * <b>�������� ��</b>2012-4-25 ����10:55:15 
	 * 
	 * @param key �����key 
	 * @param value �����ֵ 
	 * @return ������� 
	 *       
	 * 
	 * <b>�޸���ʷ��</b>(�޸��ˣ��޸�ʱ�䣬�޸�ԭ��/����)
	 * 
	 * </pre>
	 */
	public boolean add(String key, Object value) {
		// ������뻺��
		return mcc.add(key, value);
		// return mcc.set(key, value);
	}

	/**
	 * 
	 * <pre>
	 * <b>����������</b>����һ���������� 
	 *  
	 * @author ��****��Kevin.xie�� 
	 * <b>�������� ��</b>2012-4-25 ����10:56:15 
	 * 
	 * @param key �����key 
	 * @param value �����ֵ 
	 * @param expiry ������ڵ�ʱ�� 
	 * @return ������� 
	 * 
	 * <b>�޸���ʷ��</b>(�޸��ˣ��޸�ʱ�䣬�޸�ԭ��/����)
	 * 
	 * </pre>
	 */
	public boolean add(String key, Object value, Date expiry) {
		// ������뻺��
		return mcc.add(key, value, expiry);
		// return mcc.set(key, value, expiry);
	}

	/**
	 * <pre>
	 * <b>����������</b>�滻���еĻ������� 
	 *  
	 * @author ��****��Kevin.xie�� 
	 * <b>�������� ��</b>2012-4-25 ����10:55:34 
	 * 
	 * @param key ���ö����key 
	 * @return Object ���ö����ֵ 
	 * @return �Ƿ��滻�ɹ� 
	 *  
	 * <b>�޸���ʷ��</b>(�޸��ˣ��޸�ʱ�䣬�޸�ԭ��/����)
	 * 
	 * </pre>
	 */
	public boolean replace(String key, Object value) {

		return mcc.replace(key, value);
	}

	/**
	 * 
	 * <pre>
	 * <b>����������</b>�滻���еĻ������� 
	 *  
	 * @author ��****��Kevin.xie�� 
	 * <b>�������� ��</b>2012-4-25 ����10:43:17 
	 * 
	 * @param key ���ö����key 
	 * @return Object ���ö����ֵ 
	 * @param expiry ����ʱ�� 
	 * @return �Ƿ��滻�ɹ� 
	 * 
	 * <b>�޸���ʷ��</b>(�޸��ˣ��޸�ʱ�䣬�޸�ԭ��/����)
	 * 
	 * </pre>
	 */
	public boolean replace(String key, Object value, Date expiry) {

		return mcc.replace(key, value, expiry);
	}

	/**
	 * 
	 * <pre>
	 * <b>����������</b>����ָ���Ĺؼ��ֻ�ȡ���� 
	 *  
	 * @author ��****��Kevin.xie�� 
	 * <b>�������� ��</b>2012-4-25 ����10:42:49 
	 * 
	 * @param key ��ȡ�����key 
	 * @return Object ����ֵ 
	 * 
	 * <b>�޸���ʷ��</b>(�޸��ˣ��޸�ʱ�䣬�޸�ԭ��/����)
	 * 
	 * </pre>
	 */
	public Object get(String key) {

		return mcc.get(key);
	}

}

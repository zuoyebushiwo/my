package com.internet.memcache.nb;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;

import org.junit.Test;

public class TestCase {

	@Test
	public void test1() throws IOException {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(
				AddrUtil.getAddresses("192.168.142.128:11211"));
		// 崻�����
		builder.setFailureMode(true);
		// ʹ�ö������ļ�
		builder.setCommandFactory(new BinaryCommandFactory());
		/** 
         * �������ӳش�С�����ͻ��˸��� 
         * In a high concurrent enviroment,you may want to pool memcached clients. 
         * But a xmemcached client has to start a reactor thread and some thread pools, 
         * if you create too many clients,the cost is very large.  
         * Xmemcached supports connection pool instreadof client pool. 
         * you can create more connections to one or more memcached servers, 
         * and these connections share the same reactor and thread pools, 
         * it will reduce the cost of system. 
         *  Ĭ�ϵ�pool size��1��������һ��ֵ��һ����������ܣ������������Ŀ�Ĳ��Խ��Ϊ׼�������Ĳ��Ա���ֻ���ڴ󲢷��²��������� 
         *  �������ӳص�һ������������ǣ�ͬһ��memcached������֮������ݸ��²���ͬ���� 
         *  ������Ӧ����Ҫ�Լ���֤���ݸ��µ�ԭ���ԣ�����CAS��������֮����޹������� 
         */
		builder.setConnectionPoolSize(10);
		MemcachedClient client = builder.build();
		
		/**
		 * ��һ���Ǵ洢��key���ƣ�
		 * �ڶ�����expireʱ�䣨��λ�룩���������ʱ��,memcached����������滻��ȥ��0��ʾ���ô洢��Ĭ����һ����)
		 * ��������������ʵ�ʴ洢������
		 */
		try {
			client.set("hello", 0, "Hello,xmemcached");
			String value = client.get("hello");
			System.out.println("hello=" + value);
			client.delete("hello");
			value = client.get("hello");
			System.out.println("hello=" + value);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}

		// value=client.get(��hello��,3000);

		/**
		 * Memcached��ͨ��casЭ��ʵ��ԭ�Ӹ��£���νԭ�Ӹ��¾���compare and set��
		 * ԭ�������ֹ�����ÿ������洢ĳ������ͬʱҪ����һ��casֵ�� memcached�ȶ����casֵ�뵱ǰ�洢���ݵ�casֵ�Ƿ���ȣ�
		 * �����Ⱦ����µ����ݸ����ϵ����ݣ��������Ⱦ���Ϊ����ʧ�ܣ� ���ڲ����������ر�����
		 */
	}

}

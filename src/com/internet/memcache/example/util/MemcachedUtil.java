package com.internet.memcache.example.util;

import java.util.Date;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

/**
 * 
 * <pre>
 * <b>功能描述：</b>Memcached的工具类 
 * 
 * @author ：****(Kevin.xie)<br> 
 * 
 * <b>修改历史：</b>(修改人，修改时间，修改原因/内容)
 * 
 * </pre>
 */
public class MemcachedUtil {

	/**
	 * <b>构造函数：工具类,禁止实例化</b>
	 * 
	 */
	private MemcachedUtil() {

	}

	// 创建全局的唯一实例
	private static MemCachedClient mcc = new MemCachedClient();

	/*
	 * 自身示例
	 */
	private static MemcachedUtil memcachedUtil = new MemcachedUtil();

	static {

		// 服务器列表和其权重
		String[] servers = { "192.168.142.128:11211" }; // Ip地址和端口号
		// 权重
		Integer[] weights = { 3 };

		// 获取socket连接池的实例对象
		SockIOPool pool = SockIOPool.getInstance();

		// 设置服务器信息
		pool.setServers(servers);
		pool.setWeights(weights);

		// 设置初始连接数，最小和最大连接数以及最大处理时间
		pool.setInitConn(5);
		pool.setMinConn(5);
		pool.setMaxConn(250);
		pool.setMaxIdle(1000 * 60 * 60 * 6);

		// 设置主线程的睡眠时间
		pool.setMaintSleep(30);

		// 设置TCP的参数，连接超时等
		pool.setNagle(false);
		pool.setSocketTO(3000);
		pool.setSocketConnectTO(0);

		// 初始化连接池
		pool.initialize();

		// 压缩设置，超过指定大小（单位为K）的数据都会被压缩
		// mcc.setCompressEnable(true);
		// mcc.setCompressThreshold(64 * 1024);

		mcc.setPrimitiveAsString(true);// 设置序列化
	}

	/**
	 * 
	 * <pre>
	 * <b>功能描述：</b>获取唯一实例. 
	 *  
	 * @author ：****（Kevin.xie） 
	 * <b>创建日期 ：</b>2012-4-25 上午10:57:41 
	 * 
	 * @return 
	 * 
	 * <b>修改历史：</b>(修改人，修改时间，修改原因/内容)
	 * 
	 * </pre>
	 */
	public static MemcachedUtil getInstance() {
		return memcachedUtil;
	}

	/**
	 * 
	 * <pre>
	 * <b>功能描述：</b>新增一个缓存数据 
	 *  
	 * @author ：****（Kevin.xie） 
	 * <b>创建日期 ：</b>2012-4-25 上午10:55:15 
	 * 
	 * @param key 缓存的key 
	 * @param value 缓存的值 
	 * @return 操作结果 
	 *       
	 * 
	 * <b>修改历史：</b>(修改人，修改时间，修改原因/内容)
	 * 
	 * </pre>
	 */
	public boolean add(String key, Object value) {
		// 不会存入缓存
		return mcc.add(key, value);
		// return mcc.set(key, value);
	}

	/**
	 * 
	 * <pre>
	 * <b>功能描述：</b>新增一个缓存数据 
	 *  
	 * @author ：****（Kevin.xie） 
	 * <b>创建日期 ：</b>2012-4-25 上午10:56:15 
	 * 
	 * @param key 缓存的key 
	 * @param value 缓存的值 
	 * @param expiry 缓存过期的时间 
	 * @return 操作结果 
	 * 
	 * <b>修改历史：</b>(修改人，修改时间，修改原因/内容)
	 * 
	 * </pre>
	 */
	public boolean add(String key, Object value, Date expiry) {
		// 不会存入缓存
		return mcc.add(key, value, expiry);
		// return mcc.set(key, value, expiry);
	}

	/**
	 * <pre>
	 * <b>功能描述：</b>替换已有的缓存数据 
	 *  
	 * @author ：****（Kevin.xie） 
	 * <b>创建日期 ：</b>2012-4-25 上午10:55:34 
	 * 
	 * @param key 设置对象的key 
	 * @return Object 设置对象的值 
	 * @return 是否替换成功 
	 *  
	 * <b>修改历史：</b>(修改人，修改时间，修改原因/内容)
	 * 
	 * </pre>
	 */
	public boolean replace(String key, Object value) {

		return mcc.replace(key, value);
	}

	/**
	 * 
	 * <pre>
	 * <b>功能描述：</b>替换已有的缓存数据 
	 *  
	 * @author ：****（Kevin.xie） 
	 * <b>创建日期 ：</b>2012-4-25 上午10:43:17 
	 * 
	 * @param key 设置对象的key 
	 * @return Object 设置对象的值 
	 * @param expiry 过期时间 
	 * @return 是否替换成功 
	 * 
	 * <b>修改历史：</b>(修改人，修改时间，修改原因/内容)
	 * 
	 * </pre>
	 */
	public boolean replace(String key, Object value, Date expiry) {

		return mcc.replace(key, value, expiry);
	}

	/**
	 * 
	 * <pre>
	 * <b>功能描述：</b>根据指定的关键字获取对象 
	 *  
	 * @author ：****（Kevin.xie） 
	 * <b>创建日期 ：</b>2012-4-25 上午10:42:49 
	 * 
	 * @param key 获取对象的key 
	 * @return Object 对象值 
	 * 
	 * <b>修改历史：</b>(修改人，修改时间，修改原因/内容)
	 * 
	 * </pre>
	 */
	public Object get(String key) {

		return mcc.get(key);
	}

}

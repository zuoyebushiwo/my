package com.zuoye.pattern.proxy;

/**
 * 信息查询接口
 */
public interface UserInfoService {

	// 基本信息
	public String getBasicInfo();

	// 教育背景
	public String getEducationalBackground();

	// 账户信息
	public String getAcccountInfo();

}

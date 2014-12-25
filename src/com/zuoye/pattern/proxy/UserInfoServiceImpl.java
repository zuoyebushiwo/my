package com.zuoye.pattern.proxy;

/**
 * 查询接口实现
 * 
 * @author louluan
 */
public class UserInfoServiceImpl implements UserInfoService {

	@Override
	public String getBasicInfo() {
		return "Basic Info....";
	}

	@Override
	public String getEducationalBackground() {
		return "Educational Background.....";
	}

	@Override
	public String getAcccountInfo() {
		return "Account Info.....";
	}

}

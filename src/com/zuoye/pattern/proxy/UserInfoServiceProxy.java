package com.zuoye.pattern.proxy;

/**
 * 信息查询代理控制访问权限
 * 
 * @author louluan
 */
public class UserInfoServiceProxy implements UserInfoService {

	private UserInfoService impl;
	private String role;

	public UserInfoServiceProxy(UserInfoService impl, String role) {
		this.impl = impl;
		this.role = role;
	}

	@Override
	public String getBasicInfo() {
		return impl.getBasicInfo();
	}

	@Override
	public String getEducationalBackground() {
		return impl.getEducationalBackground();
	}

	@Override
	public String getAcccountInfo() {
		// 如果是公司本部，返回
		if ("1".equals(role)) {
			return impl.getAcccountInfo();
		}
		// 禁止访问impl方法，返回****
		return "**********";
	}

}

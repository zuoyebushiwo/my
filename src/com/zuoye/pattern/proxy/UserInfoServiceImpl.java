package com.zuoye.pattern.proxy;

/**
 * ��ѯ�ӿ�ʵ��
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

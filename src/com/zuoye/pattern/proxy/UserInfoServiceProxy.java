package com.zuoye.pattern.proxy;

/**
 * ��Ϣ��ѯ������Ʒ���Ȩ��
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
		// ����ǹ�˾����������
		if ("1".equals(role)) {
			return impl.getAcccountInfo();
		}
		// ��ֹ����impl����������****
		return "**********";
	}

}

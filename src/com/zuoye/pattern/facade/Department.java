package com.zuoye.pattern.facade;

public class Department {

}

class CommercialDepartment {
	// ���̾��������� ʡ��
	public void applyCompanyName() {
		System.out.println("���֣̾�����һ����˾���ơ�");
	}

	public void distributeBusinessLicense() {
		System.out.println("���֣̾�����Ӫҵִ�ա�");
	}

	// ���̾��������� ʡ��
}

class Bank {
	// ������������ ʡ��
	public void createCheckAccount() {
		System.out.println("���У���һ�������˻���");
	}

	public void createBasicBank() {
		System.out.println("����: ��һ�������˻���");
	}
	// ������������ ʡ��
}

class PoliceBureau {
	// �������� ʡ��
	public void distributeSeal() {
		System.out.println("�����֣��������¡�");
	}
	// �������� ʡ��
}

class QualityInspectionBureau {
	// �������� ʡ��
	public void distributeCertificate() {
		System.out.println("�ʼ��:������֯��������֤��");
	}
	// �������� ʡ��
}

class TaxBureau {
	// �������� ʡ��
	public void registerTaxBusiness() {
		System.out.println("˰���ţ�˰��Ǽǡ�");
	}

	public void appraiseTaxType() {
		System.out.println("˰���ţ�˰�ּ�����");
	}
	// �������� ʡ��
}

package com.zuoye.pattern.facade;

// ��ɫͨ��
public class GreenChannel {

	public static void applyRunCompany() {

		// ���жԸ������ŵ�����
		CommercialDepartment commercialDepartment = new CommercialDepartment();
		Bank bank = new Bank();
		PoliceBureau policeBureau = new PoliceBureau();
		TaxBureau taxBureau = new TaxBureau();
		QualityInspectionBureau qualityInspectionBureau = new QualityInspectionBureau();

		System.out.println("-----------������ʹ��������ɫͨ��-------------");
		commercialDepartment.applyCompanyName(); // 1.�����̲�������һ����˾����;

		bank.createCheckAccount(); // 2.ȥ���п�һ�������˻� ; //

		commercialDepartment.distributeBusinessLicense(); // 3.׼�����ϣ������̲�����Ӫҵִ��;

		policeBureau.distributeSeal(); // 4. �������ֱ������£�

		qualityInspectionBureau.distributeCertificate(); // 5. ���ʼ�ְ�����֯��������֤��

		taxBureau.registerTaxBusiness(); // 6. ��˰���Ű���˰��Ǽ� ��

		bank.createBasicBank(); // 7. �����п�һ�������˻���

		taxBureau.appraiseTaxType(); // 8.��˰������˰�ּ�����

		System.out.println("лл��ʹ��������ɫͨ����");
	}

}
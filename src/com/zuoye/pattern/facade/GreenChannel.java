package com.zuoye.pattern.facade;

// 绿色通道
public class GreenChannel {

	public static void applyRunCompany() {

		// 持有对各个部门的引用
		CommercialDepartment commercialDepartment = new CommercialDepartment();
		Bank bank = new Bank();
		PoliceBureau policeBureau = new PoliceBureau();
		TaxBureau taxBureau = new TaxBureau();
		QualityInspectionBureau qualityInspectionBureau = new QualityInspectionBureau();

		System.out.println("-----------您正在使用政府绿色通道-------------");
		commercialDepartment.applyCompanyName(); // 1.到工商部门申请一个公司名称;

		bank.createCheckAccount(); // 2.去银行开一个验资账户 ; //

		commercialDepartment.distributeBusinessLicense(); // 3.准备材料，到工商部门拿营业执照;

		policeBureau.distributeSeal(); // 4. 到公安局备案刻章；

		qualityInspectionBureau.distributeCertificate(); // 5. 到质检局办理组织机构代码证；

		taxBureau.registerTaxBusiness(); // 6. 到税务部门办理税务登记 ；

		bank.createBasicBank(); // 7. 到银行开一个基本账户；

		taxBureau.appraiseTaxType(); // 8.到税务部门做税种鉴定；

		System.out.println("谢谢您使用政府绿色通道！");
	}

}

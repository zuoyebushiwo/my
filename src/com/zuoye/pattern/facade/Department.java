package com.zuoye.pattern.facade;

public class Department {

}

class CommercialDepartment {
	// 工商局其他功能 省略
	public void applyCompanyName() {
		System.out.println("工商局：申请一个公司名称。");
	}

	public void distributeBusinessLicense() {
		System.out.println("工商局：发放营业执照。");
	}

	// 工商局其他功能 省略
}

class Bank {
	// 银行其他功能 省略
	public void createCheckAccount() {
		System.out.println("银行：开一个验资账户。");
	}

	public void createBasicBank() {
		System.out.println("银行: 开一个基本账户。");
	}
	// 银行其他功能 省略
}

class PoliceBureau {
	// 其他功能 省略
	public void distributeSeal() {
		System.out.println("公安局：备案刻章。");
	}
	// 其他功能 省略
}

class QualityInspectionBureau {
	// 其他功能 省略
	public void distributeCertificate() {
		System.out.println("质检局:办理组织机构代码证。");
	}
	// 其他功能 省略
}

class TaxBureau {
	// 其他功能 省略
	public void registerTaxBusiness() {
		System.out.println("税务部门：税务登记。");
	}

	public void appraiseTaxType() {
		System.out.println("税务部门：税种鉴定。");
	}
	// 其他功能 省略
}

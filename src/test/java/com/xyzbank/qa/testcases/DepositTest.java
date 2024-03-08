package com.xyzbank.qa.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyzbank.qa.base.TestBase;
import com.xyzbank.qa.pages.AccountPage;
import com.xyzbank.qa.pages.CustomerLoginPage;
import com.xyzbank.qa.pages.CustomerslistPage;
import com.xyzbank.qa.pages.Homepage;

public class DepositTest extends TestBase {
	
	Homepage hp;
	CustomerLoginPage cp;
	AccountPage ap;
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		
		hp = new Homepage();
		cp = new CustomerLoginPage();
		ap = new AccountPage();
	}
	public DepositTest() {
		super();
	}
	
	@Test
	public void DepositMoney()throws Exception {
		cp = hp.customerLoginbtn();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		cp.selectUser();
		String EXPname = cp.selectUser();
		ap = cp.clickloginbtn();
		
		ap.clickDepositTab();
		
		ap.enterDepositAmount("900");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		ap.clickDepositButton();
		
		
		
		String alertMsg = ap.getDepositSuccessMSG();
		Assert.assertEquals(alertMsg,"Deposit Successful");

	}
		

}

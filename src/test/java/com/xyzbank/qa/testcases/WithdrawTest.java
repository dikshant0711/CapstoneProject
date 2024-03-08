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

public class WithdrawTest extends TestBase {
	
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
	
	
	@Test
	public void DepositMoney()throws Exception {
		cp = hp.customerLoginbtn();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cp.selectUser();
		String EXPname = cp.selectUser();
		ap = cp.clickloginbtn();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ap.clickWithdrawlTab();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ap.enterWithdrawlAmount("500");
		ap.clickWithdrawlButton();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);;
		
		String alertMsg = ap.getWithdarwlSuccessMSG();
		Assert.assertEquals(alertMsg,"Transaction successful");
		
		

	}
	
	
		
		
		

}

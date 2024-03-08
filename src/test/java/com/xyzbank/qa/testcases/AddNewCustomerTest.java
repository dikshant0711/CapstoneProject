package com.xyzbank.qa.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyzbank.qa.base.TestBase;
import com.xyzbank.qa.pages.AddCustomerPage;
import com.xyzbank.qa.pages.BankManagerLoginPage;
import com.xyzbank.qa.pages.Homepage;

public class AddNewCustomerTest extends TestBase {

	Homepage hp;
	AddCustomerPage acp;
	BankManagerLoginPage bmlp;

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		hp = new Homepage();
		acp = new AddCustomerPage();
		bmlp = new BankManagerLoginPage();
	}

	@Test
	public void verifyManagerLogin() throws Exception {
		hp.managerLoginBtn();
		bmlp.clickaddCustomerTab();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		acp.enterFName(prop.getProperty("fname"));
		acp.enterLName(prop.getProperty("lname"));
		acp.enterPCode(prop.getProperty("zip"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		acp.clickaddCustBtn();
		
		String alertMsg = acp.acceptAlert();
		System.out.println(alertMsg);
	}
}

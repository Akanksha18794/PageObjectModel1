package com.qa.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage lp;
	HomePage hp;
    
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() throws IOException {
		initialization();
		lp = new LoginPage();
	}
	
	@Test (priority = 1)
	public void LoginpageTitleTest() {
		String title = lp.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM Power Up your Entire Business Free Forever");	
		System.out.println(title);
	}
	
	@Test (priority =2)
	public void FreeCRMLogoImageTest() {
		boolean flag = lp.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	
	@Test (priority = 3)
	public void loginTest() throws InterruptedException {
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	@AfterMethod
	public void CloseBrowser() {
		TearDown();
	}
}

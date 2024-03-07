package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.DealsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class DealsPageTest extends TestBase{

	LoginPage lp;
	HomePage hp;
	DealsPage dp;
	
	public DealsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() throws InterruptedException {
		initialization(); 
		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		dp = hp.clickonDealsLink();
	}
	
	@Test (priority = 1)
	public void verifyDealsLabelTest() {
		Assert.assertTrue(dp.verifyDealslabel());
	}
	
	@Test (priority = 2)
	public void verifyPipelineLabelTest() {
		Assert.assertTrue(dp.verifypipelinelabel());
	}
	
	@Test (priority = 3)
	public void verifyBoardsLinkTest() {
		Assert.assertTrue(dp.verifyBoardlink());
	}
	
	@AfterMethod
	public void CloseBrowser() {
		TearDown();
	}
	
}

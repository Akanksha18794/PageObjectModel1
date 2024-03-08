package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.DealsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class DealsPageTest extends TestBase{

	LoginPage lp;
	HomePage hp;
	DealsPage dp;
	String sheetName = "deals";
	
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
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test (priority = 4, dataProvider="getCRMTestData")
		public void validateCreateNewDealsTest(String title, String description, String amount, String probability) throws InterruptedException {
		hp.clickonDealsLink();
		Thread.sleep(2000);
		hp.ClickOnCreateDealsLink();
		Thread.sleep(2000);
		dp.CreateNewDeal(title, description, amount, probability);	
	}
	
	@AfterMethod
	public void CloseBrowser() {
		TearDown();
	}
	
}

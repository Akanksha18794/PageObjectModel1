package com.qa.tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() throws InterruptedException {
		initialization();
		cp = new ContactsPage(); 
		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		cp = hp.clickonContactsLink();
	}
	
	@Test (priority = 1)
	public void verifyContactsLabelTest() {
		Assert.assertTrue(cp.verifyContactslabel(), "contacts label is missing on the page");
		}
	
	@Test (priority = 2)
	public void verifyCreateContactsbuttonTest() {
		Assert.assertTrue(cp.verifyCreateContactsButtion(), "Create Contacts button is missing");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test (priority = 3, dataProvider="getCRMTestData")
	public void validateCreateNewContactTest(String firstname, String lastname, String email) throws InterruptedException {
		hp.clickonContactsLink();
		Thread.sleep(2000);
		hp.ClickOnCreateContactLink();
		Thread.sleep(10000);
		cp.CreateNewContact(firstname, lastname, email);
	}
	
	@AfterMethod
	public void CloseBrowser() {
		TearDown();
	}
}

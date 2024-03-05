package com.qa.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() throws IOException, InterruptedException {
		initialization();
		lp = new LoginPage();
		cp = new ContactsPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test (priority =1)
	public void VerifyHomePageTitleTest() {
		String HomePageTitle = hp.verifyHomePageTitle();
		Assert.assertEquals(HomePageTitle, "Cogmento CRM", "Home Page Title not matched");
		System.out.println(HomePageTitle);
	}
	
	@Test (priority = 2)
	public void FreeCRMLogoTest() {
		boolean flag = hp.VerifyLogo();
		Assert.assertTrue(flag);
	}
	
	@Test (priority = 3)
	public void VerifyCorrectUserNameTest() {
		boolean flag = hp.VerifyCorrectusername();
		Assert.assertTrue(flag);
	}
	
	@Test (priority = 4)
	public void DisplayAllSideBarLinks() {
		hp.printSidebarLinkNames();
	}
	
	@Test (priority = 5)
	public void VerifyContactsLinkTest() {
		cp = hp.clickonContactsLink();
	}
	
	@AfterMethod
	public void CloseBrowser() {
		TearDown();
	}
}

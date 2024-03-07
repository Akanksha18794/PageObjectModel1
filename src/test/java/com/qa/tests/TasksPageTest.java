package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.TasksPage;

public class TasksPageTest extends TestBase{

	LoginPage lp;
	HomePage hp;
	TasksPage tp;
	
	public TasksPageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() throws InterruptedException {
		initialization(); 
		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		tp = hp.clickonTasksLink();
	}
	
	@Test (priority = 1)
	public void verifyTaskssLabelTest() {
		Assert.assertTrue(tp.verifyTaskslabel());
	}
	
	@Test (priority = 2)
	public void verifyBoardsLinkTest() {
		Assert.assertTrue(tp.verifyBoardlink());
	}
	
	@AfterMethod
	public void CloseBrowser() {
		TearDown();
	}
}

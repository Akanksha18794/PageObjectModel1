package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class TasksPage extends TestBase{
	
	@FindBy (xpath = "//span[contains(text(),'Tasks')]")
	WebElement taskslabel;
	
	@FindBy (linkText = "Board")
	WebElement boardlabel;
	
	public TasksPage() {
		PageFactory.initElements(driver, this);		
	}

	public boolean verifyTaskslabel() {
		return taskslabel.isDisplayed();
	}
	
	public boolean verifyBoardlink() {
		return boardlabel.isDisplayed();
	}
}

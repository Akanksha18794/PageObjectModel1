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
	
	@FindBy (xpath = "//button[contains(text(),'Create')]")
	WebElement createbutton;
	
	@FindBy (xpath = "//input[@name='title']")
	WebElement title;
	
	@FindBy (name = "description")
	WebElement description;
	
	@FindBy (name= "completion")
	WebElement completion;
	
	@FindBy (xpath = "//button[contains(text(),'Save')]")
	WebElement Save;
	
	public TasksPage() {
		PageFactory.initElements(driver, this);		
	}

	public boolean verifyTaskslabel() {
		return taskslabel.isDisplayed();
	}
	
	public boolean verifyBoardlink() {
		return boardlabel.isDisplayed();
	}
	
	public void CreateNewTask (String ti, String de, String co) {
		title.sendKeys(ti);
		description.sendKeys(de);
		completion.sendKeys(co);
		Save.click();
	}
}

package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class DealsPage extends TestBase{

	@FindBy (xpath = "//span[contains(text(),'Deals')]")
	WebElement dealslabel;
	
	@FindBy (xpath = "//button[contains(text(),'Pipeline')]")
	WebElement pipelinelabel;
	
	@FindBy (linkText = "Board")
	WebElement boardlabel;
	
	@FindBy (xpath = "//button[contains(text(),'Create')]")
	WebElement createbutton;
	
	@FindBy (xpath = "//input[@name='title']")
	WebElement title;
	
	@FindBy (name = "description")
	WebElement description;
	
	@FindBy (name = "amount")
	WebElement amount;
	
	@FindBy (name = "probability")
	WebElement probability;
	
	@FindBy (xpath = "//button[contains(text(),'Save')]")
	WebElement Save;
	
	public DealsPage() {
		PageFactory.initElements(driver, this);		
	}
	
	public boolean verifyDealslabel() {
		return dealslabel.isDisplayed();
	}
	
	public boolean verifypipelinelabel() {
		return pipelinelabel.isDisplayed();
	}
	
	public boolean verifyBoardlink() {
		return boardlabel.isDisplayed();
	}
	
	public void CreateNewDeal (String ti, String de, String am, String po) throws InterruptedException {
		title.sendKeys(ti);
		description.sendKeys(de);
		amount.sendKeys(am);
		probability.sendKeys(po);
		Thread.sleep(2000);
		Save.click();
	}
}

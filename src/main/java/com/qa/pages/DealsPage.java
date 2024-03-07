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
}

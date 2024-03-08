/*
 * author : Akanksha
 * 
 */

package com.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy (xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactslabel;
	
	@FindBy (xpath = "//button[contains(text(),'Create')]")
	WebElement createbutton;
	
	@FindBy (name = "first_name")
	WebElement firstname;
	
	@FindBy (name = "last_name")
	WebElement lastname;
	
	@FindBy (xpath = "//input[@placeholder='Email address']")
	WebElement email;
	
	@FindBy (xpath ="//input[@name='address']")
	WebElement address;
	
	@FindBy (xpath ="//input[@name='city']")
	WebElement city;
	
	@FindBy (xpath ="//input[@name='state']")
	WebElement state;
	
	@FindBy (xpath = "//button[contains(text(),'Save')]")
	WebElement Save;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);		
	}
	
	public boolean verifyContactslabel() {
		return contactslabel.isDisplayed();
	}
	
	public boolean verifyCreateContactsButtion() {
		return createbutton.isDisplayed();
	}
	
	public void CreateNewContact(String ftn, String ltn, String e, String add, String ci, String st) throws InterruptedException {
		firstname.sendKeys(ftn);
		lastname.sendKeys(ltn);
		email.sendKeys(e);
		address.sendKeys(add);
		city.sendKeys(ci);
		state.sendKeys(st);
		Thread.sleep(2000);
		Save.click();
	}
	}


package com.qa.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//div[@class='header item']")
	//@CacheLookup (stores this webelement in a cache memory)
	WebElement logo;
	
	@FindBy(xpath = "//span[contains(text(),'Akanksha Gupta')]")
	WebElement usernamelabel;
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy (xpath = "//button[contains(text(),'Create')]")
	WebElement createbutton;
	
	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath = "//div[@id='main-nav']//a")
	List<WebElement> sidebar;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();	
	}
	
	public boolean VerifyLogo() {
		return logo.isDisplayed();
	}
	
	public boolean VerifyCorrectusername() {
		return usernamelabel.isDisplayed();
	}
	
	public void printSidebarLinkNames() {
        for (WebElement link : sidebar) {
        	System.out.println(link.getSize());
            String linkText = link.getText();
            System.out.println("Sidebar Links Names: " + linkText);
        }
	}
	
     public ContactsPage clickonContactsLink() {
        contactsLink.click();
        return new ContactsPage();
        }
     
     public DealsPage clickonDealsLink() {
         dealsLink.click();
         return new DealsPage();
         }
     
     public TasksPage clickonTasksLink() {
         tasksLink.click();
         return new TasksPage();
         }
     
     public void ClickOnCreateContactLink() {
    	 contactsLink.click();
    	 createbutton.click();
     }
	
}
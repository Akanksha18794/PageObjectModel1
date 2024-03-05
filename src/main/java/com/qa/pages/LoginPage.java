package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {
    
    // PageFactory - OR:
    
    @FindBy(xpath = "//span[contains(text(),'Log In')]")
    public WebElement Login;
    
    @FindBy(name = "email")
    public WebElement username;
    
    @FindBy(name = "password")
    public WebElement password;
    
    @FindBy(xpath = "//div[contains(text(),'Login')]")
    public WebElement signin;
    
    @FindBy(xpath = "//a[@title='free crm home'][1]")
    public WebElement Logo;
    
    public LoginPage() {
    	PageFactory.initElements(driver, this);
    }
    
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }
    
    public boolean validateCRMLogo() {
    	return Logo.isDisplayed();
    }
    
    public HomePage login(String a , String b) throws InterruptedException {
    	Login.click();
    	Thread.sleep(3000);
    	username.sendKeys(a);
    	password.sendKeys(b);
    	signin.click();
    	
    	return new HomePage();
    }	
}

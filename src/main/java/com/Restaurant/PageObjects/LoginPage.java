package com.Restaurant.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.BaseClass;

public class LoginPage extends BaseClass {
	//WebDriver driver;
	
	@FindBy(xpath="//img[@alt='logo']")
	WebElement Logo;
	
	@FindBy(xpath="//h1[contains(text(),Login)]")
	WebElement LoginText;
	
	@FindBy(name="username")
	WebElement Username;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath="//input[@name='submit']")
	WebElement Login;
	
	@FindBy(xpath="//i[@class='fa fa-sign-out fa-lg']")
	WebElement Logout;
	
	@FindBy(xpath="//span[contains(text(),'POS')]")
	WebElement pos;
	
	
	public LoginPage() {
		//this.driver=driver;
		PageFactory.initElements(getDriver(), this);
	}
	
	public WebElement LogoDisplay() {
		return Logo;
	}
	
	public WebElement LogText() {
		return LoginText;
	}
	
	public WebElement Uname() {
		return Username;
	}
	
	public WebElement Pswd() {
		return Password;
	}
	
	public WebElement LogButton() {
		return Login;
	}
	
	public WebElement LogoutButton() {
		return Logout;
	}
	
	public WebElement posClick() {
		return pos;
	}
	
	
	
	
	//Method to check whether the Login page is loaded properly
	//If present will get True else will get False
	public Boolean IsLogoPresent() {
		return action.isDisplayed(getDriver(), Logo);
		//return LogoDisplay().isDisplayed();	
	
	}
	
	public Boolean IsPosPresent() {
		return action.isDisplayed(getDriver(), pos);
		//Boolean result=driver.findElement(By.xpath("(//span[@class='menu-text'])[1]")).isDisplayed();
		//return result;
	}
	public void Login(String username, String password) {
		action.type(Uname(), username);
		action.type(Pswd(), password);
		action.click1(Login, "Clicking on login button");
	}
	
	public void PageLogin() {
		action.type(Username, prop.getProperty("Username"));
		action.type(Password, prop.getProperty("Password"));
		action.click1(Login, "Clicking on login button");
		//action.click1(Logout, "Logging out");
		
		
	}
	
	
	public void InvalidPageLogin(String Uname, String Pword) {
		action.type(Username, Uname);
		action.type(Password, Pword);
		action.click1(Login, "Clicking on login button");
		
		
	}
	
	public void LogoutClick() {
		action.click1(Logout, "Logging out");
		
	}
	
	public Boolean IsLoginTextPresent() {
		return action.isDisplayed(getDriver(), LoginText);
	}

}

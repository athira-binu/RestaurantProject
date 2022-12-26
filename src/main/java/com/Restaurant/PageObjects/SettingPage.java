package com.Restaurant.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.BaseClass.BaseClass;

public class SettingPage extends BaseClass{
	//WebDriver driver;
	
	@FindBy(xpath="//i[@class='fa fa-cogs']")
	WebElement Setting;
	
	@FindBy(xpath="//h1[text()='Settings']")
	WebElement SettingsPage;
	
	public SettingPage() {
		//this.driver=driver;
		PageFactory.initElements(getDriver(), this);
		
	}

	public WebElement Setting() {
		return Setting;
	}
	
	public WebElement SettingsPage() {
		return SettingsPage;
	}
	
	public Boolean IsSettingsPresent() {
		return action.isDisplayed(getDriver(), SettingsPage);
	}
	
	public void SettingClick() {
		action.click1(Setting, "Not Clicked on Setting");
	}

}

package com.Restaurant.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.BaseClass.BaseClass;

public class SalesPage extends BaseClass{
	
	@FindBy(xpath="//span[text()='Sales']")
	WebElement SalesBtn;
	
	@FindBy(xpath="//h3[text()='Sales']")
	WebElement SalesText;
	
	public WebElement SalesBtn() {
		return SalesBtn;
	}
	
	public WebElement SalesText() {
		return SalesText;
	}
	
	public SalesPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void ClickSales() {
		action.click1(SalesBtn, "Clicking on Sales");
	}
	
	public Boolean IsSalesPresent() {
		action.explicitWait(getDriver(), SalesText, Duration.ofSeconds(20));
		return action.isDisplayed(getDriver(), SalesText);
	}

}

package com.Restaurant.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.BaseClass;

public class HomePage extends BaseClass {
	//WebDriver driver;
	
	@FindBy(xpath="(//span[@class='caret'])[3]")
	WebElement dropdown;
	
	@FindBy(xpath="//a[text()=' English']")
	WebElement English;
	
	@FindBy(xpath="(//li[@class='flat-box waves-effect waves-block'])[14]")
	WebElement French;
	
	@FindBy(xpath="//a[text()=' Portuguese']")
	WebElement Portuguese;
	
	@FindBy(xpath="//a[text()=' Spanish']")
	WebElement Spanish;
	
	@FindBy(xpath="//a[text()=' العربية']")
	WebElement Arab;
	
	//Choose a store in portugese
	@FindBy(xpath="//h1[contains(text(),' Escolha uma loja ')]")
	WebElement PortugeseStore;
	
	@FindBy(xpath="//h1[contains(text(),' Choose a store ')]")
	WebElement EnglishStore;
	
	@FindBy(xpath="//h1[contains(text(),' Choisissez un boutique ')]")
	WebElement FrenchStore;
	
	public HomePage() {
		//this.driver=driver;
		PageFactory.initElements(getDriver(), this);
		
	}

	public WebElement dropdownLang() {
	return dropdown;	
	}
	
	public WebElement dropEnglish() {
	return English;	
	}
	
	public WebElement dropFrench() {
		return French;
	}
	
	public WebElement dropPortuguese() {
		return Portuguese;
	}
	
	public WebElement dropSpanish() {
		return Spanish;
	}
	
	public WebElement dropArab() {
		return Arab;
	}	
	
	public WebElement portugeseStoreCheck() {
		return PortugeseStore;
	}
	
	public WebElement EnglishStoreCheck() {
		return EnglishStore;
	}
	
	public WebElement FrenchStoreCheck() {
		return FrenchStore;
	}
	
	/*public void dropdown() {
	List<WebElement> DropValues = driver.findElements(By.xpath("//li[@class='flat-box waves-effect waves-block']"));
	for(WebElement opt:DropValues) {
		System.out.println(opt.getText());
	}
}*/
	public Boolean IsPortugeseStorePresent() {
		action.explicitWait(getDriver(), PortugeseStore, Duration.ofSeconds(20));
		return action.isDisplayed(getDriver(), PortugeseStore);
	}
	
	public Boolean IsEnglishStorePresent() {
		action.explicitWait(getDriver(), EnglishStore, Duration.ofSeconds(20));
		return action.isDisplayed(getDriver(), EnglishStore);
	}
	
	public Boolean IsFrenchStorePresent() {
		action.explicitWait(getDriver(), FrenchStore, Duration.ofSeconds(20));
		return action.isDisplayed(getDriver(), FrenchStore);
	}
	
	public void clickPortugeseLanguage() {
		action.click1(dropdown, "Clicking on Dropdown");
		action.click1(Portuguese, "Clicking on Portugese");
		//dropdown.click();
		//Portuguese.click();
	}
	public void clickEnglishLanguage() {
		action.click1(dropdown, "Clicking on Dropdown");
		action.click1(English, "Clicking on English");
		//dropdown.click();
		//English.click();
	}
	public void clickFrenchLanguage() {
		action.click1(dropdown, "Clicking on Dropdown");
		action.click1(French, "Clicking on French");
		//dropdown.click();
		//French.click();
	}
}

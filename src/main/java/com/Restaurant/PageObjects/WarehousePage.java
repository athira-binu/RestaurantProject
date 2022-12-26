package com.Restaurant.PageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.BaseClass.BaseClass;

public class WarehousePage extends BaseClass{
	
	@FindBy(xpath="//a[contains(text(),'Warehouses')]")
	WebElement Warehouse;
	
	@FindBy(xpath="//button[contains(text(),'Add Warehouse')]")
	WebElement AddWarehouse;
	
	@FindBy(xpath="//input[@id='WarehouseName']")
	WebElement WarehouseName;
	
	@FindBy(xpath="//input[@id='WarehousePhone']")
	WebElement WarehousePhone;
	
	@FindBy(xpath="(//input[@id='email'])[2]")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='Adresse']")
	WebElement Address;
	
	@FindBy(xpath="(//button[text()='Submit'])[3]")
	WebElement Submit;
	
	@FindBy(xpath="(//table[@class='table']/tbody/tr[6]/td[1])[2]")
	WebElement WarehouseA;
	
	@FindBy(xpath="(//i[@class='fa fa-pencil'])[36]")
	WebElement Edit;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement EditSubmit;
	
	@FindBy(xpath="(//i[@class='fa fa-times'])[35]")
	WebElement Delete;
	
	public WebElement WarehouseBtn() {
		return Warehouse;
	}
	
	public WebElement AddWarehouseBtn() {
		return AddWarehouse;
	}
	
	public WebElement WarehouseName() {
		return WarehouseName;
	}
	
	public WebElement WarehousePhone() {
		return WarehousePhone;
	}
	
	public WebElement WarehouseEmail() {
		return Email;
	}
	
	public WebElement WarehouseAdress() {
		return Address;
	}
	
	public WebElement WarehouseSubmit() {
		return Submit;
	}
	
	public WebElement EditBtn() {
		return Edit;
	}
	
	public WebElement EditSubmitBtn() {
		return EditSubmit;
	}
	
	public WebElement WarehouseDeleteBtn() {
		return Delete;
	}
	
	public WarehousePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickWarehouse() {
		action.click1(Warehouse, "Clicking on Warehouse");
	}
	
	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", AddWarehouse);
	}
	
	public Boolean IsAddWarehousePresent() {
		return action.isDisplayed(getDriver(), AddWarehouse);
	}
	
	public void AddWarehouse() {
		
		action.click1(AddWarehouse, "Clicking on Add Warehouse");
		action.explicitWait(getDriver(), WarehouseName, Duration.ofSeconds(20));
		action.type(WarehouseName, "StorageHouse");
		action.type(WarehousePhone, "7902458623");
		action.type(Email, "abc@gmail.com");
		action.type(Address, "India");
		action.click1(Submit, "Clicking on Submit button");
	}
	
	public String CheckWarehouseAdded() {
		action.explicitWait(getDriver(), WarehouseA, Duration.ofSeconds(20));
		String name = WarehouseA.getText();
		return name;
	}
	
	public void EditWarehouse() {
		action.click1(Edit, "Clicking on Edit");
		action.type(WarehouseName, "Storageroom");
		action.click1(EditSubmit, "Clicking on Submit button in Edit page");
	}
	
	public String checkEditedName() {
		action.explicitWait(getDriver(), WarehouseA, Duration.ofSeconds(20));
		String EditedName=WarehouseA.getText();
		return EditedName;
	}
	
	public void DeleteWarehouse() {
		action.click1(Delete, "Deleting Warehouse");
	}
	
	public Boolean CheckWarehousePresent() {
		return action.isDisplayed(getDriver(), WarehouseA);
	}

}

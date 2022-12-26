package com.Restaurant.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.BaseClass.BaseClass;

public class SuppliersPage extends BaseClass{
	
	public SuppliersPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//span[text()='People']")
	WebElement People;
	
	@FindBy(xpath="//span[text()='Suppliers']")
	WebElement Suppliers;
	
	@FindBy(xpath="//button[contains(text(),'Add Supplier')]")
	WebElement AddSupplier;
	
	@FindBy(xpath="//input[@id='SupplierName']")
	WebElement SupplierName;
	
	@FindBy(xpath="//input[@id='SupplierPhone']")
	WebElement SupplierPhone;
	
	@FindBy(xpath="//input[@id='SupplierEmail']")
	WebElement SupplierEmail;
	
	@FindBy(xpath="//button[@class='btn btn-add']")
	WebElement Submit;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement Search;
	
	@FindBy(xpath="//table[@id='Table']/tbody/tr[1]/td[1]")
	WebElement nameA;
	
	@FindBy(xpath="//table[@id='Table']/tbody/tr[1]/td[2]")
	WebElement Phone;
	
	@FindBy(xpath="//i[@class='fa fa-pencil']")
	WebElement Edit;
	
	@FindBy(xpath="//i[@class='fa fa-times']")
	WebElement Delete;
	
	@FindBy(xpath="//a[@class='btn btn-danger']")
	WebElement ConfirmDelete;
	
	public void ClickPeople() {
		action.click1(People, "Clicking on People");
	}
	
	public void ClickSuppliers() {
		action.click1(Suppliers, "Clicking on Waiters");
	}
	
	public Boolean IsAddSupplierPresent() {
		action.explicitWait(getDriver(), AddSupplier, Duration.ofSeconds(20));
		return action.isDisplayed(getDriver(), AddSupplier);
	}
	
	public void AddSupplierDetails() {
		ClickPeople();
		ClickSuppliers();
		action.click1(AddSupplier, "Clicking on Add Supplier");
		action.type(SupplierName, "Jeena");
		action.type(SupplierPhone, "1234567890");
		action.type(SupplierEmail, "bgy@gmail.com");
		action.click1(Submit, "Clicking on Submit");
		action.type(Search, "Jeena");
	}
	
	public String CompareName() {
		String name=nameA.getText();
		return name;
	}
	
	public void Edit() {
		ClickPeople();
		ClickSuppliers();
		action.type(Search, "Jeena");
		action.click1(Edit, "Clicking on Edit button");
		action.type(SupplierPhone, "9876543210");
		action.click1(Submit, "Clicking on Submit button");
		action.type(Search, "Jeena");
	}
	
	public String ComparePhone() {
		String NewPhone = Phone.getText();
		return NewPhone;
	}
	
	public void Delete() {
		ClickPeople();
		ClickSuppliers();
		action.type(Search, "Jeena");
		action.click1(Delete, "Clicking on Delete button");
		action.click1(ConfirmDelete, "Clicking on Confirm Delete");
		action.type(Search, "Jeena");
	}
	
	public Boolean IsSupplierPresent() {
		return action.isDisplayed(getDriver(), Phone);
	}

}

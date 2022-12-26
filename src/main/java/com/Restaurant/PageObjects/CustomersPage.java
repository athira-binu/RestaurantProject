package com.Restaurant.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.BaseClass.BaseClass;

public class CustomersPage extends BaseClass{
	
	public CustomersPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//span[text()='People']")
	WebElement People;
	
	@FindBy(xpath="//span[text()='Customers']")
	WebElement Customers;
	
	@FindBy(xpath="//button[contains(text(),'Add Customer')]")
	WebElement AddCustomers;
	
	@FindBy(xpath="//input[@id='CustomerName']")
	WebElement CustomerName;
	
	@FindBy(xpath="//input[@id='CustomerPhone']")
	WebElement CustomerPhone;
	
	@FindBy(xpath="//input[@id='CustomerEmail']")
	WebElement CustomerEmail;
	
	@FindBy(xpath="//input[@id='CustomerDiscount']")
	WebElement Discount;
	
	@FindBy(xpath="//button[@class='btn btn-add']")
	WebElement Submit;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement Search;
	
	@FindBy(xpath="//table[@id='Table']/tbody/tr[1]/td[1]")
	WebElement nameA;
	
	@FindBy(xpath="//i[@class='fa fa-pencil']")
	WebElement Edit;
	
	@FindBy(xpath="//i[@class='fa fa-times']")
	WebElement Delete;
	
	@FindBy(xpath="//a[@class='btn btn-danger']")
	WebElement ConfirmDelete;
	
	@FindBy(xpath="//table[@id='Table']/tbody/tr[1]/td[2]")
	WebElement Phone;
	
	public void ClickPeople() {
		action.click1(People, "Clicking on People");
	}
	
	public void ClickCustomers() {
		action.click1(Customers, "Clicking on Customers");
	}
	
	public Boolean IsAddCustomerPresent() {
		action.explicitWait(getDriver(), AddCustomers, Duration.ofSeconds(20));
		return action.isDisplayed(getDriver(), AddCustomers);
	}
	
	public void AddCustomerDetails() {
		ClickPeople();
		ClickCustomers();
		action.click1(AddCustomers, "Clicking on Add Customer");
		action.type(CustomerName, "Sachin");
		action.type(CustomerPhone, "7856312598");
		action.type(CustomerEmail, "ahg@gmail.com");
		action.type(Discount, "20");
		action.click1(Submit, "Clicking on Submit");
	}
	
	public void SearchName() {
		action.explicitWait(getDriver(), Search, Duration.ofSeconds(20));
		action.type(Search, "Sachin");
	}
	
	public String CustomerName() {
		String name = nameA.getText();
		return name;
	}
	
	public void Edit() {
		ClickPeople();
		ClickCustomers();
		action.click1(AddCustomers, "Clicking on Add Customer");
		action.type(CustomerName, "Sid");
		action.click1(Submit, "Clicking on Submit");
		action.type(Search, "Sid");
	}
	
	public void Delete() {
		ClickPeople();
		ClickCustomers();
		action.type(Search, "Sid");
		action.click1(Delete, "Clicking delete");
		action.click1(ConfirmDelete, "Clicking on confirm delete");
		action.type(Search, "Sid");
	}
	
	public Boolean IsCustomerPresent() {
		return action.isDisplayed(getDriver(), Phone);
	}

}

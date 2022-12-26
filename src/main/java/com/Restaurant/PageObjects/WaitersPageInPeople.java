package com.Restaurant.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Restaurant.BaseClass.BaseClass;

public class WaitersPageInPeople extends BaseClass{
	
	public WaitersPageInPeople() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//span[text()='People']")
	WebElement People;
	
	@FindBy(xpath="//span[text()='Waiters']")
	WebElement Waiters;
	
	@FindBy(xpath="//button[contains(text(),'Add Waiter')]")
	WebElement AddWaiter;
	
	@FindBy(xpath="//input[@id='WaiterName']")
	WebElement WaiterName;
	
	@FindBy(xpath="//input[@id='WaiterPhone']")
	WebElement WaiterPhone;
	
	@FindBy(xpath="//input[@id='WaiterEmail']")
	WebElement WaiterEmail;
	
	@FindBy(xpath="//select[@id='WaiterStore']")
	WebElement WaiterStore;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement SearchBox;
	
	@FindBy(xpath="//table[@id='Table']/tbody/tr[1]/td[1]")
	WebElement nameA;
	
	@FindBy(xpath="//table[@id='Table']/tbody/tr[1]/td[3]")
	WebElement newEmail;
	
	@FindBy(xpath="//i[@class='fa fa-pencil']")
	WebElement Edit;
	
	@FindBy(xpath="//i[@class='fa fa-times']")
	WebElement Delete;
	
	@FindBy(xpath="//a[@class='btn btn-danger']")
	WebElement DeletePopup;
	
	public void SelectStore() {
		Select sle = new Select(WaiterStore);
		sle.selectByVisibleText("Taj");
	}
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement WaiterSubmit;
	
	public void ClickPeople() {
		action.click1(People, "Clicking on People");
	}
	
	public void ClickWaiter() {
		action.click1(Waiters, "Clicking on Waiters");
	}
	
	public Boolean IsAddWaiterPresent() {
		action.explicitWait(getDriver(), AddWaiter, Duration.ofSeconds(20));
		return action.isDisplayed(getDriver(), AddWaiter);
	}
	
	public void AddWaiterdetails() {
		ClickPeople();
		ClickWaiter();
		action.click1(AddWaiter, "Clicking on Add Waiter");
		action.type(WaiterName, "Rahul");
		action.type(WaiterPhone, "7902365875");
		action.type(WaiterEmail, "ath@gmail.com");
		action.click1(WaiterStore, "Clicking on Waiter Store");
		SelectStore();
		action.click1(WaiterSubmit, "Clicking on Submit button");
	}
	
	public void SearchName() {
		action.explicitWait(getDriver(), SearchBox, Duration.ofSeconds(20));
		action.type(SearchBox, "Rahul");
	}
	
	public String CompareName() {
		action.explicitWait(getDriver(), nameA, Duration.ofSeconds(20));
		String name = nameA.getText();
		return name;
	}
	
	public void Edit() {
		ClickPeople();
		ClickWaiter();
		SearchName();
		action.click1(Edit, "Clicking on edit button");
		action.type(WaiterEmail, "rahul@gmail.com");
		action.click1(WaiterSubmit, "Clicking on Submit button");
		SearchName();
	}
	
	public String EditedMail() {
		action.explicitWait(getDriver(), newEmail, Duration.ofSeconds(20));
		String ActualEmail=newEmail.getText();
		return ActualEmail;
	}

	public void DeleteWaiter() {
		ClickPeople();
		ClickWaiter();
		SearchName();
		action.click1(Delete, "Clicking on Delete");
		action.click1(DeletePopup, "Deleting waiter");
		SearchName();
	}
	
	public Boolean IsWaiterPresent() {
		return action.isDisplayed(getDriver(), newEmail);
	}
	
}

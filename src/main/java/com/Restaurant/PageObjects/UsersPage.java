package com.Restaurant.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.BaseClass.BaseClass;

public class UsersPage extends BaseClass{
	//WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),' Users')]")
	WebElement Users;
	
	@FindBy(xpath="//button[contains(text(),'Add User')]")
	WebElement AddUser;
	
	@FindBy(id="username")
	WebElement Username;
	
	@FindBy(id="firstname")
	WebElement Firstname;
	
	@FindBy(id="lastname")
	WebElement Lastname;
	
	@FindBy(xpath="//input[@value='admin']")
	WebElement Admin;
	
	@FindBy(xpath="//input[@value='sales']")
	WebElement SalesStaff;
	
	@FindBy(xpath="//input[@value='waiter']")
	WebElement Waiter;
	
	@FindBy(xpath="//input[@value='kitchen']")
	WebElement Kitchen;
	
	@FindBy(xpath="(//input[@name='email'])[1]")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@id='confirm_password']")
	WebElement ConfirmPassword;
	
	@FindBy(xpath="(//button[text()='Submit'])[2]")
	WebElement Submit;
	
	@FindBy(xpath="(//button[text()='Close'])[1]")
	WebElement Close;
	
	@FindBy(xpath="(//i[@class='fa fa-pencil'])[32]")
	WebElement Edit;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement EditSubmit;
	
	@FindBy(xpath="(//table[@class='table']/tbody/tr[33]/td[3])[1]")
	WebElement EditedContent;
	
	@FindBy(xpath="(//i[@class='fa fa-times'])[31]")
	WebElement Delete;
	
	@FindBy(xpath="(//table[@class='table']/tbody/tr[33]/td[2])[1]")
	WebElement a;
	
	public WebElement Users() {
		return Users;
	}
	
	public WebElement AddUser() {
		return AddUser;
	}
	
	public WebElement Username() {
		return Username;
	}
	
	public WebElement Firstname() {
		return Firstname;
	}
	
	public WebElement Lastname() {
		return Lastname;
	}
	
	public WebElement Admin() {
		return Admin;
	}
	
	public WebElement SalesStaff() {
		return SalesStaff;
	}
	
	public WebElement Waiter() {
		return Waiter;
	}
	
	public WebElement Kitchen() {
		return Kitchen;
	}
	
	public WebElement Email() {
		return Email;
	}
	
	public WebElement Password() {
		return Password;
	}
	
	public WebElement ConfirmPassword() {
		return ConfirmPassword;
	}
	
	public WebElement Submit() {
		return Submit;
	}
	
	public WebElement Close() {
		return Close;
	}
	
	public WebElement EditBtn() {
		return Edit;
	}
	
	public WebElement EditSubmitBtn() {
		return EditSubmit;
	}
	
	public WebElement DeleteBtn() {
		return Delete;
	}
	
	public void UserClick() {
		action.click1(Users, "Clicking on User button");
	}
	
	public void AddUserClick() {
		action.click1(AddUser, "Clicking on Add User button");
	}
	
	public UsersPage() {
		//this.driver=driver;
		PageFactory.initElements(getDriver(), this);
		// TODO Auto-generated constructor stub
	}

		
	public Boolean IsAddUserPresent() {
		action.moveToElement(getDriver(), AddUser);
		return action.isDisplayed(getDriver(), AddUser);
	}
	
	public void CreateNewUser() {
		action.type(Username, "Admin");
		action.type(Firstname, "Ram");
		action.type(Lastname, "Siv");
		action.click1(SalesStaff, "Clicking on SalesStaff");
		action.type(Email, "abc@gmail.com");
		action.type(Password, "qwerty");
		action.type(ConfirmPassword, "qwerty");
		action.click1(Submit, "Clicking on submit button");
	}
	
	public String checkUserAdded() {
		action.explicitWait(getDriver(), a, Duration.ofSeconds(20));
			String name = a.getText();
			return name;
			
		}
		
	public void EditUser() {
		action.click1(Edit, "Clicking on Edit button");
		action.type(Lastname, "Das");
		action.click1(EditSubmit, "Clicking on Submit button in the Edit page");
	}	
	
	public String checkEditUser() {
		action.explicitWait(getDriver(), EditedContent, Duration.ofSeconds(20));
		String EditedName = EditedContent.getText();
		return EditedName;
	}
	
	public void ClickDelete() {
		action.click1(Delete, "Deleting the user");
	}
	
	public Boolean CheckUserPresent() {
		return action.isDisplayed(getDriver(), a);
	}
}

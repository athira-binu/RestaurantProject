package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.BaseClass;
import com.Restaurant.PageObjects.LoginPage;
import com.Restaurant.PageObjects.SettingPage;
import com.Restaurant.PageObjects.UsersPage;
import com.Restaurant.Utilities.Log;

public class VerifyUsersPageInSettings extends BaseClass{
	@Test(priority=1)
	public void VerifyUsersTable() throws InterruptedException {
		Log.startTestCase("VerifyUsersTable");
		Lp.PageLogin();
		Sp1.SettingClick();
		Up.UserClick();
		Assert.assertTrue(Up.IsAddUserPresent(),"Add User is not displayed");
		Log.endTestCase("VerifyUsersTable");
		
	}
	
	@Test(priority=2)
	public void VerifyCreateNewUser() throws InterruptedException {
		Log.startTestCase("VerifyCreateNewUser");
		Lp.PageLogin();
		Sp1.SettingClick();
		Up.UserClick();
		Up.AddUserClick();
		Up.CreateNewUser();
		Assert.assertTrue(Up.checkUserAdded().equals("Ram"));
		Log.endTestCase("VerifyCreateNewUser");
	}
	@Test(priority=3)
	public void VerifyEditUser() throws InterruptedException {
		Log.startTestCase("VerifyEditUser");
		Lp.PageLogin();
		Sp1.SettingClick();
		Up.UserClick();
		Up.EditUser();
		Assert.assertTrue(Up.checkEditUser().equals("Das"));
		Log.endTestCase("VerifyEditUser");
	}
	@Test(priority=4)
	public void VerifyDeleteUser() throws InterruptedException {
		Log.startTestCase("VerifyDeleteUser");
		Lp.PageLogin();
		Sp1.SettingClick();
		Up.UserClick();
		Up.ClickDelete();
		Assert.assertFalse(Up.CheckUserPresent(), "User is present");
		Log.endTestCase("VerifyDeleteUser");
	}

}

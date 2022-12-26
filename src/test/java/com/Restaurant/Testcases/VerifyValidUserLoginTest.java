package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.BaseClass;
import com.Restaurant.PageObjects.LoginPage;
import com.Restaurant.Utilities.Log;

public class VerifyValidUserLoginTest extends BaseClass {
	@Test(groups= {"SMK"},priority=1)
	@Parameters({"Username","Password"})
	public void VerifyUserLogin(String Username,String Password) {
		Log.startTestCase("VerifyUserLogin");
		Assert.assertTrue(Lp.IsLogoPresent(),"Login page is not loaded");
		Lp.Login(Username, Password);
		Assert.assertTrue(Lp.IsPosPresent(),"Home page is not loaded");
		Lp.LogoutClick();
		Log.endTestCase("VerifyUserLogin");
	}
	@Test(dataProvider="InvaidLoginDetails",priority=2)
	public void VerifyInvalidUserLogin(String Uname,String Pword ) {
		Log.startTestCase("VerifyInvalidUserLogin");
		Assert.assertTrue(Lp.IsLogoPresent(),"Login page is not loaded");
		Lp.InvalidPageLogin(Uname, Pword);
		Log.endTestCase("VerifyInvalidUserLogin");
		}
	@Test(priority=3)
	public void VerifyLogout() throws InterruptedException {
		Log.startTestCase("VerifyLogout");
		Lp.PageLogin();
		Lp.LogoutClick();
		Thread.sleep(3000);
		Assert.assertTrue(Lp.IsLoginTextPresent(), "Login is not present");
		Log.endTestCase("VerifyLogout");
	}

}

package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.BaseClass;
import com.Restaurant.PageObjects.LoginPage;
import com.Restaurant.PageObjects.WaitersPageInPeople;
import com.Restaurant.Utilities.Log;

public class VerifyWaitersPageInPeople extends BaseClass{
	@Test(priority=1)
	public void VerifyPeople() throws InterruptedException {
		Log.startTestCase("VerifyPeople");
		Lp.PageLogin();
		Wp.ClickPeople();
		Wp.ClickWaiter();
		Assert.assertTrue(Wp.IsAddWaiterPresent(), "Add Waiter is not present");
		Log.endTestCase("VerifyPeople");
	}
	@Test(priority=2)
	public void VerifyAddWaiterDetails() throws InterruptedException {
		Log.startTestCase("VerifyPeople");
		LoginPage Lp= new LoginPage();
		Lp.PageLogin();
		Wp.AddWaiterdetails();
		Wp.SearchName();
		Assert.assertTrue(Wp.CompareName().equals("Rahul"));
		Log.endTestCase("VerifyPeople");
	}
	@Test(priority=3,enabled=true)
	public void VerifyEditDetails() throws InterruptedException {
		Log.startTestCase("VerifyPeople");
		Lp.PageLogin();
		Wp.Edit();
		Assert.assertTrue(Wp.EditedMail().equals("rahul@gmail.com"));
		Log.endTestCase("VerifyPeople");
	}
	@Test(dependsOnMethods= {"VerifyEditDetails"},retryAnalyzer = com.Restaurant.Utilities.ReRunAutomation.class)
	public void VerifyDeleteWaiter() throws InterruptedException {
		Lp.PageLogin();
		Wp.DeleteWaiter();
		Assert.assertFalse(Wp.IsWaiterPresent(), "Waiter is present");
	}

}

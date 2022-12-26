package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.BaseClass;
import com.Restaurant.Utilities.Log;

public class VerifyCustomersPageInPeople extends BaseClass{
	@Test(priority=1)
	public void VerifyCustomers() {
		Log.startTestCase("VerifyCustomers");
		Lp.PageLogin();
		Cp.ClickPeople();
		Cp.ClickCustomers();
		Assert.assertTrue(Cp.IsAddCustomerPresent(), "Add Customer is present");
		Log.endTestCase("VerifyCustomers");
		
	}
	@Test(priority=2)
	public void VerifyAddCustomerDetails() throws InterruptedException {
		Log.startTestCase("VerifyAddCustomerDetails");
		Lp.PageLogin();
		Cp.AddCustomerDetails();
		Cp.SearchName();
		Assert.assertTrue(Cp.CustomerName().equals("Sachin"));
		Log.endTestCase("VerifyAddCustomerDetails");
	}
	@Test(priority=3)
	public void VerifyEditCustomer() {
		Log.startTestCase("VerifyEditCustomer");
		Lp.PageLogin();
		Cp.Edit();
		Assert.assertTrue(Cp.CustomerName().equals("Sid"));
		Log.endTestCase("VerifyEditCustomer");
	}
	@Test(priority=4)
	public void VerifyDeleteCustomer() {
		Log.startTestCase("VerifyDeleteCustomer");
		Lp.PageLogin();
		Cp.Delete();
		Assert.assertFalse(Cp.IsCustomerPresent(),"Customer is present");
		Log.endTestCase("VerifyDeleteCustomer");
	}

}

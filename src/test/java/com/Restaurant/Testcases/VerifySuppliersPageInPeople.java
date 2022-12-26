package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.BaseClass;
import com.Restaurant.Utilities.Log;

public class VerifySuppliersPageInPeople extends BaseClass{
	@Test(priority=1)
	public void VerifySuppliers() {
		Log.startTestCase("VerifySuppliers");
		Lp.PageLogin();
		Sp2.ClickPeople();
		Sp2.ClickSuppliers();
		Assert.assertTrue(Sp2.IsAddSupplierPresent(), "Add Supplier is not Present");
		Log.endTestCase("VerifySuppliers");
	}
	@Test(priority=2)
	public void VerifyAddSupplierDetails() {
		Log.startTestCase("VerifyAddSupplierDetails");
		Lp.PageLogin();
		Sp2.AddSupplierDetails();
		Assert.assertTrue(Sp2.CompareName().equals("Jeena"));
		Log.endTestCase("VerifyAddSupplierDetails");
	}
	@Test(priority=3)
	public void VerifyEditSuppliers() {
		Log.startTestCase("VerifyEditSuppliers");
		Lp.PageLogin();
		Sp2.Edit();
		Assert.assertTrue(Sp2.ComparePhone().equals("9876543210"));
		Log.endTestCase("VerifyEditSuppliers");
	}
	@Test(priority=4)
	public void VerifyDeleteSuppliers() {
		Log.startTestCase("VerifyDeleteSuppliers");
		Lp.PageLogin();
		Sp2.Delete();
		Assert.assertFalse(Sp2.IsSupplierPresent(),"Supplier is present");
		Log.endTestCase("VerifyDeleteSuppliers");
	}

}

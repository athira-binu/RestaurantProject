package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.BaseClass;
import com.Restaurant.PageObjects.LoginPage;
import com.Restaurant.PageObjects.SettingPage;
import com.Restaurant.PageObjects.WarehousePage;
import com.Restaurant.Utilities.Log;

public class VerifyWarehousePageInSettings extends BaseClass{
	@Test(priority=1)
	public void VerifyWarehouse() throws InterruptedException {
		Log.startTestCase("VerifyUsersTable");
		LoginPage Lp= new LoginPage();
		Lp.PageLogin();
		SettingPage Sp = new SettingPage();
		Sp.SettingClick();
		WarehousePage Wp = new WarehousePage();
		Wp.clickWarehouse();
		Assert.assertTrue(Wp.IsAddWarehousePresent(), "Add Warehouse is not present");
		Log.endTestCase("VerifyUsersTable");
	}
	@Test(priority=2)
	public void VerifyCreateWarehouse() throws InterruptedException {
		Log.startTestCase("VerifyCreateWarehouse");
		LoginPage Lp= new LoginPage();
		Lp.PageLogin();
		SettingPage Sp = new SettingPage();
		Sp.SettingClick();
		WarehousePage Wp = new WarehousePage();
		Wp.clickWarehouse();
		Wp.AddWarehouse();
		Assert.assertTrue(Wp.CheckWarehouseAdded().equals("StorageHouse"));
		Log.endTestCase("VerifyCreateWarehouse");
	}
	@Test(priority=3)
	public void VerifyEditWarehouse() {
		Log.startTestCase("VerifyCreateWarehouse");
		LoginPage Lp= new LoginPage();
		Lp.PageLogin();
		SettingPage Sp = new SettingPage();
		Sp.SettingClick();
		WarehousePage Wp = new WarehousePage();
		Wp.clickWarehouse();
		Wp.EditWarehouse();
		Assert.assertTrue(Wp.checkEditedName().equals("Storageroom"));
		Log.endTestCase("VerifyCreateWarehouse");
	}
	@Test(priority=4)
	public void VerifyDeleteWarehouse() throws InterruptedException {
		Log.startTestCase("VerifyDeleteWarehouse");
		LoginPage Lp= new LoginPage();
		Lp.PageLogin();
		SettingPage Sp = new SettingPage();
		Sp.SettingClick();
		WarehousePage Wp = new WarehousePage();
		Wp.clickWarehouse();
		Wp.DeleteWarehouse();
		Assert.assertFalse(Wp.CheckWarehousePresent(), "Warehouse is present");
		Log.endTestCase("VerifyDeleteWarehouse");
	}

}

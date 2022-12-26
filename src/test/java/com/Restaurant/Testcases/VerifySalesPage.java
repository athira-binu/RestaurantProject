package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.BaseClass;
import com.Restaurant.PageObjects.LoginPage;
import com.Restaurant.PageObjects.SalesPage;
import com.Restaurant.Utilities.Log;

public class VerifySalesPage extends BaseClass{
	@Test
	public void VerifySales() {
		Log.startTestCase("VerifySalesPage");
		Lp.PageLogin();
		Sp.ClickSales();
		Assert.assertTrue(Sp.IsSalesPresent(), "Sales text is not present");
		Log.endTestCase("VerifySalesPage");
	}

}

package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.BaseClass;
import com.Restaurant.PageObjects.LoginPage;
import com.Restaurant.PageObjects.ReportsPage;
import com.Restaurant.Utilities.Log;

public class VerifyReportPage extends BaseClass{
	@Test(priority=1)
	public void VerifyClickOnReport() {
		Log.startTestCase("VerifyHomePage");
		Lp.PageLogin();
		Rp.ClickReports();
		Assert.assertTrue(Rp.IsTop5ProductPresent(), "Top 5 products present");
		Log.endTestCase("VerifyHomePage");
	}
	@Test(priority=2)
	public void VerifyEditClientReport() throws InterruptedException {
		Log.startTestCase("VerifyEditClientReport");
		Lp.PageLogin();
		Rp.EditClientStats();
		Assert.assertTrue(Rp.IsReportStatsPresent(), "Stats is present");
		Rp.ClickOnClose();
		Log.endTestCase("VerifyEditClientReport");
	}	
	@Test(priority=3)
	public void VerifyEditProductReport() throws InterruptedException {
		Log.startTestCase("VerifyEditProductReport");
		Lp.PageLogin();
		Rp.EditProductStats();
		Assert.assertTrue(Rp.IsReportStatsPresent(), "Stats is present");
		Rp.ClickOnClose();
		Log.endTestCase("VerifyEditProductReport");
	}
	@Test(priority=4)
	public void VerifyEditRegisterReport() throws InterruptedException {
		Log.startTestCase("VerifyEditRegisterReport");
		Lp.PageLogin();
		Rp.EditRegisterStats();
		Assert.assertTrue(Rp.IsReportStatsPresent(), "Stats is present");
		Rp.ClickOnClose();
		Log.endTestCase("VerifyEditRegisterReport");
	}

}

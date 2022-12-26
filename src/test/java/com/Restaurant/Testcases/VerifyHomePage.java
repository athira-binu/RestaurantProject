package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.BaseClass;
import com.Restaurant.PageObjects.HomePage;
import com.Restaurant.PageObjects.LoginPage;
import com.Restaurant.Utilities.Log;

public class VerifyHomePage extends BaseClass{
	@Test(groups= {"SMK"})
	public void VerifyDropDown() throws InterruptedException {
		Log.startTestCase("VerifyHomePage");
		Lp.PageLogin();
		hp.clickPortugeseLanguage();
		Assert.assertTrue(hp.IsPortugeseStorePresent(),"Not changed to Portugese");
		hp.clickFrenchLanguage();
		Assert.assertTrue(hp.IsFrenchStorePresent(),"Not changed to French");
		hp.clickEnglishLanguage();
		Assert.assertTrue(hp.IsEnglishStorePresent(),"Not changed to English");
		Log.endTestCase("VerifyHomePage");
	}

}

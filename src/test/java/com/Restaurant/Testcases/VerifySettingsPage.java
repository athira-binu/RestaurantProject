package com.Restaurant.Testcases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.BaseClass;
import com.Restaurant.PageObjects.LoginPage;
import com.Restaurant.PageObjects.SettingPage;
import com.Restaurant.Utilities.Log;
import com.Restaurant.Utilities.NewExcelRead;

public class VerifySettingsPage extends BaseClass{
	@Test
	public void VerifySettings() throws Exception {
		Log.startTestCase("VerifySettingsPage");
		LoginPage Lp= new LoginPage();
		Lp.PageLogin();
		SettingPage Sp1 = new SettingPage();
		Sp1.SettingClick();
		Assert.assertTrue(Sp1.IsSettingsPresent(),"Settings not present");
		
		//NewExcelRead Ex = new NewExcelRead();
		ArrayList ecxeldata = Ex.getData("Name");
		System.out.println(ecxeldata.get(1));
		Log.endTestCase("VerifySettingsPage");
	}

}

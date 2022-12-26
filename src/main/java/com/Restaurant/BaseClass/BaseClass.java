package com.Restaurant.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import com.Restaurant.Action.ActionClass;
import com.Restaurant.PageObjects.CustomersPage;
import com.Restaurant.PageObjects.HomePage;
import com.Restaurant.PageObjects.LoginPage;
import com.Restaurant.PageObjects.ReportsPage;
import com.Restaurant.PageObjects.SalesPage;
import com.Restaurant.PageObjects.SettingPage;
import com.Restaurant.PageObjects.SuppliersPage;
import com.Restaurant.PageObjects.UsersPage;
import com.Restaurant.PageObjects.WaitersPageInPeople;
import com.Restaurant.Utilities.ExtentReport;
import com.Restaurant.Utilities.NewExcelRead;

public class BaseClass {
	
			public static Properties prop;
			//public static WebDriver driver;
			public static ActionClass action;
			public static LoginPage Lp;
			public static SalesPage Sp;
			public static HomePage hp;
			public static ReportsPage Rp;
			public static SettingPage Sp1;
			public static UsersPage Up;
			public static WaitersPageInPeople Wp;
			public static CustomersPage Cp;
			public static SuppliersPage Sp2;
			public static NewExcelRead Ex;
			//loadConfig method is to load the configuration
			
			
			//Thread local driver
			public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
			@BeforeSuite
			public void beforeSuite() {
				ExtentReport.setExtent();
				DOMConfigurator.configure("log4j.xml");
			}
			@BeforeTest
			public void loadConfig() {
				
				try {
					 prop = new Properties();
					FileInputStream ip = new FileInputStream(
							System.getProperty("user.dir") + "\\Configurations\\config.properties");
					prop.load(ip);

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			//Using my testng xml file to get the browser name
			@Parameters("Browser")
			@BeforeMethod
			public void firstcall(String browser) {
				launchApp(browser);
				Lp = new LoginPage();
				Sp =  new SalesPage();
				hp = new HomePage();
				Rp = new ReportsPage();
				Sp1 = new SettingPage();
				Up = new UsersPage();
				Wp = new WaitersPageInPeople();
				Cp = new CustomersPage();
				Sp2 = new SuppliersPage();
				Ex = new NewExcelRead();
			}
			
			public static WebDriver getDriver() {
				return driver.get();
			}
			
			
			public void launchApp(String browserName) {
				
			   //String browserName = prop.getProperty("Browser");
				if (browserName.equalsIgnoreCase("Chrome")) {
					driver.set(new ChromeDriver());
					//driver=new ChromeDriver();
					
				} else if (browserName.equalsIgnoreCase("FireFox")) {
					driver.set(new FirefoxDriver());
					//driver=new FirefoxDriver();
					
				} else if (browserName.equalsIgnoreCase("Edge")) {
					driver.set(new EdgeDriver());
					//driver=new EdgeDriver();
					
				}
				//Maximize the screen
				getDriver().manage().window().maximize();
				action = new ActionClass();
				//Implicit TimeOuts
			    action.implicitWait(getDriver(), 10);
				//PageLoad TimeOuts
				action.pageLoadTimeOut(getDriver(), 30);   
				getDriver().get(prop.getProperty("url"));
				 
			}
			@DataProvider
			public Object[][] InvaidLoginDetails(){
				Object[][] data = new Object[3][2];
				data[0][0] = "abc";
				data[0][1] = "password";
				data[1][0] = "admin";
				data[1][1] = "asd";
				data[2][0] = "axa";
				data[2][1] = "def";
				return data;
				
			}
			@AfterMethod
			public void driverclose() {
				getDriver().close();
			}
			@AfterSuite
			public void AfterSuite() {
				ExtentReport.endReport();
			}
			

}

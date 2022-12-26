package com.Restaurant.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.BaseClass.BaseClass;

public class ReportsPage extends BaseClass{
	
	@FindBy(xpath="(//span[@class='menu-text'])[14]")
	WebElement Reports;
	
	@FindBy(xpath="//h3[text()='Top 5 Products this year']")
	WebElement Top5Products;
	
	@FindBy(xpath="//h3[text()='Clients Stats']")
	WebElement ClientStats;
	
	@FindBy(xpath="(//span[@role='presentation'])[1]")
	WebElement Clientdropdown;
	
	@FindBy(xpath="//input[@id='CustomerRange']")
	WebElement ClientCalendar;
	
	@FindBy(xpath="(//button[text()='Get Report'])[1]")
	WebElement ClientReport;
	
	@FindBy(xpath="//h3[text()='Products Stats']")
	WebElement ProductStats;
	
	@FindBy(xpath="(//span[@role='presentation'])[2]")
	WebElement ProductDropdown;
	
	@FindBy(xpath="//input[@id='ProductRange']")
	WebElement ProductCalendar;
	
	@FindBy(xpath="(//button[text()='Get Report'])[2]")
	WebElement ProductReport;
	
	@FindBy(xpath="//h3[text()='Register Stats']")
	WebElement RegisterStats;
	
	@FindBy(xpath="(//span[@role='presentation'])[3]")
	WebElement RegisterDropdown;
	
	@FindBy(xpath="//input[@id='RegisterRange']")
	WebElement RegisterCalendar;
	
	@FindBy(xpath="(//button[text()='Get Report'])[3]")
	WebElement RegisterReport;
	
	@FindBy(xpath="//h4[@id='stats']")
	WebElement ReportStatus;
	
	@FindBy(xpath="//button[text()='Close']")
	WebElement ReportClose;
	
	public ReportsPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void ClickReports() {
		action.click1(Reports, "Clicking on Reports");
		
	}
	
	public Boolean IsTop5ProductPresent() {
		return action.isDisplayed(getDriver(), Top5Products);
	}
	
	public void EditClientStats() {
		ClickReports();
		action.moveToElement(getDriver(), ClientStats);
		action.click1(Clientdropdown, "Clicking on client dropdown");
		action.type(ClientCalendar, "12/01/2022 - 12/31/2022");
		action.click1(ClientReport, "Clicking on client report");
	}
	
	public Boolean IsReportStatsPresent() {
		action.explicitWait(getDriver(), ReportStatus, Duration.ofSeconds(20));
		return action.isDisplayed(getDriver(), ReportStatus);
	}
	
	public void ClickOnClose() {
		action.click1(ReportClose, "Clicking on close");
	}
	
	public void EditProductStats() {
		ClickReports();
		action.moveToElement(getDriver(), ProductStats);
		action.click1(ProductDropdown, "Clicking on Product dropdown");
		action.type(ProductCalendar, "11/01/2022 - 11/30/2022");
		action.click1(ProductReport, "Clicking on Product Report");
	}
	
	public void EditRegisterStats() {
		ClickReports();
		action.moveToElement(getDriver(), RegisterStats);
		action.click1(RegisterDropdown, "Clicking on Register dropdown");
		action.type(RegisterCalendar, "12/01/2022 - 12/31/2022");
		action.click1(RegisterReport, "Clicking on product report");
		
	}
}

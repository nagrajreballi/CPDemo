package com.cpt.qa.PageTests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cpt.qa.base.TestBase;
import com.cpt.qa.pages.DashboardPage;
import com.cpt.qa.pages.EMTResourceAssignmentPage;
import com.cpt.qa.pages.LoginPage;
import com.cpt.qa.pages.resourceAvailabilityReportPage;
import com.cpt.qa.util.TestUtil;

public class TC03_resourceAvailabilityReportPageTest extends TestBase {
	
	public LoginPage loginPage;
	public DashboardPage dashboardPage;
	public resourceAvailabilityReportPage resourceavailabilityreportpage;
	

	String sheetName = "resourceAvailabilityReport";

	public TC03_resourceAvailabilityReportPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		resourceavailabilityreportpage = new resourceAvailabilityReportPage();

		dashboardPage = loginPage.validateLoginPage(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("PASS : User Logged into the application successfully.", true);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Thread.sleep(4000);
	}

	//Verify the page page title after login to the application
//	@Test(priority=1)
//	public void validateResourceAvailabilityReportPageTitleTest() throws Exception{
//		Thread.sleep(6000);
//		String title = resourceavailabilityreportpage.validateresourceAvailabilityReportPageTitle();
//		Assert.assertEquals(title, "CapacityPlanner");
//	}
//	
//	
//	//Verify the Logged in user Image after login to the application
//	@Test(priority=2)
//	public void validateLoggedInUserImageTest() throws Exception{
//		Thread.sleep(6000);
//		
//		boolean flag = resourceavailabilityreportpage.validateLoggedInUserImage();
//		Assert.assertTrue(flag);
//	}
//	
//	
//	//Verify the page heading after login to the application
//	@Test(priority=3)
//	public void pageHeadingTextTest() throws Exception{
//		
//		resourceavailabilityreportpage.clickOnResourceAvailabilityReport_DashboardLink();
//		Thread.sleep(4000);
//		String pageheading = resourceavailabilityreportpage.validateLoggedPageHeadingText();
//		Assert.assertEquals(pageheading, "MSC - Resource Availability Report");
//	}
//
//	
	//Verify Resource Availability Report page Test
	@DataProvider
	public Object[][] getCPTTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "getCPTTestData")
	public void validateResourceAvailabilityReportTest(String country, String man, String pract, String quarter,String month,String specAvail, String speparticular,String Ename_Spe, String monthSel) throws Exception {
		
		// Click on Resource Availability Report link in Dashboard after login to the application
		resourceavailabilityreportpage.clickOnResourceAvailabilityReport_DashboardLink();
		
		//Verify the list of countries and select particular country in 'Country' drop-down list
		resourceavailabilityreportpage.selectCountryInDrpdwnList(country);
		
	
		//Verify the list of Managers and select particular manager in 'Manager' drop-down list
		resourceavailabilityreportpage.selectManagerDrpdwnList(man);
		
		//Verify the list of practices and select particular practice in 'practice' drop-down list
		resourceavailabilityreportpage.validatePracticeDrpdwnList();
		resourceavailabilityreportpage.SelectPra(pract);
		
		//Verify the list of Quarters and select particular quarter in 'Select quarter' drop-down list
		resourceavailabilityreportpage.selectQuarterDrpdwnList(quarter);
		
		
		//Verify the list of Months and select particular Month in 'Select month' drop-down list
		resourceavailabilityreportpage.selectMonthDrpdwnList(month);
		
		//Verify Total employees count and total Emp names.
		resourceavailabilityreportpage.validateNumberOfEmployessandEmpNames();
		

		//Check OR Un-check to see specific availability
		//resourceavailabilityreportpage.validateSpecificAvailabilityChekbox(specAvail);
		
		//Select Specialty
		resourceavailabilityreportpage.specialityParticularDrpdwnList(speparticular);
		
		//Verify Availability of Percentage for Individual names in Resource Availability Report
		resourceavailabilityreportpage.validatePercentageOfIndividualEmpAvailability(Ename_Spe,monthSel);	
	}
	
	@Test(priority = 2, dataProvider = "getCPTTestData")
	public void validateNullValuesTest(String country, String man, String pract, String quarter,String month,String specAvail, String speparticular,String Ename_Spe, String monthSel) throws Exception {
		
		// Click on Resource Availability Report link in Dashboard after login to the application
		resourceavailabilityreportpage.clickOnResourceAvailabilityReport_DashboardLink();

		//Verify the list of countries and select particular country in 'Country' dropdown list
		resourceavailabilityreportpage.selectCountryInDrpdwnList(country);
		
		// Verify Null/ Blank values in EMP table
		resourceavailabilityreportpage.validateNullEmpNames();
	}
	
	@AfterMethod
	public void TC10tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
		 TestUtil.takeScreenshotAtEndOfTest(driver, result.getName());
		 }
		driver.quit();
	}
}

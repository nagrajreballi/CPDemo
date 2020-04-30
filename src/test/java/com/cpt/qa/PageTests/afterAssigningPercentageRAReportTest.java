package com.cpt.qa.PageTests;

import java.util.concurrent.TimeUnit;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cpt.qa.base.TestBase;
import com.cpt.qa.pages.DashboardPage;
import com.cpt.qa.pages.LoginPage;
import com.cpt.qa.pages.afterAssigningPercentageRAReport;
import com.cpt.qa.pages.beforeAssigningPercentageRAReport;
import com.cpt.qa.pages.resourceAvailabilityReportPage;
import com.cpt.qa.util.TestUtil;

public class afterAssigningPercentageRAReportTest extends TestBase {

	public LoginPage loginPage;
	public DashboardPage dashboardPage;
	public resourceAvailabilityReportPage resourceavailabilityreportpage;
	public beforeAssigningPercentageRAReport beforeAssigningpercentagerareport;
	public afterAssigningPercentageRAReport afterAssigningPercentagerareport;

	String sheetName = "AfterAssPertageRAReport";
	
	public afterAssigningPercentageRAReportTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		resourceavailabilityreportpage = new resourceAvailabilityReportPage();
		beforeAssigningpercentagerareport = new beforeAssigningPercentageRAReport();
		afterAssigningPercentagerareport = new afterAssigningPercentageRAReport();

		dashboardPage = loginPage.validateLoginPage(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("PASS : User Logged into the application successfully.", true);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Thread.sleep(4000);
	}
	
	//Verify Resource Availability Report page Test
		@DataProvider
		public Object[][] getCPTTestData() {
			Object data[][] = TestUtil.getTestData(sheetName);
			return data;
		}
		
	@Test(priority = 1, dataProvider = "getCPTTestData")
	public void validateAFTERAssigningPercentageRAReportTest(String quarter, String month, String speparticular, String Ename_Spe, String monthSel) throws Exception {

		// Click on Resource Availability Report link in Dashboard after login to the application
		afterAssigningPercentagerareport.clickOnResourceAvailabilityReport_DashboardLink();

		
		// Verify the list of Quarters and select particular quarter in 'Select quarter'drop-down list
		afterAssigningPercentagerareport.selectQuarterDrpdwnList(quarter);

		//Verify the list of Months and select particular Month in 'Select month'
		afterAssigningPercentagerareport.selectMonthDrpdwnList(month);
		
		//Select Specialty
		afterAssigningPercentagerareport.specialityParticularDrpdwnList(speparticular);
		
		//Verify Availability of Percentage for Individual names in Resource Availability Report
		afterAssigningPercentagerareport.validatePercentageOfIndividualEmpAvailability(Ename_Spe,monthSel);
	}
	
	@AfterMethod
	public void TC10tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
		 TestUtil.takeScreenshotAtEndOfTest(driver, result.getName());
		 }
		driver.quit();
	}
}
	


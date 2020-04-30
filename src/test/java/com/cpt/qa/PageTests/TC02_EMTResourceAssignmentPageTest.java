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
import org.testng.asserts.SoftAssert;

import com.cpt.qa.base.TestBase;
import com.cpt.qa.pages.DashboardPage;
import com.cpt.qa.pages.EMTResourceAssignmentPage;
import com.cpt.qa.pages.LoginPage;
import com.cpt.qa.pages.resourceAvailabilityReportPage;
import com.cpt.qa.util.TestUtil;

public class TC02_EMTResourceAssignmentPageTest extends TestBase {

	public LoginPage loginPage;
	public DashboardPage dashboardPage;
	public EMTResourceAssignmentPage emtResourceAssignmentPage;
	public static SoftAssert softAssertion= new SoftAssert();

	String sheetName = "emtresourcesssignment";

	public TC02_EMTResourceAssignmentPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		emtResourceAssignmentPage = new EMTResourceAssignmentPage();

		dashboardPage = loginPage.validateLoginPage(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("PASS : User Logged into the application successfully.", true);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Thread.sleep(4000);
	}

	// Verify page heading after login to the application succesfully
//	@Test(priority = 1)
//	public void pageHeadingTextTest() throws Exception {
//		Thread.sleep(2000);
//		String pageheading = emtResourceAssignmentPage.validateEMTResourceAssignmentPageHeadingText();
//		Assert.assertEquals(pageheading, "Capacity Planner");
//		Reporter.log("PASS: Succesfuly verified EMT resource Assigment Page Heading: " + pageheading);
//	}

	// Using data provider
	@DataProvider
	public Object[][] getCPTTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "getCPTTestData")
	public void validateEmtResourceAssignementTest(String practice, String bm, String pline, String lprojects, String cm, String spe, String addresource, String specialitySelect, String SEname, String SEPercentage, String updateSEPercentage,String startYear, String startMonthName, String startDay, String endYear, String endMonthName, String endDay) throws Exception {
		
		// To click on Dashboard tab link
		dashboardPage.dashboard();

		// Verify the list of practices and select particular practice in 'practice' dropdown list in Search EMT with Filters section.
		emtResourceAssignmentPage.validatePracticeDrpdwnList(practice);

		// Verify the list of Managers and select particular manager in 'Manager' dropdown list in Search EMT with Filters section.
		emtResourceAssignmentPage.validateBusinessOwnerDrpdwnList(bm);

		// Verify the Include Pipleline and select particular pipeline in 'Include pipeline' dropdown list in Search EMT with Filters section.
		emtResourceAssignmentPage.validateIncludePipeLineDrpdwnList(pline);

		// Verify list of projects and select particular project link in Search EMT with Filters section.
		emtResourceAssignmentPage.validateListOfProjectsAndSelectOne(lprojects);

		// Verify Functional manager in Change functional manager textbox field.
		emtResourceAssignmentPage.validateFunctioanMangerTextBoxField(cm);

		// Verify list of speciality and select particular speciality in select speciality dropdown list.
		emtResourceAssignmentPage.validateSelectSpecilityDrpdwnList(spe);

		// To add number of resources in resources text box field.
		emtResourceAssignmentPage.validateToaddNumberofResources(addresource);

		// To verify 'add resources' button in EMT resource assignment page.
		emtResourceAssignmentPage.validateClickOnAddResourcesBtn();

		// Verify list of speciality and add number of resources details in a speciality table
		emtResourceAssignmentPage.validateLisOfSpecialityTable(specialitySelect, SEname, SEPercentage, updateSEPercentage, startYear, startMonthName, startDay, endYear, endMonthName, endDay);
		
		//To Assign Number of Resources in projects depends on specaility
		emtResourceAssignmentPage.validateAssignedTotal();
		
		//To verify FTE
		emtResourceAssignmentPage.validateFTEAvailability();
		
		//validate Number of Resources in header part
		emtResourceAssignmentPage.validateNumberOfResources();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			TestUtil.takeScreenshotAtEndOfTest(driver, result.getName());
		}
		//driver.quit();
	}
}
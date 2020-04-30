package com.cpt.qa.PageTests;

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
import com.cpt.qa.pages.LoginPage;
import com.cpt.qa.util.TestUtil;

public class TC01_LoginPageTest extends TestBase {

	LoginPage loginPage;
	private String sheetName = "login";

	public TC01_LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
	}

	// Verify before Login page title
//	@Test(priority = 1)
//	public void BeforeLoginPageTitleTest() throws Exception {
//		Thread.sleep(2000);
//		String title = loginPage.validateBeforeLoginPageTitle();
//		Assert.assertEquals(title, "IBM w3id");
//	}

	// Using data provider for login test
	@DataProvider
	public Object[][] getMAMPTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	// Verify Login page functionality
	@Test(priority = 1, dataProvider = "getMAMPTestData") // login pageTest
	public void loginPageTest(String un, String pwd) throws Exception {
		loginPage.validateLoginPage(un, pwd);
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			TestUtil.takeScreenshotAtEndOfTest(driver, result.getName());
		}
		driver.quit();
	}
}

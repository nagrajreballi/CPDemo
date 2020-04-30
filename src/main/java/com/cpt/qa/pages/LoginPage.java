package com.cpt.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.cpt.qa.util.TestUtil;
import com.cpt.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Create Object repository

	@FindBy(xpath = ".//*[@name='username']")
	WebElement username;

	@FindBy(xpath = ".//*[@name='password']")
	WebElement password;

	@FindBy(xpath = ".//*[@id='btn_signin']")
	WebElement signInBtn;

	@FindBy(xpath = ".//*[text()='DASHBOARD']")
	WebElement dashboardTab;

////////////////////////////////////////Initializing the Page Objects:///////////////////////////////////////////////////

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

////////////////////Actions//////////////////////////////////////////////////////////////////////////////////////////

	// Verify Before login page title
	public String validateBeforeLoginPageTitle() {

		TestUtil.waitForPageLoad(driver);
		Reporter.log("PASS: Before Login page title is : " + driver.getTitle(), true);
		return driver.getTitle();
	}

//**********************************************************************************************************************************		
	// Verify Login page functionality
	public DashboardPage validateLoginPage(String un, String pwd) throws Exception {

		
		TestUtil.flash(username, driver); //highlight the element
		TestUtil.sendKeys(driver, username, TestUtil.timeout, un);
		Reporter.log("PASS - Username is entered: " + un, true);

		TestUtil.flash(password, driver); //highlight the element
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		 js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", password);
		TestUtil.sendKeys(driver, password, TestUtil.timeout, pwd);
		Reporter.log("PASS - Password is entered: ******", true);

		TestUtil.flash(signInBtn, driver); //highlight the element
		TestUtil.clickOn(driver, signInBtn, TestUtil.timeout);
		Reporter.log("PASS : User Logged into the application successfully.", true);

		TestUtil.waitForPageLoad(driver);

		
		return new DashboardPage();

	}

}

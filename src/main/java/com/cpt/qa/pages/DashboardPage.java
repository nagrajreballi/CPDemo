package com.cpt.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.cpt.qa.base.TestBase;
import com.cpt.qa.util.Generic;
import com.cpt.qa.util.TestUtil;

public class DashboardPage extends TestBase {
	
	//1.Create Object repository
		@FindBy(xpath=".//button[@id='tab-control-demo-15']")
		WebElement empResourceAssignment_tabLnk;
		
		@FindBy(xpath=".//button[@id='tab-control-demo-16']")
		WebElement dashboard_tabLnk;
	//2.Initializing the Page Objects:
		public DashboardPage() {
			PageFactory.initElements(driver, this);
		}
		
		//3.Action
		public void dashboard() throws Exception {
			
			
			//Thread.sleep(5000);
			//Generic.nullifyImplicitlyWait();
			//TestUtil.waitForElementToClick(driver, empResourceAssignment_tabLnk);
			//empResourceAssignment_tabLnk.click();
			//Thread.sleep(2000);
			
			TestUtil.isElementPresnt(driver, dashboard_tabLnk, TestUtil.timeout);
			TestUtil.flash(dashboard_tabLnk, driver);
			dashboard_tabLnk.click();
			Thread.sleep(2000);
			
			
			TestUtil.isElementPresnt(driver, empResourceAssignment_tabLnk, TestUtil.timeout);
			TestUtil.flash(empResourceAssignment_tabLnk, driver);
			empResourceAssignment_tabLnk.sendKeys(Keys.ARROW_RIGHT,Keys.ENTER);
			Reporter.log("PASS -User clicked on the EMT Resource Assignment tab link");
			Thread.sleep(2000);
			// actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
			 
			//empResourceAssignment_tabLnk.submit();
			//empResourceAssignment_tabLnk.click();
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("arguments[0].click();", empResourceAssignment_tabLnk);
			
//			Actions builder = new Actions(driver);        
//			builder.sendKeys(Keys.ARROW_RIGHT,Keys.ENTER);
			
		}
		


}

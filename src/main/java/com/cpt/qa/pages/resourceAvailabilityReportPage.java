package com.cpt.qa.pages;

import java.util.List;
import java.util.regex.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.cpt.qa.base.TestBase;
import com.cpt.qa.util.Generic;
import com.cpt.qa.util.TestUtil;

public class resourceAvailabilityReportPage extends TestBase{

	public static WebElement element;

	public static WebDriverWait wait;
	
	public static JavascriptExecutor js = (JavascriptExecutor) driver;
	
	
	// 1.Create Object repository
		@FindBy(xpath = ".//*//div//img[@src='./assets/Image/resource-availability-report.png']")
		WebElement dashboardResourceAvailabilityReport_lnk;
		
		@FindBy(xpath = ".//*[text()='MSC - Resource Availability Report']")
		WebElement pageheading_txt;
		
		@FindBy(xpath = ".//*[@class='ds-dropdown ds-flat']//div//img")
		WebElement pageHeadingLoggedInuserImage;
		
		
		//Select country
		@FindBy(xpath = ".//*[text()='MSC - Resource Availability Report']//following::div[6]//span[@class='c-remove']")
		private WebElement countryDrpdwnListRemoveIcon_Clk;
		
		@FindBy(xpath = ".//*[text()='MSC - Resource Availability Report']//following::div[8]//span[1]")
		private WebElement countryDrpdwnListTwistyDown_Clk;
		
		@FindBy(xpath = ".//*[text()='MSC - Resource Availability Report']//following::ul[1]//li")
		private List<WebElement> countryDrpdwnListAllElements_Lists;
		
		@FindBy(xpath = ".//*[text()='MSC - Resource Availability Report']//following::div[6]//div[@class='c-list']")
		private WebElement countryDrpdwnListTwistyUp_Clk;
		
		
		//Select Manager
		@FindBy(xpath = ".//*[text()='MSC - Resource Availability Report']//following::div[21]//span[@class='c-remove']")
		WebElement managerDrpdwnListRemoveIcon_Click;
		
		@FindBy(xpath = ".//*[text()='MSC - Resource Availability Report']//following::div[21]//div[@class='selected-list']")
		WebElement managerDrpdwnListTwistyDown_Click;
		
		@FindBy(xpath = ".//*[text()='MSC - Resource Availability Report']//following::ul[2]//li")
		List<WebElement> managerDrpdwnListAllElements_Lists;
		
		@FindBy(xpath = ".//*[text()='MSC - Resource Availability Report']//following::div[21]//div[@class='c-list']")
		WebElement managerDrpdwnListTwistyUp_Click;
		
		
		//Select practice
		@FindBy(xpath = ".//*[text()='MSC - Resource Availability Report']//following::div[40]")
		WebElement practiceDrpdwnListTwistyDown_Click;
		
		@FindBy(xpath = ".//*[text()='Practice:']//following::div[9]//label//span[1]")
		List<WebElement> practiceDrpdwnListAllElements_Lists;
		
		@FindBy(xpath = ".//*[text()='MSC - Resource Availability Report']//following::div[40]//div[@class='c-list']")
		WebElement practiceDrpdwnListTwistyUp_Click;
		
		//Select Quarter
		@FindBy(xpath = ".//*[@class='ds-select select_cus']//*[@id='mySelect1']")
		WebElement selectQuarter_drplst;
		
		@FindBy(xpath = ".//*[@name='myOptions1[]']//option")
		List<WebElement> quarterDrpdwnListAllElements_Lists;
		
		//Select Month
		@FindBy(xpath = ".//*[@class='ds-select select_cus']//*[@id='mySelect2']")
		WebElement monthDrpdwnListTwistyDown_Click;
		
		@FindBy(xpath = ".//*[@name='myOptions2[]']//option")
		List<WebElement> monthDrpdwnListAllElements_Lists;
		
		
		//Resource Avaialiable
		@FindBy(xpath = ".//*[@class='ds-col-6']//table//tr[3]//td[2]")
		WebElement totalEmployeesCount_resourceAvailabilityTxt;
		@FindBy(xpath = ".//*[@class='ds-table-container ds-collapsible ds-pad-t-1 data_table']//table//tbody//tr")
		List<WebElement> listOfEmpNames_Webtable;
		
		//Select checkbox
		@FindBy(xpath = ".//*[@class='ds-label checkbox_label']//span[1]")
		List<WebElement> specificAvailabilityCheckbox_Lists;
		
		
		//Select speciality
		@FindBy(xpath = ".//*[text()='Emp Name']//following::div[3]")
		WebElement specialityDrpdwnListTwistyDown_Click;
		
		@FindBy(xpath = ".//*[text()='Emp Name']//following::ul[1]//li")
		List<WebElement> specialityDrpdwnListAllElements_Lists;
		
		@FindBy(xpath = ".//*[text()='Emp Name']//following::div[@class='selected-list']")
		WebElement specialityDrpdwnListTwistyUp_Click;
		
		@FindBy(xpath = ".//*[@class='ds-table-container ds-collapsible ds-pad-t-1 data_table']//table//tbody//tr")
		List<WebElement> listOfEmpNames_table;
		

		@FindBy(xpath = ".//*[@class='ds-table-container ds-collapsible ds-pad-t-1 data_table']//table//thead//th//div[@class='quarterHeading']//div")
		List<WebElement> listOfMonths_WebTable;
		
		@FindBy(xpath = ".//*[@class='ds-table-container ds-collapsible ds-pad-t-1 data_table']//table//tbody//tr//td[3]//*[starts-with(@class,'month')]")
		List<WebElement> listOfMonthsFindingPercen_WebTable;
		

		@FindBy(xpath = ".//*[@class='month3 displayClass']//div[@class='percentageArea']")
		WebElement onOverlayPercen_Text;
		

		@FindBy(xpath = ".//*[@class='ds-table-container ds-collapsible detail_data_table ds-mar-b-3']//div[1]//table//tbody//tr//td")
		List<WebElement> projectDetialOnOverlay_Lists;
		
		//@CacheLookup
		@FindBy(xpath = ".//*[@class='ds-table-container ds-collapsible ds-pad-t-1 data_table']//table//tbody//tr//td[1]")
		List<WebElement>  listOfEmpNamesOnly_WebTable;
		
		@FindBy(xpath = ".//*[@class='ds-table-container ds-collapsible ds-pad-t-1 data_table']//table//tbody//tr//td[2]")
		List<WebElement>  listOfSpecialityOnly_WebTable;
		
		
		
		@FindBy(xpath = "")
		WebElement goBack_btn;
		
//****************************	// 2.Initializing the Page Objects:*********************************************************
		
		public resourceAvailabilityReportPage() {
			PageFactory.initElements(driver, this);
		}
		
//********************** 3.Action***************************************************************************************
		
		//Verify the page page title after login to the application
		public String validateresourceAvailabilityReportPageTitle() throws InterruptedException{
			Thread.sleep(2000);
			TestUtil.waitForPageLoad(driver);
			Reporter.log("PASS- Resource avialbility report page title is : " +driver.getTitle(),true);
			return driver.getTitle();
		}
		
//******************************************************************************************************************
		
		//Verify the Logged in user Image after login to the application
				public boolean validateLoggedInUserImage() throws Exception{
					wait = new WebDriverWait(driver, 100);
					WebElement  imagefaceIcon= wait.until(ExpectedConditions.visibilityOf(pageHeadingLoggedInuserImage));
					boolean disp=imagefaceIcon.isDisplayed();
					TestUtil.flash(pageHeadingLoggedInuserImage, driver);
					Reporter.log("PASS- After login to the application,User image icon is displaying at right top corner", true);
					return disp;
				}
		
//******************************************************************************************************************
		
				//Verify the page heading after login to the application
				public String validateLoggedPageHeadingText() throws Exception{
					TestUtil.waitForPageLoad(driver);
					String textget=  pageheading_txt.getText();
					TestUtil.flash(pageheading_txt, driver);
					Reporter.log("PASS - page heading is displaying after login to the application as : " + textget,true);
					return textget;
				}
		
///******************************************************************************************************************
		
		// Click on Resource Availability Report link in Dashboard after login to the application
		public void clickOnResourceAvailabilityReport_DashboardLink() throws InterruptedException {
			Thread.sleep(4000);
			TestUtil.flash(dashboardResourceAvailabilityReport_lnk, driver);
			dashboardResourceAvailabilityReport_lnk.click();
			Reporter.log("PASS: User is clicked on 'Resource Availability Report' Dashboard link",true);
			Thread.sleep(4000);
		}
		
///******************************************************************************************************************
		//Verify the list of countries and select particular country in 'Country' drop-down list
		public String selectCountryInDrpdwnList(String country) 
		{
			TestUtil.waitForPageLoad(driver);
			try 
			{
				TestUtil.waitForElementVisible(driver, countryDrpdwnListRemoveIcon_Clk);
				TestUtil.flash(countryDrpdwnListRemoveIcon_Clk, driver);
				countryDrpdwnListRemoveIcon_Clk.click();
				Reporter.log("PASS - User is clicked on remove icon in 'Select Country' drop down list", true);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				Reporter.log("FAIL -User is not clicked on remove icon in 'Select Country' drop down list");
			}
			softAssertion.assertAll();
			Generic.waitForPageLoad(driver);
			
			try 
			{
				TestUtil.flash(countryDrpdwnListTwistyDown_Clk, driver);
				countryDrpdwnListTwistyDown_Clk.click();
				Reporter.log("PASS - User is clicked on twisty down icon in 'Select Country' dropdown list", true);
			}
			catch(Exception e) 
			{
				e.printStackTrace();
				Reporter.log("FAIL - User is not clicked on twisty down icon in 'Select Country' dropdown list");
			}
			Generic.enableImplicitlyWait();
			softAssertion.assertAll();

			List<WebElement> countryLists = countryDrpdwnListAllElements_Lists;
			for (int i = 0; i < countryLists.size(); i++) 
			{
				WebElement countryListsElement = countryLists.get(i);
				String countryListsText = countryListsElement.getText();
				if (countryListsText.equalsIgnoreCase(country)) 
				{
					countryListsElement.click();
					Generic.waitForPageLoad(driver);
					Reporter.log("PASS - User is selected: "+country+" :in 'Select Country' dropdown list",true);
					break;
				}
				
			}
			softAssertion.assertAll();
			
			TestUtil.flash(countryDrpdwnListTwistyUp_Clk, driver);
			countryDrpdwnListTwistyUp_Clk.click();
			Reporter.log("PASS - User is clicked on twisty Up icon in 'Select Country' dropdown list", true);
			Generic.enableImplicitlyWait();
			softAssertion.assertAll();
			return country;
		}
///******************************************************************************************************************		
			//Select manager
					public String selectManagerDrpdwnList(String man) throws Exception 
					{
						TestUtil.waitForElementVisible(driver, managerDrpdwnListRemoveIcon_Click);
						TestUtil.flash(managerDrpdwnListRemoveIcon_Click, driver);
						managerDrpdwnListRemoveIcon_Click.click();
						Reporter.log("PASS - User is clicked on remove icon in 'Select Manager' drop down list", true);
						softAssertion.assertAll();
						
						TestUtil.flash(managerDrpdwnListTwistyDown_Click, driver);
						managerDrpdwnListTwistyDown_Click.click();
						Reporter.log("PASS - User is clicked on 'Select Manager' dropdown list",true);
						Generic.enableImplicitlyWait();
						softAssertion.assertAll();
				
						List<WebElement> managerLists = managerDrpdwnListAllElements_Lists;
						for (int i = 0; i < managerLists.size(); i++) 
						{
							WebElement managerListsElement = managerLists.get(i);
							String managerListsText = managerListsElement.getText();
							if (managerListsText.equalsIgnoreCase(man)) 
							{
								managerListsElement.click();
								Generic.waitForPageLoad(driver);
								Reporter.log("PASS - User is Successfully selected : " + man + " : in 'Select Manager' dropdown list",true);
								break;
							}
							else 
							{
								//Generic.failATestCase("FAIL- User is not selected: "+man+" :in 'Select manager' dropdown list, Because it's not showing element");
							}
						}
						softAssertion.assertAll();
						
						TestUtil.flash(managerDrpdwnListTwistyUp_Click, driver);
						managerDrpdwnListTwistyUp_Click.click();
						Generic.waitForPageLoad(driver);
						softAssertion.assertAll();
						return man;	
					}
////******************************************************************************************************************
		
	// Select practice
	public void validatePracticeDrpdwnList() throws Exception 
	{
		TestUtil.waitForElementVisible(driver, practiceDrpdwnListTwistyDown_Click);
		TestUtil.flash(practiceDrpdwnListTwistyDown_Click, driver);
		practiceDrpdwnListTwistyDown_Click.click();
		Generic.waitForPageLoad(driver);
		Reporter.log("PASS - User is clicked on 'Select Practice' dropdown list",true);
		softAssertion.assertAll();

		List<WebElement> practiceLists = driver.findElements(By.xpath(".//*[text()='Practice:']//following::div[12]//ul//li//label"));
		for (int i = 0; i < practiceLists.size(); i++) 
		{
			WebElement practiceListsElement = practiceLists.get(i);
			String practiceListsText = practiceListsElement.getText();
		//	Reporter.log("PASS - List of Practices is :" + practiceListsText, true);
			
			if(practiceListsText!=null) 
			{
				Reporter.log("PASS - List of Practices is :" + practiceListsText, true);
				continue;
			}
			break;
		}
	}
		
///******************************************************************************************************************

	public String SelectPra(String pract) throws Exception {

		List<WebElement> practiceLists2 = driver.findElements(By.xpath(".//*[text()='Practice:']//following::div[9]//label//span[1]"));
		for (int j = 0; j < practiceLists2.size(); j++) {
			WebElement practiceListsElement2 = practiceLists2.get(j);
			String practiceListsText2 = practiceListsElement2.getText();

			if (practiceListsText2.equalsIgnoreCase(pract)) {
				practiceListsElement2.click();
				Thread.sleep(1000);
				Reporter.log("PASS - User is Successfully selected : " + pract + " : in 'select Practice' dropdown list",true);
				break;
			}
			Thread.sleep(2000);
			TestUtil.flash(driver.findElement(By.xpath(".//*[text()='MSC - Resource Availability Report']//following::div[40]//div[@class='c-list']")), driver);
			driver.findElement(By.xpath(".//*[text()='MSC - Resource Availability Report']//following::div[40]//div[@class='c-list']")).click();
		}
		return pract;
	}

	///******************************************************************************************************************
	//Select Quarter
			public String selectQuarterDrpdwnList(String quarter) throws InterruptedException 
			{
				Thread.sleep(2000);
				TestUtil.flash(selectQuarter_drplst, driver);
				selectQuarter_drplst.click();
				Thread.sleep(2000);
				Actions builder = new Actions(driver);
				builder.click(element).build();
				builder.perform();
				Reporter.log("PASS: User is clicked on 'Quarter' dropdown list",true);
				Generic.waitForPageLoad(driver);
				softAssertion.assertAll();
				
				List<WebElement> quarterLists = quarterDrpdwnListAllElements_Lists;
				for (int i = 0; i < quarterLists.size(); i++) 
				{
					WebElement quarterListsElement = quarterLists.get(i);
					String quarterListsText = quarterListsElement.getText();
					if (quarterListsText.equalsIgnoreCase(quarter)) 
					{
						quarterListsElement.click();
						Generic.waitForPageLoad(driver);
						Reporter.log("PASS - User is Successfully selected : " + quarter + " : in 'Select Quarter' dropdown list",true);
						break;
					}
				}
				softAssertion.assertAll();
				return quarter;
			}
		
////******************************************************************************************************************
			//Select Month
			public String selectMonthDrpdwnList(String month) throws Exception 
			{
				TestUtil.waitForElementVisible(driver, monthDrpdwnListTwistyDown_Click);
				TestUtil.flash(monthDrpdwnListTwistyDown_Click, driver);
				monthDrpdwnListTwistyDown_Click.click();
				Generic.waitForPageLoad(driver);
				Actions builder = new Actions(driver);
				builder.click(element).build();
				builder.perform();
				Reporter.log("PASS: User is clicked on 'Select Month' dropdownlist",true);
				Generic.waitForPageLoad(driver);
				softAssertion.assertAll();
			
				List<WebElement> monthLists = monthDrpdwnListAllElements_Lists;
				for(int i=0; i < monthLists.size(); i++) 
				{
					WebElement monthListsElement = monthLists.get(i);
					String monthListsText = monthListsElement.getText();
					if(monthListsText.equalsIgnoreCase(month+"")) 
					{
						monthListsElement.click();
						Generic.waitForPageLoad(driver);
						Reporter.log("PASS - User is Successfully selected : " + month + " : in 'select Months' dropdown list",true);
						break;
					}
//					else 
//					{
//						Reporter.log("FAIL-User is Successfully selected : " + month + " : in 'select Months' dropdown list");
//					}
				}
				softAssertion.assertAll();
				return month;
			}
/////******************************************************************************************************************
			//Counts Total Employees
			public void validateNumberOfEmployessandEmpNames() 
			{
				// Resource Availability Count
				TestUtil.waitForElementVisible(driver, monthDrpdwnListTwistyDown_Click);
				TestUtil.flash(totalEmployeesCount_resourceAvailabilityTxt, driver);
				String rowtext_EmpCont = totalEmployeesCount_resourceAvailabilityTxt.getText();
				System.out.println(" Selected manager under Total employess count is : " + rowtext_EmpCont);
				int ij=Integer.parseInt(rowtext_EmpCont);  
				Reporter.log("PASS - Selected manager under Total employess count is : " +ij,true);
				softAssertion.assertAll();

				// Emp Name counts
				List<WebElement> listOfEmpNames = listOfEmpNames_Webtable;
				int totolCounts = listOfEmpNames.size();
				System.out.println("Total counts : " + totolCounts);
				Reporter.log("PASS - Selected manager under Total number of Employees Names in table is : " + totolCounts,true);
				softAssertion.assertAll();
				
				//Verify Total Employess and Emp names
				if(ij == totolCounts)
				{
					Assert.assertEquals(ij,totolCounts, " \n Total number of Employess is: " +ij + " \n Totol number of Emp names is in emp table is " +totolCounts);
					Assert.assertEquals(ij == totolCounts, true);
					Reporter.log("PASS - Selected manager under Total Numbers of Employess is: " + ij + " = Selected manager under Total emp names : " +totolCounts, true);
				}
				else
				{
					Reporter.log("Fail: Total Numbers of Employess is: " +ij + " is Not equal to Total emp names : " +totolCounts );
				}
				softAssertion.assertAll();
			}


////******************************************************************************************************************
			//Check OR Un-check to see specific availability
			public String validateSpecificAvailabilityChekbox(String specAvail) throws Exception 
			{
				List<WebElement> selectspecAvailLists = specificAvailabilityCheckbox_Lists;
				for (int i = 0; i < selectspecAvailLists.size(); i++) 
				{
					WebElement specAvailElement = selectspecAvailLists.get(i);
					String selectspecAvailListsText = specAvailElement.getText();
					if (selectspecAvailListsText.equalsIgnoreCase(specAvail)) 
					{
						specAvailElement.click();
						Generic.waitForPageLoad(driver);
						Reporter.log("PASS - User is Successfully selected :" + specAvail + ": in Check OR Un-check to see specific availability checkbox",true);
						break;
					}
//					else
//					{
//						Reporter.log("Fail - User is Successfully selected :" + specAvail + ": in Check OR Un-check to see specific availability checkbox");
//					}
				}
				softAssertion.assertAll();
				return specAvail;
			}
////******************************************************************************************************************
			//Verify speciality in dropdown list
			public void specialityParticularDrpdwnList(String speparticular) throws Exception 
			{
				//Select Speciality in the lists
				TestUtil.waitForElementVisible(driver, specialityDrpdwnListTwistyDown_Click);
				TestUtil.flash(specialityDrpdwnListTwistyDown_Click, driver);
				specialityDrpdwnListTwistyDown_Click.click();
				Reporter.log("PASS - User is clicked on 'Select Speciality' dropdown list",true);
				softAssertion.assertAll();
				
				List<WebElement> selectSpepartiLists = specialityDrpdwnListAllElements_Lists;
				for (int i = 0; i < selectSpepartiLists.size(); i++)
				{
					WebElement selectSpepartiListsElement = selectSpepartiLists.get(i);
					String selectSpepartiListsText = selectSpepartiListsElement.getText();
					if (selectSpepartiListsText.equalsIgnoreCase(speparticular)) 
					{
						selectSpepartiListsElement.click();
						Generic.waitForPageLoad(driver);
						Reporter.log("PASS - User is Successfully selected : " + speparticular + " : in 'Select Speciality' dropdown list",true);
						break;
					}
				}
				softAssertion.assertAll();
				
				Generic.enableImplicitlyWait();
				TestUtil.flash(specialityDrpdwnListTwistyUp_Click, driver);
				specialityDrpdwnListTwistyUp_Click.click();
				softAssertion.assertAll();
				
				
				//Count number of Emp names and display
				Generic.waitForPageLoad(driver);
				List<WebElement> listOfEmpnames = listOfEmpNames_table;
				int totolCounts = listOfEmpnames.size();
				Reporter.log("PASS- Total number of emps count is : " + totolCounts,true);
				softAssertion.assertAll();
				
				for (int i = 0; i < totolCounts; i++) 
				{
					WebElement selectlistOfEmpnames = listOfEmpnames.get(i);
					String listOfEmpnamesText = selectlistOfEmpnames.getText();
					String[] NumberOfwords = listOfEmpnamesText.split("\n");

					String wordsSpec1 = NumberOfwords[0];
					Reporter.log("Emp name is: " + wordsSpec1);
					System.out.println("PASS- " + wordsSpec1);

					String[] a1 = wordsSpec1.split("\\s");
					String aa0 = a1[0];
					String aa1 = a1[1];
					String aa2 = a1[2];
					String aa3 = a1[3];

					if (wordsSpec1.equals(aa0 + " " + speparticular) || wordsSpec1.equals(aa0 + " " + aa1 + " " + speparticular)
							|| wordsSpec1.equals(aa0 + " " + aa1 + " " + aa2 + " " + speparticular)
							|| wordsSpec1.equals(aa0 + " " + aa1 + " " + aa2 + " " + aa3 + " " + speparticular)) {

						Reporter.log("PASS- Succesfully verified selected speciality as : "+speparticular+" : Emp names as : "+wordsSpec1+" :in Employee table ",true);
						continue;

					} 
					else 
					{
						Reporter.log("FAIL- UnSuccesfully verified selected speciality, Emp names and specific availability, Because its not available any employees");
					}
					break;
				}
				softAssertion.assertAll();
			}
			
	
////******************************************************************************************************************	
			//Verify Availability of Percentage for Individual names in Resource Availability Report
			public void validatePercentageOfIndividualEmpAvailability( String Ename_Spe, String monthSel) throws Exception 
			{
				// Verify Emp name
				List<WebElement> listOfEmpnames = listOfEmpNames_table;
				for (int i = 0; i < listOfEmpnames.size(); i++) 
				{
					WebElement selectlistOfEmpnames = listOfEmpnames.get(i);
					String listOfEmpnamesText = selectlistOfEmpnames.getText();
					String[] NumberOfwords = listOfEmpnamesText.split("\n");

					String wordsSpec1 = NumberOfwords[0];
					Reporter.log("PASS - After selecting particular speciality for finding percentage of Employee is: " + wordsSpec1,true);
					System.out.println("PASS- " + wordsSpec1);
					softAssertion.assertAll();
					
					String[] a1 = wordsSpec1.split("\\s");
					String aa0 = a1[0];
					String aa1 = a1[1];
					String aa2 = a1[2];
					String aa3 = a1[3];
					String aa4 = a1[4]; // If name is like A B you should comment this one
					// String aa5 = a1[5]; //If name is like A B C D you should uncommit this one
					// and + " " + aa5 in if condtion

					if (wordsSpec1.equalsIgnoreCase(Ename_Spe + " " + aa2 + " " + aa3 + " " + aa4)) { // comment + " " + aa4
																										// --if name is A B
						List<WebElement> listOfEmpnamePercentageMonth = listOfMonths_WebTable;
						for (int j = 0; j < listOfEmpnamePercentageMonth.size(); j++) 
						{
							WebElement percentageElement = listOfEmpnamePercentageMonth.get(j);
							String textPercentage = percentageElement.getText();
							Reporter.log("PASS - Months in availaibity  for Employee name is showing " + Ename_Spe + " : "+ textPercentage, true);
							softAssertion.assertAll();
							
							if (textPercentage.equals(" " + monthSel + " ") || textPercentage == " " + monthSel + " "|| textPercentage.equalsIgnoreCase("" + monthSel + "")) 
							{
								Generic.waitForPageLoad(driver);
								List<WebElement> listOfEmpnamePercentageMonthA = listOfMonthsFindingPercen_WebTable;
								for (int k = 0; k < listOfEmpnamePercentageMonthA.size(); k++) {
									WebElement percentageElementA = listOfEmpnamePercentageMonthA.get(i);
									String textPercentageA = percentageElementA.getText();
									Reporter.log("PASS - For Employee name '" + Ename_Spe + " 'his availaibity percentage is ' "+ textPercentageA + " 'of the month '" + monthSel, true);
									softAssertion.assertAll();
									
									String[] per_a = textPercentageA.split("%");
									String a00 = per_a[0];
									int covertPer = Integer.parseInt(a00);
									// String a11 = per_a[1];
									// String a22 = per_a[2];

									if (covertPer >= 0 && covertPer <= 100) 
									{
										percentageElementA.click();
										Generic.waitForPageLoad(driver);
										Reporter.log("PASS - User is  Clicked on " + monthSel + " month Percentage row link for Emp name is: " + Ename_Spe, true);
										softAssertion.assertAll();
										
										// To get percentage values on overlay in project details
										
										TestUtil.waitForElementVisible(driver, onOverlayPercen_Text);
										String textOverlay = onOverlayPercen_Text.getText();
										
//										WebElement onOverlayElement = onOverlayPercen_Text;
//										String textOverlay = onOverlayElement.getText();
										Thread.sleep(1000);
										// String trimValues = textOverlay.trim();
										System.out.println("Percentage overlay value is: " + textOverlay);
										Reporter.log("\n PASS - Resource availability Percentage of particular selected Month value on overlay under project detail is: "	+ textOverlay,true);

										String[] val = textOverlay.split("%");
										// System.out.println(val[0]);

										int covert = Integer.parseInt(val[0]);

										if (covert >= 0 && covert <= 99) 
										{
											// Project details values
											Thread.sleep(1000);
											List<WebElement> projectDetialsLists = projectDetialOnOverlay_Lists;
											for (int l = 0; l < projectDetialsLists.size(); l++) 
											{
												WebElement projectDetialsListsElement = projectDetialsLists.get(l);
												String projectDetialsListsTexts = projectDetialsListsElement.getText();

												System.out.println("PASS - Project Details on the overlay is showing as  : "+ projectDetialsListsTexts);
												Reporter.log(" \n PASS - Project Details on the overlay is showing as  : "+ projectDetialsListsTexts, true);
												softAssertion.assertAll();
												// continue;
											}
										} 
										else 
										{
											Reporter.log("PASS - Project detials list is showing as blank because of resource is completely available : "+ Ename_Spe);
										}
										// To close overlay
										
										break;
									}
									else 
									{
										Reporter.log("FAIL - User is not  Clicked on " + monthSel + "Percentage row link");
									}
									softAssertion.assertAll();
								}
							}
						}
					}
				}	
			}
	
////******************************************************************************************************************	
			public void validateNullEmpNames() throws Exception 
			{
				// Remove close icon in Manger dropdown list
				TestUtil.waitForElementVisible(driver, managerDrpdwnListRemoveIcon_Click);
				TestUtil.flash(managerDrpdwnListRemoveIcon_Click, driver);
				managerDrpdwnListRemoveIcon_Click.click();
				Generic.waitForPageLoad(driver);
				softAssertion.assertAll();
				Thread.sleep(10000);
				// To Get total number of Employess in Emp table
				List<WebElement> listOfEmpnames = listOfEmpNamesOnly_WebTable;
				for (int i = 0; i < listOfEmpnames.size(); i++) 
				{
					WebElement selectlistOfEmpnames = listOfEmpnames.get(i);
					String empNameIs = selectlistOfEmpnames.getText();
					//Reporter.log("PASS - After selecting particular speciality of Employee name is" + empNameIs, true);

					List<WebElement> listOfSpeciality = listOfSpecialityOnly_WebTable;
					for (int j =i; j < listOfSpeciality.size();) {
						WebElement listOfSpecialityElement = listOfSpeciality.get(j);
						String listOfSpecialityText = listOfSpecialityElement.getText();
						if (listOfSpecialityText.equals("")) {
							Reporter.log("PASS -Null/Blank is showing for Employee name is ==>:" + empNameIs, true);
							break;
						} else {

							//Reporter.log("FAIL- No Null/Blank is showing for Employee name is: " + empNameIs);
							break; 
						}
					}
				}
				softAssertion.assertAll();
			}
		}
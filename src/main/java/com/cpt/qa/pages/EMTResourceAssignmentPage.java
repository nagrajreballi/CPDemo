package com.cpt.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.cpt.qa.base.TestBase;
import com.cpt.qa.util.Generic;
import com.cpt.qa.util.TestUtil;
import com.google.common.collect.Table;

public class EMTResourceAssignmentPage extends TestBase {

	public  WebElement element;

	public static WebDriverWait wait;
	
	public static JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public static SoftAssert softAssertion= new SoftAssert();
	
///////////////////////////////////// 1.Create Object repository////////////////////////////////////
	@FindBy(xpath = ".//*[text()=' EMT - Resource Assignment']")
	WebElement empResourceAssignment_tabLnk;
	
	@FindBy(xpath = ".//*[@class='ds-flex ds-flex-align-items-center ds-pad-1']//*[text()='Capacity Planner']")
	WebElement pageheadingEMTResourceAssgnment_tx;

	
	
	@FindBy(xpath = ".//*[text()=' Search EMT with Filters ']//following::div[8]//span[2]")
	WebElement practiceDrpdwnListRemoveIcon_Click;
	
	@FindBy(xpath = "//.//*[text()=' Search EMT with Filters ']//following::div[5]")
	WebElement practiceDrpdwnListTwistyDown_Click;
	
	@CacheLookup
	@FindBy(xpath = ".//*[text()='Practice :']//following::ul[1]//li")
	List<WebElement> practiceDrpdwnListAllElements_Lists;
	
	@FindBy(xpath = ".//*[text()=' Search EMT with Filters ']//following::div[6]//div[@class='c-list']")
	WebElement practiceDrpdwnListTwistyUp_Click;
	
	@FindBy(xpath = ".//*[text()=' Search EMT with Filters ']//following::div[21]")
	WebElement managerDrpdwnListTwistyDown_Click;	
	
	@CacheLookup
	@FindBy(xpath = ".//*[text()='Business Manager :']//following::ul[@class='lazyContainer']//li")
	List<WebElement> managerDrpdwnListAllElements_Lists;
	
	@FindBy(xpath = ".//*[text()=' Search EMT with Filters ']//following::div[21]//div[@class='c-list']")
	WebElement managerDrpdwnListTwistyUp_Click;
	
	
	@FindBy(xpath = ".//*[@name='myOptions3[]']")
	WebElement pipeLineDrpdwnListTwistyDown_Click;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@name='myOptions3[]']/option")
	List <WebElement> pipeLineDrpdwnListAllElements_Lists;
	
	@FindBy(xpath = ".//*[@id='mySelect3']")
	WebElement pipeLineDrpdwnListTwistyUp_Click;
	

	@CacheLookup
	@FindBy(xpath = ".//*[@role='accordion item']")
	List <WebElement> listOfProjectsNames_Lists;

	@CacheLookup
	@FindBy(xpath = ".//*[text()='-']//following::*[@class='slide_accor_nav']//ul//li")
	List <WebElement> listOfProjectsId_Lists;

	
	@FindBy(xpath = ".//*[@class='nonvisibility visibility']//input[@id='input-manger']")
	WebElement functionalManager_txtbox;

	@FindBy(xpath = ".//*[@role='option']//*[@class='mat-option-text']")
	WebElement functionalManager_faceslnk;
	

	@FindBy(xpath = ".//*[text()='Select Speciality']")
	WebElement speciality_list_lnk;

	@FindBy(xpath = ".//*[@class='ds-col-3']//*[@id='input-number']")
	WebElement addResources_txtbox;

	@FindBy(xpath = ".//*[text()=' Add Resource(s)']")
	WebElement addResources_btn;


	@FindBy(xpath = ".//*[text()='Project Name']//following::input")
	WebElement selectSpeciality_Name_txtbox;
	
	//Select Specilaity and add resources in WebTble
	@CacheLookup
	@FindBy(xpath = ".//*[text()=' Speciality(s) ']//following::*[@aria-labelledby='Column width accordion example']//*[@class='ds-col-6']//div")
	List <WebElement> showListOfSpeciality_Webtable;
		
	@CacheLookup
	@FindBy(xpath = ".//*[@class='custom_symbol']//div[text()='-']//following::div[9]//table//tbody//tr")
	List <WebElement> showListOfParticularSpecialityRows_Webtable;

	@CacheLookup
	@FindBy(xpath = ".//*[@class='custom_symbol']//div[text()='-']//following::div[9]//table//tbody//tr//td")
	List <WebElement> showListOfParticularSpecialityRowsCells_Webtable;

	@FindBy(xpath = ".//*[@class='custom_symbol']//div[text()='-']//following::div[9]//table//tbody//tr//td//a//span")
	WebElement webTableSave_btn;
	
	@FindBy(xpath = ".//*[@class='custom_symbol']//div[text()='-']//following::div[9]//table//tbody//tr//td//a[text()='Edit']")
	WebElement webTableEdit_btn;
	
	@FindBy(xpath = ".//*[@class='custom_symbol']//div[text()='-']//following::div[9]//table//tbody//tr[1]//td[3]")
	WebElement webTableUpdatePerc_btn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@class='custom_symbol']//div[text()='-']//following::div[@class='ds-col-5 title_no_of_resource']//div")
	WebElement webTableAssigned_Total;
	
	@CacheLookup
	@FindBy(xpath = ".//*[text()=' Speciality(s) ']//following::div[1]")
	WebElement FTEAvail_Count;
	
	@CacheLookup
	@FindBy(xpath = ".//*[text()=' Speciality(s) ']//following::div[2]")
	WebElement numberOfResources_Count;
	
	@FindBy(xpath= ".//*[@class='ds-row ds-overlay-content']//button//span[@class='ds-icon-close']")
	WebElement startEndDateClose;
	
	//Select datapicker
	@FindBy(xpath=".//*[@class='header']//td[3]//button[@class='headerlabelbtn yearlabel']")
	WebElement startCurrentYear;

	@FindBy(xpath=".//*[@class='header']//td[3]//button[@aria-label ='Next Year']")
	WebElement startCurrentYear_NArrowClk;
	
	@FindBy(xpath=".//*[@class='header']//*[@class='headerlabelbtn monthlabel']")
	WebElement startCurrentMonth;

	@FindBy(xpath=".//*[@class='header']//td[1]//*[@aria-label='Previous Month']")
	WebElement startCurrentMonth_NArrowClk;

	@CacheLookup
	@FindBy(xpath=".//*[@class='selector inlinedp']//table//tbody//tr//td")
	List<WebElement> startallDateOfDesiredMonth;
	
	@FindBy(xpath=".//*[@class='header']//td[3]//button[@class='headerlabelbtn yearlabel']")
	WebElement endCurrentYear;

	@FindBy(xpath=".//*[@class='header']//td[1]//*[@aria-label='Previous Month']")
	WebElement endCurrentYear_PArrowClk;
	
	@FindBy(xpath=".//*[@class='header']//*[@class='headerlabelbtn monthlabel']")
	WebElement endCurrentMonth;

	@FindBy(xpath=".//*[@class='header']//td[1]//*[@class='headerbtn mydpicon icon-mydpright headerbtnenabled']")
	WebElement endCurrentMonth_NArrowClk;

	@CacheLookup
	@FindBy(xpath=".//*[@class='selector inlinedp']//table//tbody//tr//td")
	List <WebElement> endallDateOfDesiredMonth;
	
////////////////////////////////////// 2.Initializing the Page Objects://///////////////////////////////////////
	
	public EMTResourceAssignmentPage() {
		PageFactory.initElements(driver, this);
	}

///////////////////////// 3.Action////////////////////////////////////////////////////////////////////////////////
	
	
	// Verify EMT Resource Assignment page heading after login to the application sucessfully
	public String validateEMTResourceAssignmentPageHeadingText() throws Exception {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		TestUtil.flash(pageheadingEMTResourceAssgnment_tx, driver);
		String textget = pageheadingEMTResourceAssgnment_tx.getText();
		Reporter.log("EMT resource Assigment Page Heading is showing : " +textget , true);
		return textget;
	}
			
//********************************************************************************************************************************************
	// Verify the list of practices and select particular practice in 'practice' dropdown list in Search EMT with Filters section.
		public String validatePracticeDrpdwnList(String practice) throws InterruptedException 
		{
			//TestUtil.waitForPageLoad(driver);
			//TestUtil.waitForElementVisible(driver, practiceDrpdwnListRemoveIcon_Click);
			TestUtil.isElementPresnt(driver, practiceDrpdwnListRemoveIcon_Click, TestUtil.timeout);
			TestUtil.flash(practiceDrpdwnListRemoveIcon_Click, driver);
			practiceDrpdwnListRemoveIcon_Click.click();
			softAssertion.assertAll();
			Generic.waitForPageLoad(driver);
			
			TestUtil.isElementPresnt(driver, practiceDrpdwnListTwistyDown_Click, TestUtil.timeout);
			TestUtil.flash(practiceDrpdwnListTwistyDown_Click, driver);
			practiceDrpdwnListTwistyDown_Click.click();
		//	Generic.enableImplicitlyWait();
			softAssertion.assertAll();
			
			TestUtil.isElementPresntList(driver, practiceDrpdwnListAllElements_Lists, TestUtil.timeout);
			List<WebElement> selectoPracticeList = practiceDrpdwnListAllElements_Lists;
			for (int i = 0; i < selectoPracticeList.size(); i++) 
			{
				WebElement practiceElement = selectoPracticeList.get(i);
				String practiceText = practiceElement.getText();
				Reporter.log("List of practices are  " +i+ " : " +practiceText,true);
				
				if (practiceText.equalsIgnoreCase(practice)) 
				{
					practiceElement.click();
					Generic.waitForPageLoad(driver);
					Reporter.log("PASS - User is Successfully selected " + practice + " in 'select practice' dropdown list",true);
					continue;
				}
//				else
//				{
//					Reporter.log("Fail - User is not Successfully selected " + practice + " in 'select practice' dropdown list",false);
//				}
				softAssertion.assertAll();
			}
			softAssertion.assertAll();
			
			
			TestUtil.flash(practiceDrpdwnListTwistyUp_Click, driver);
			TestUtil.isElementPresnt(driver, practiceDrpdwnListTwistyUp_Click, TestUtil.timeout);
			practiceDrpdwnListTwistyUp_Click.click();
			Generic.enableImplicitlyWait();
			softAssertion.assertAll();
			return practice;
		}
//********************************************************************************************************************************************
		//Verify the list of Managers and select particular manager in 'Manager' dropdown list in Search EMT with Filters section.
		public String validateBusinessOwnerDrpdwnList(String bm) throws InterruptedException 
		{
			Generic.enableImplicitlyWait();	
			TestUtil.flash(managerDrpdwnListTwistyDown_Click, driver);
			managerDrpdwnListTwistyDown_Click.click();
			softAssertion.assertAll();
			Generic.enableImplicitlyWait();
			//Thread.sleep(2000);
			
			List<WebElement> selectoBusinessOwnerLists = managerDrpdwnListAllElements_Lists;
			for (int i = 0; i < selectoBusinessOwnerLists.size(); i++) 
			{
				WebElement businessownereElement = selectoBusinessOwnerLists.get(i);
				String businessOwnertext = businessownereElement.getText();
				if (businessOwnertext.equalsIgnoreCase(bm)) {
					businessownereElement.click();
					Reporter.log("PASS - User is Successfully selected " + bm + " in 'select Business Owner' dropdown list",true);
					Thread.sleep(1000);
					break;
				}
//				else{
//					Reporter.log("Fail - User is not Successfully selected " + bm + " in 'select Business Owner' dropdown list",false);
//				}
				softAssertion.assertAll();
			}
			softAssertion.assertAll();
			
			TestUtil.flash(managerDrpdwnListTwistyUp_Click, driver);
			managerDrpdwnListTwistyUp_Click.click();
			Generic.enableImplicitlyWait();
			softAssertion.assertAll();
			return bm;
		}
//********************************************************************************************************************************************
		// Verify the Include Pipleline and select particular pipeline in 'Include pipeline' dropdown list in Search EMT with Filters section.
		public String validateIncludePipeLineDrpdwnList(String pline) throws InterruptedException 
		{
			
			TestUtil.flash(pipeLineDrpdwnListTwistyDown_Click, driver);
			TestUtil.isElementPresnt(driver, pipeLineDrpdwnListTwistyDown_Click, TestUtil.timeout);
			pipeLineDrpdwnListTwistyDown_Click.click();
			Reporter.log("PASS - User is clicked on dropdownlist of pipeline");
			softAssertion.assertAll();

			TestUtil.isElementPresntList(driver, pipeLineDrpdwnListAllElements_Lists, TestUtil.timeout);
			List<WebElement> selectIncludepipelineLists = pipeLineDrpdwnListAllElements_Lists;
			for (int i = 0; i < selectIncludepipelineLists.size(); i++) 
			{
				WebElement pipelineElement = selectIncludepipelineLists.get(i);
				String pipeLinetext = pipelineElement.getText();
				Reporter.log("List of include pipeline are  " +i+ " : " +pipeLinetext,true);
				if (pipeLinetext.equalsIgnoreCase(pline)) 
				{
					pipelineElement.click();
					Thread.sleep(2000);
					Generic.waitForPageLoad(driver);
					Reporter.log("PASS - User is Successfully selected " + pline + " in 'select Include pipeLine' dropdown list",true);
					Thread.sleep(1000);
					continue;
				} 
//				else
//				{
//					Reporter.log("FAIL - User is not Successfully selected " + pline + " in 'select Include pipeLine' dropdown list",false);
//				}
			}

			TestUtil.isElementPresnt(driver, pipeLineDrpdwnListTwistyUp_Click, TestUtil.timeout);
			pipeLineDrpdwnListTwistyUp_Click.click();
			Thread.sleep(2000);
			softAssertion.assertAll();
			return pline;
		}
	
//********************************************************************************************************************************************
	// Verify list of projects and select particular project link in Search EMT with Filters section.
	public String validateListOfProjectsAndSelectOne(String lprojects) throws InterruptedException
	{
		// To display list of projects
		TestUtil.isElementPresntList(driver,listOfProjectsNames_Lists , TestUtil.timeout);
		List<WebElement> selectListOfProjectsLists1 = listOfProjectsNames_Lists;
		for (int i = 0; i < selectListOfProjectsLists1.size(); i++) {
			WebElement projectsElement = selectListOfProjectsLists1.get(i);
			String projecttext = projectsElement.getText();

			String[] words = projecttext.split("\\s");

			String word1 = words[0];
			String word2 = words[1];

			String[] spliword = word2.split(",");

			String spliword1 = spliword[0];

			Reporter.log("List of projects id's are  " + i + " : " + spliword1);
			System.out.println("List of EMT projects ID's are  " + i + " : " + spliword1);

			int exp = (int) Float.parseFloat(lprojects);
			lprojects = exp + "";
			continue;
		}
		
		//Generic.enableImplicitlyWait();
		TestUtil.isElementPresntList(driver,listOfProjectsNames_Lists , TestUtil.timeout);
		List<WebElement> selectListOfProjectsLists = listOfProjectsNames_Lists;
		for (int i = 0; i < selectListOfProjectsLists.size(); i++) 
		{
			WebElement projectsElement = selectListOfProjectsLists.get(i);
			String projecttext = projectsElement.getText();
			
			String[] words = projecttext.split("\\s");
			
			String word1 = words[0];
			String word2 = words[1];
			
			String[] spliword = word2.split(",");
			
			String spliword1 = spliword[0];
			
			int exp = (int) Float.parseFloat(lprojects);
			lprojects = exp + "";
	
			if (word2.equals(lprojects + ",")) {
				projectsElement.click();
				Generic.enableImplicitlyWait();
				// Reporter.log("Project name is displaying as : " +lprojects, true);

				TestUtil.isElementPresntList(driver,listOfProjectsId_Lists , TestUtil.timeout);
				List<WebElement> total_a = listOfProjectsId_Lists;
				for (int j = 0; j < total_a.size(); j++) {
					WebElement element_b = total_a.get(j);
					String text_c = element_b.getText();
					String trimtext_c = text_c.trim();
					//System.out.println("value:" + trimtext_c);

					if (trimtext_c != null) {
						element_b.click();
						//Generic.waitForPageLoad(driver);
						Reporter.log("PASS - User is clicked on project name link " + text_c + "in list of projects");
						Thread.sleep(2000);
						break;
					} else {
						Reporter.log("Fail - User is not clicked on project name link " + text_c + "in list of projects");
					}
				}
				break;
			}
			//break;
		}
		return lprojects;
	}
//********************************************************************************************************************************************
	// Change Functional Manager
	public String validateFunctioanMangerTextBoxField(String cm) throws Exception 
	{	
		//Generic.enableImplicitlyWait();
		TestUtil.flash(functionalManager_txtbox, driver);
		TestUtil.isElementPresnt(driver, functionalManager_txtbox, TestUtil.timeout);
		WebElement changeManclickElement = null;
		for (int i = 0; i < 100; i++) {
			try {
				changeManclickElement = functionalManager_txtbox;
				//TestUtil.flash(functionalManager_txtbox, driver);
				changeManclickElement.click();
				//Generic.enableImplicitlyWait();	
				Reporter.log("PASS -User is Clicked on change manager text box");
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					System.out.println("Waiting for element to appear on DOM");
				}
			}
		}
		Reporter.log("PASS - User is clicked on Functional manager text box field");
		softAssertion.assertAll();

		TestUtil.flash(functionalManager_txtbox, driver);
		TestUtil.isElementPresnt(driver, functionalManager_txtbox, TestUtil.timeout);
		Thread.sleep(2000);
		functionalManager_txtbox.sendKeys(cm);
		//Generic.enableImplicitlyWait();	
		Reporter.log("PASS - User is added " + cm+ " in Functional manager text box field");
		softAssertion.assertAll();
		
		Thread.sleep(2000);
		TestUtil.isElementPresnt(driver, functionalManager_faceslnk, TestUtil.timeout);
		TestUtil.flash(functionalManager_faceslnk, driver);
		WebElement changeManclickOnFaceElement = null;
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(2000);
				changeManclickOnFaceElement = functionalManager_faceslnk;
				Thread.sleep(2000);
				//TestUtil.flash(changeManclickOnFaceElement, driver);
				changeManclickOnFaceElement.click();
			//	Generic.enableImplicitlyWait();	
				Reporter.log("PASS -User is Clicked on change manager text box");
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					System.out.println("Waiting for element to appear on DOM");
				}
			}
		}
		//js.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//*[@role='option']//*[@class='mat-option-text']")));
		Reporter.log("PASS - User is Sucessfully selecetd: " + cm + ": in Functional manager");
		softAssertion.assertAll();
		return cm;
	}
//********************************************************************************************************************************************
	// Click on Speciality link
		public String validateSelectSpecilityDrpdwnList(String spe) throws InterruptedException {
			WebElement specilaityClickElement = null;
			for (int i = 0; i < 100; i++) {
				try {
					specilaityClickElement = driver.findElement(By.xpath(".//*[@role='menu']//*[text()='Select Speciality ']"));
					specilaityClickElement.click();
					Reporter.log("PASS -User is Clicked on Select speciality dropdown box link");
					break;
				} catch (Exception e) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						System.out.println("Waiting for element to appear on DOM");
					}
				}
			}

			Thread.sleep(2000);	
			//js.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//*[@role='menuitem']//input[1]")));
			//Thread.sleep(2000);
			
			// Select particular Speciality
			List<WebElement> elelementClick1 = null;

			for (int i = 0; i < 20; i++) 
			{
				try 
				{
					elelementClick1 = driver.findElements(By.xpath(".//*[@role='menu']//*[@class='ds-options drop']//*[@class='ds-option']"));
					for (int ii = 0; ii < elelementClick1.size(); ii++) 
					{
						WebElement elementselected = elelementClick1.get(ii);
						String title1 = elementselected.getText();
						//Reporter.log("List of specilaity are" +i+ " : " +title1);
						
						if (title1.equals(spe)) 
						{
							Thread.sleep(4000);
							//js.executeScript("arguments[0].click();", elementselected);
							elementselected.click();
							Reporter.log("PASS - User is succesfully Selected : " +spe +" : speciality in sepciality dropdown list",true);
							continue;
						}
//						else {
//							Reporter.log("FAIL - User is not succesfully Selected : " +spe +" : speciality in sepciality dropdown list",false);
//						}
					}
					break;
				} catch (Exception e) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						System.out.println("Waiting for element to appear on DOM");
					}
				}
			}
			return spe;
		}
//********************************************************************************************************************************************
	// To add number of resources
	public String validateToaddNumberofResources(String addresource) throws Exception {
		//Thread.sleep(2000);
		TestUtil.flash(addResources_txtbox, driver);
		TestUtil.isElementPresnt(driver, addResources_txtbox, TestUtil.timeout);
		addResources_txtbox.click();
		Reporter.log("PASS - User is clicked on add resource text box field");
		Thread.sleep(2000);

		int resadd = (int) Float.parseFloat(addresource);

		addresource = resadd + "";
		addResources_txtbox.sendKeys(addresource);
		Reporter.log("PASS - User is added " + addresource+ " number of resources in add resorces text box field");
		
		Thread.sleep(2000);
		//Reporter.log("PASS - User is Sucessfully selecetd" + addresource + " in add resorces.");
		return addresource;
	}
//********************************************************************************************************************************************
	//To click on add resource button
	public void validateClickOnAddResourcesBtn() {
		WebElement ele3 = null;
		for (int i = 0; i < 200; i++) {
			try {
				ele3 = driver.findElement(By.xpath(".//*[@class='ds-col-2']//button[text()=' Add Resource(s)']"));
				TestUtil.flash(driver.findElement(By.xpath(".//*[@class='ds-col-2']//button[text()=' Add Resource(s)']")), driver);
				ele3.click();
				Thread.sleep(4000);
				Reporter.log("PASS - User is Clicked on add resources button");
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					System.out.println("Waiting for element to appear on DOM");
				}
			}
		}
	}
	
//******************************************************************************************************************************************
	
	public void verifyPercentageAvailability(String VEname, String Vmonth) throws Exception 
	{
		Thread.sleep(4000);
		
		// Verify Emp name
		List<WebElement> listOfEmpnames = driver.findElements(By.xpath(".//*//table//tbody//tr"));
		for (int i = 0; i < listOfEmpnames.size(); i++) {
			WebElement selectlistOfEmpnames = listOfEmpnames.get(i);
			String listOfEmpnamesText = selectlistOfEmpnames.getText();
			String[] NumberOfwords = listOfEmpnamesText.split("\n");

			String wordsSpec1 = NumberOfwords[0];
			Reporter.log("PASS - After selecting particular speciality for finding percentage of Employee is: " + wordsSpec1,true);
	
			String[] a1 = wordsSpec1.split("\\s");
			String aa0 = a1[0];
			String aa1 = a1[1];
			String aa2 = a1[2];
			String aa3 = a1[3];
			String aa4 = a1[4]; //If name is like A B you should comment this one
		//  String aa5 = a1[5]; //If name is like A B C D you should uncommit this one and   + " " + aa5 in if condtion

			if (wordsSpec1.equalsIgnoreCase(VEname + " " + aa2 + " " + aa3 + " " + aa4)) { // comment + " " + aa4 --if
																							// name is A B
				Thread.sleep(2000);
				List<WebElement> listOfEmpnamePercentageMonth = driver.findElements(By.xpath(".//*//table//thead//th//div[@class='quarterHeading']//div"));
				for (int j = 0; j < listOfEmpnamePercentageMonth.size(); j++) 
				{
					WebElement percentageElement = listOfEmpnamePercentageMonth.get(j);
					String textPercentage = percentageElement.getText();
					Reporter.log("PASS - Months in availaibity  for Employee name is showing " + VEname + " : "+ textPercentage, true);

					if (textPercentage.equals(" " + Vmonth + " ") || textPercentage == " " + Vmonth + " "|| textPercentage.equalsIgnoreCase("" + Vmonth + "")) 
					{
						Thread.sleep(1000);
						List<WebElement> listOfEmpnamePercentageMonthA = driver.findElements(By.xpath(".//*//table//tbody//tr//td[3]//*[starts-with(@class,'month')]"));
						for (int k = 0; k < listOfEmpnamePercentageMonthA.size(); k++) 
						{
							WebElement percentageElementA = listOfEmpnamePercentageMonthA.get(i);
							String textPercentageA = percentageElementA.getText();
							Reporter.log("PASS - For Employee name '" + VEname + " 'his availaibity percentage is ' "+ textPercentageA + " 'of the month '" + Vmonth, true);
						}
					}
				}
			}
		}
	}
	
//********************************************************************************************************************************************	
	// Speciality-details-container Table
	public String validateLisOfSpecialityTable(String specialitySelect, String SEname, String SEPercentage, String updateSEPercentage, String startYear, String startMonthName, String startDay, String endYear, String endMonthName, String endDay) throws InterruptedException 
	{
		//To show List of speciality
		
		List<WebElement> selectResourceTableLists1 = driver.findElements(By.xpath(".//*[text()=' Speciality(s) ']//following::*[@aria-labelledby='Column width accordion example']//*[@class='ds-col-6']//div"));
		for (int i = 0; i < selectResourceTableLists1.size(); i++) 
		{
			WebElement resourcelistsElements = selectResourceTableLists1.get(i);
			String specialitytext = resourcelistsElements.getText();
			String texttrim = specialitytext.trim();
			Reporter.log("PASS - Displaying list of speciality are  " + i + " : " + texttrim);
			System.out.println("PASS - Displaying list of speciality are  " + i + " : " + texttrim);
			continue;
		}
		
		Thread.sleep(4000);
		List<WebElement> selectResourceTableLists = driver.findElements(By.xpath(".//*[text()=' Speciality(s) ']//following::*[@aria-labelledby='Column width accordion example']//*[@class='ds-col-6']//div"));
		for (int i = 0; i < selectResourceTableLists.size(); i++) 
		{
			WebElement resourcelistsElements = selectResourceTableLists.get(i);
			String specialitytext = resourcelistsElements.getText();
			String texttrim = specialitytext.trim();
			//Reporter.log("PASS - Displaying list of specilaity in table order :" + texttrim);

			if (texttrim.equalsIgnoreCase(specialitySelect)) 
			{
				Thread.sleep(2000);
				Actions builder = new Actions(driver);
				builder.click(resourcelistsElements).build().perform();
				Thread.sleep(2000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,2500)", "");
				
				Thread.sleep(2000);
				List<WebElement> selectopipeline100 = showListOfParticularSpecialityRows_Webtable;
				for (int j = 0; j < selectopipeline100.size(); j++) 
				{
					Reporter.log("Number of table rows is: "+ selectopipeline100.size() + " for speciality is: " + specialitySelect);
					WebElement selectrows = selectopipeline100.get(j);
					String selectrowsText = selectrows.getText();
					
					if (selectrowsText != null) {
						Thread.sleep(2000);
						List<WebElement> selectopipelineInput = showListOfParticularSpecialityRowsCells_Webtable;
						for (int k = 0; k < selectopipelineInput.size();) {
							WebElement elementcell = selectopipelineInput.get(k);
							String textElem = elementcell.getText();

							switch (k = k + 1) {

							case 1:
								Actions name = new Actions(driver);
								TestUtil.flash(elementcell, driver);
								name.click(elementcell).build().perform();
								TestUtil.isElementPresnt(driver, elementcell, TestUtil.timeout);
							
								Thread.sleep(2000);
								name.click(elementcell).sendKeys(SEname);
								TestUtil.isElementPresnt(driver, elementcell, TestUtil.timeout);
								Thread.sleep(8000);
								name.click(elementcell).build().perform();
								Thread.sleep(2000);
								TestUtil.isElementPresnt(driver, elementcell, TestUtil.timeout);
								WebElement facesClick = null;
								for (int m = 0; m < 100; m++) {
									try {
										facesClick = functionalManager_faceslnk;
										TestUtil.flash(functionalManager_faceslnk, driver);
										Thread.sleep(2000);
										Generic.enableImplicitlyWait();
										facesClick.click();
										Thread.sleep(2000);
										Generic.enableImplicitlyWait();
										Reporter.log("User is Clicked on faces in name text box field");
										break;
									} catch (Exception e) {
										try {
											Thread.sleep(1000);
										} catch (InterruptedException e1) {
											System.out.println("Waiting for element to appear on DOM");
										}
									}
								}
								Reporter.log("PASS - User is added name in the text box field: " + SEname);
								break;
							case 3:

								Actions percentage_res = new Actions(driver);
								percentage_res.click(elementcell).build().perform();
								TestUtil.flash(elementcell, driver);
								Thread.sleep(2000);
								percentage_res.click(elementcell).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
								// builder2.click(elementcell).sendKeys(Keys.BACK_SPACE).build().perform();
								Thread.sleep(2000);
								int perceConvert = (int) Float.parseFloat(SEPercentage);
								SEPercentage = perceConvert + "";
								percentage_res.click(elementcell).sendKeys(SEPercentage).build().perform();
								Thread.sleep(2000);
								Reporter.log("PASS - User is added availability percentage in the text box field : "+ SEPercentage);
								Thread.sleep(2000);
								break;
										
							case 6: // Start Date calendar ..Clicking on calendar to open calendar widget
								Actions startDate = new Actions(driver);
								startDate.click(elementcell).build().perform();
								TestUtil.flash(elementcell, driver);
								Reporter.log("PASS - User is Clicked on the start Date picker");
								Thread.sleep(2000);
				
								// Retrieving current year value
								String currentYear = startCurrentYear.getText();
								//Reporter.log("PASS - Current year is: " +currentYear);
								TestUtil.flash(startCurrentYear, driver);

								// COnvert Float to Int
								int yearConvert = (int) Float.parseFloat(startYear);
								startYear = yearConvert + "";

								// Click on Next arrow till we get desired year
								if (!currentYear.equals(startYear)) {
									do {
										TestUtil.flash(startCurrentYear_NArrowClk, driver);
										startCurrentYear_NArrowClk.click();
										Reporter.log("PASS - User is Clicked in Next arrow link and selected year in start Date picker on overlay  is: "+startYear);
										break;
									} while (!startCurrentYear.getText().equals(startYear));
								}
								
//								if(currentYear.equals(startYear)) 
//								{	
//									Reporter.log("PASS - User is selected : " +startYear + " year");
//									break;
//								}
//								else 
//								{
//									startCurrentYear_NArrowClk.click();	
//								}

								// Select desired month after selecting desired year
								String currentMonth = startCurrentMonth.getText();
								//Reporter.log("PASS - Current year is: " +currentMonth);
								TestUtil.flash(startCurrentMonth, driver);
								if (!currentMonth.equalsIgnoreCase(startMonthName)) {
									do {
										TestUtil.flash(startCurrentMonth_NArrowClk, driver);
										startCurrentMonth_NArrowClk.click();
										//Reporter.log("PASS - User is Clicked on the Back arrow link in start Date picker" +currentMonth);
										if (currentMonth.equalsIgnoreCase(startMonthName)) {
											Reporter.log("PASS - User is selected month in start data picker on overlay is :" +startMonthName);
											break;
										}
									} while (!startCurrentMonth.getText().trim().equalsIgnoreCase(startMonthName));

								}
								Reporter.log("PASS - User is selected month in Start data picker on overlay is :" +startMonthName);
								// Find dates of desired month only

								int dayConvert = (int) Float.parseFloat(startDay);
								startDay = dayConvert + "";

								Thread.sleep(2000);
								List<WebElement> allDateOfDesiredMonth = driver.findElements(By.xpath(".//*[@class='selector inlinedp']//table//tbody//tr//td"));
								for (WebElement startDateElement : allDateOfDesiredMonth) {
									if (startDateElement.getText().trim().equals(startDay)) {
										TestUtil.flash(startDateElement, driver);
										startDateElement.click();
										Thread.sleep(2000);
										Reporter.log("PASS - User is selected day in start data picker on overlay is : : "+startDay);
										break;
									}
								}
								Thread.sleep(2000);
								break;
								
							case 7:
								// End Date calendar.click();
								Actions endDate = new Actions(driver);
								endDate.click(elementcell).build().perform();
								Reporter.log("PASS - User is Clicked on the End Date picker");
								TestUtil.flash(elementcell, driver);
								Thread.sleep(2000);

								// Retrieving current year value
								String endDate_currentYear = endCurrentYear.getText();
								TestUtil.flash(endCurrentYear, driver);
								//Reporter.log("PASS - Current year for End date is: " +endDate_currentYear);
								//endDate.click(elementcell).build().perform();
								// COnvert Float to Int
								int endDate_yearConvert = (int) Float.parseFloat(endYear);
								endYear = endDate_yearConvert + "";

								// Click on Next arrow till we get desired year
								if (!endDate_currentYear.equals(endYear)) {
									do {
										endCurrentYear_PArrowClk.click();
										TestUtil.flash(endCurrentYear_PArrowClk, driver);
										break;
									} while (!endCurrentYear.getText().equals(endYear));
								}
								Reporter.log("PASS - User is Clicked in Next arrow link and selected year in End Date picker on overlay is: "+endYear);
								// Select desired month after selecting desired year
								String endDate_currentMonth = endCurrentMonth.getText();
								TestUtil.flash(endCurrentMonth, driver);
								//Reporter.log("PASS - Current year is: " +endDate_currentMonth);
								
								if (!endDate_currentMonth.equalsIgnoreCase(endMonthName)) {
									do {
										TestUtil.flash(endCurrentMonth_NArrowClk, driver);
										endCurrentMonth_NArrowClk.click();
										//Reporter.log("User is Clicked on the Back arrow link in End Date picker" +endCurrentMonth_NArrowClk);
										if(endDate_currentMonth.equalsIgnoreCase(endMonthName)) {
											//endCurrentMonth_NArrowClk.click();
											break;
										}
									} while (!endCurrentMonth.getText().trim().equalsIgnoreCase(endMonthName));	
								}
								Reporter.log("PASS - User is selected month in End data picker on overlay is :" +endMonthName);

								// Find dates of desired month only
								int endDate_dayConvert = (int) Float.parseFloat(endDay);
								endDay = endDate_dayConvert + "";

								List<WebElement> endDate_dayConvert_allDateOfDesiredMonth = endallDateOfDesiredMonth;
								for (WebElement endDateElement : endDate_dayConvert_allDateOfDesiredMonth) {
									if (endDateElement.getText().trim().equals(endDay)) {
										TestUtil.flash(endDateElement, driver);
										endDateElement.click();
										Reporter.log("PASS - User is selected day in End data picker on overlay is : : "+endDay);
										break;
									}
								}
								Thread.sleep(2000);
								break;
							case 8:		
										Thread.sleep(2000);
										Actions save_btn = new Actions(driver);
										Thread.sleep(2000);
										TestUtil.flash(webTableSave_btn, driver);
										save_btn.click(webTableSave_btn).build().perform();
										Thread.sleep(8000);
										Reporter.log("PASS - User is succesfully saved Emp name in particular speciality list");
										
										//Edit
										Actions edit_btn = new Actions(driver);
										Thread.sleep(2000);
										TestUtil.flash(webTableEdit_btn, driver);
										edit_btn.click(webTableEdit_btn).build().perform();
										Thread.sleep(2000);
										Reporter.log("PASS - User is clicked on edit icon in particular speciality list resources");
										
										//update 
										Actions update_btn = new Actions(driver);
										Thread.sleep(2000);
										TestUtil.flash(webTableUpdatePerc_btn, driver);
										update_btn.click(webTableUpdatePerc_btn).build().perform();
										Thread.sleep(2000);
										update_btn.click(webTableUpdatePerc_btn).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
										Thread.sleep(2000);
										int perceConvertUpdate = (int) Float.parseFloat(updateSEPercentage);
										updateSEPercentage = perceConvertUpdate + "";
										update_btn.click(webTableUpdatePerc_btn).sendKeys(updateSEPercentage).build().perform();
										Thread.sleep(2000);
										Reporter.log("PASS - User is updated with new percentage data : " +updateSEPercentage);
										Thread.sleep(2000);
										
										//save after updating
										Thread.sleep(2000);
										Actions saveupdate_btn = new Actions(driver);
										Thread.sleep(2000);
										TestUtil.flash(webTableSave_btn, driver);
										saveupdate_btn.click(webTableSave_btn).build().perform();
										Thread.sleep(8000);
										Reporter.log("PASS - User is succesfully saved with new percentage data after updating in particular speciality list");
										
										break;	
							default:
										//System.out.println("If not satishfy above any Cases then it will come in default case");
							}
						}
						break;
					}
					//break;
				}
			}
			//break;
		}
		return specialitySelect;
	}
//********************************************************************************************************************************************
	//To Assign Number of Resources in projects depends on specaility
	public void validateAssignedTotal() throws InterruptedException {
		
		Thread.sleep(2000);
		String textAssigned = webTableAssigned_Total.getText();
		TestUtil.flash(webTableAssigned_Total, driver);
		
		Reporter.log("PASS -  Assigned/Total number of resources is : " +textAssigned);
		
	}
	
//********************************************************************************************************************************************
	//To verify FTE
	public  void validateFTEAvailability() throws InterruptedException {
			
		Thread.sleep(2000);
			String textAvail = FTEAvail_Count.getText();
			TestUtil.flash(FTEAvail_Count, driver);
			
			Reporter.log("PASS -  FTE availability is showing in Table column header is : " +textAvail);
		}
//********************************************************************************************************************************************
	//To verify Number of Resources
public void validateNumberOfResources() throws InterruptedException {
	Thread.sleep(2000);
	TestUtil.flash(numberOfResources_Count, driver);
		String textNumberofResources = numberOfResources_Count.getText();
		
		Reporter.log("PASS -  Number of Resources is showing in Table column header is : " +textNumberofResources);
		
	}
}
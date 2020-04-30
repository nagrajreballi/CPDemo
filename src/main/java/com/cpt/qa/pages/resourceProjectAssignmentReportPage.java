package com.cpt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cpt.qa.base.TestBase;

public class resourceProjectAssignmentReportPage extends TestBase{
	
///////////////////////////////////// 1.Create Object repository////////////////////////////////////
	
	@FindBy(xpath = ".//*[text()='Resource - Project Assignment Report ']")
	WebElement resourceProjectAssignmentReport_tabLnk;

//////////////////////////////////////2.Initializing the Page Objects://///////////////////////////////////////

public resourceProjectAssignmentReportPage() {
PageFactory.initElements(driver, this);
}

///////////////////////// 3.Action////////////////////////////////////////////////////////////////////////////////


}

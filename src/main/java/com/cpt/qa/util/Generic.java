package com.cpt.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.cpt.qa.base.TestBase;
import com.google.common.base.Function;

/*
 * Author : Manjunath
 * Created on : 01/09/2015
 * Last Modified : 03/09/2015
 */

public class Generic 
{
	
	public static String getStringCellValue(String excelPath, String sheetName, int row, int col)
	{
		String var = null;
		try
		{
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			var = sh.getRow(row).getCell(col).getStringCellValue();
			
		}catch(Exception e)
		{
			failATestCase("Exception occured in fetching string cell value. "+e.getMessage());
		}
		return var;
	}
	
	public static void setStringCellValue(String excelPath, String sheetName, int row, int col,String value)
	{
		try
		{
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
//			wb.getSheet(sheetName).getRow(row).getCell(col).setCellValue(value);
			if(wb.getSheet(sheetName) == null){wb.createSheet(sheetName);}
			if(wb.getSheet(sheetName).getRow(row) == null){wb.getSheet(sheetName).createRow(row);}
			if(wb.getSheet(sheetName).getRow(row).getCell(col) == null){wb.getSheet(sheetName).getRow(row).createCell(col);}
			if(wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue() == null){wb.getSheet(sheetName).getRow(row).getCell(col).setCellValue(value);}
			else
			{
				wb.getSheet(sheetName).getRow(row).getCell(col).setCellValue(value);
			}
			
			FileOutputStream fos = new FileOutputStream(excelPath);
			wb.write(fos);
			fos.close();
			
		}catch(Exception e)
		{
			failATestCase("Exception occured in setting string cell value : "+e.getMessage());
		}
	}
	
	public static long getNumericCellValue(String excelPath, String sheetName, int row, int col)
	{
		long num = 0;
		try
		{
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			num = (long) sh.getRow(row).getCell(col).getNumericCellValue();
			
		}catch(Exception e)
		{
			Reporter.log("Exception occured in fetching string cell value : "+e,true);
		}
		return num;
	}
	
	public static Map<String, String> getKEY_VALUE_OnColCondition(String excelPath, String sheetName,int conditionCol,int valuesPresentInColumn, String[] strList)
	{
		Map<String, String> map = new HashMap<String, String>();
		String var = null;
		try
		{
//			int rowCount = Generic.getRowCount(excelPath, sheetName);
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Iterator<Row> shIt = sh.iterator();
			 while (shIt.hasNext()) 
			 {
				 Row row = shIt.next();
				 
				 for(int i=0;i<strList.length;i++)
		            {
					 	String firstColEle = row.getCell(conditionCol).getStringCellValue();
		            	if(firstColEle.equals(strList[i]))
		            	{
		            		var=row.getCell(valuesPresentInColumn).getStringCellValue();
		            		map.put(firstColEle, var);
		            	}
		            }
			 }
		}
		catch(NullPointerException n)
		{
			Reporter.log("Exception occured : "+n);
		} catch (FileNotFoundException e) {
			Reporter.log("File not found for the given path",true);
		}  catch (Exception e) {
			Reporter.log("Exception occured : "+e,true);
		}
		return map;
		
	}
	
	public static HashMap<String,String> getExcelDataKey_value(String excelPath, String sheetName)
	{
		String key =null;
		String value = null;
		HashMap<String, String> hm = new HashMap<String,String>();
		try{
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Iterator<Row> shIt = sh.iterator();
			
			while(shIt.hasNext()){
				Row rw = shIt.next();
				 for(int j=0;j<rw.getLastCellNum();j++)
		            {
					 	key = rw.getCell(0).getStringCellValue();
					 	value = rw.getCell(1).getStringCellValue();
		            }
				 hm.put(key, value);
			}
			return hm;
		}catch(Exception e){
			System.out.println("Exception occured"+e);
		}
		return null;
		
	}
	
	public static String getValues_BasedOnInputColumn(String excelPath, String sheetName,int conditionCol,int valuesPresentInColumn, String stringToSrch)
	{
		String returnValue = null;
		try
		{
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Iterator<Row> shIt = sh.iterator();
			 while (shIt.hasNext()) 
			 {
				 Row row = shIt.next();
				 String firstColEle = row.getCell(conditionCol).getStringCellValue();
	            	if(firstColEle.equals(stringToSrch))
	            	{
	            		returnValue=row.getCell(valuesPresentInColumn).getStringCellValue();
	            		return returnValue;
	            		
	            	}

			 }
		}
		catch(NullPointerException n)
		{
			Reporter.log("Exception occured : "+n);
		} catch (FileNotFoundException e) {
			Reporter.log("File not found for the given path",true);
		}  catch (Exception e) {
			Reporter.log("Exception occured : "+e,true);
		}
		return returnValue;
		
	}

	
	public static int getRowCount(String excelPath, String sheetName)
	{
		int count=-1;
		try
		{
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			count = wb.getSheet(sheetName).getLastRowNum();
		}catch(Exception e)
		{
			failATestCase("Exception occured in fetching row count from excel. Crosscheck the excel --->"+excelPath+"--->"+sheetName);
		}
		return count;
	}
	
	public static int getLastCellNumber(String excelPath, String sheetName, int row)
	{
		int cell=-1;
		try
		{
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			cell = wb.getSheet(sheetName).getRow(row).getLastCellNum();
			
		}catch(Exception e)
		{
			Reporter.log("Exception occured in reading excel : "+e,true);
		}
		return cell;
	}

	public static boolean waitForElementVisible(WebDriver driver, WebElement element)
	{
		
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.withTimeout(10, TimeUnit.SECONDS).pollingEvery(1000, TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			
		}catch(TimeoutException t){
			return false;
			
		}catch(Exception e)
		{
			failATestCase("Exception occured while waiting for element to be visible."+e);
		}
		return false;
	}
	
	public static String waitForLoadingMessage(WebDriver driver){
		forceSleep(1000);
		String loadMsg = null;
		WebElement loadingElement;
		try
		{
			loadingElement = driver.findElement(By.className("loading-message"));
			if(loadingElement.isDisplayed())
			{
				loadMsg = loadingElement.getText();
				Reporter.log("Loading message --> "+loadMsg,true);
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.withTimeout(30, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);
				wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(loadingElement, loadMsg)));
				waitForPageLoad(driver);
			}
		}catch(NoSuchElementException e)
		{
			Reporter.log("No loading message is displayed.1",true);
		}catch(Exception e)
		{
			Reporter.log("No loading message is displayed.2",true);
		}
		return loadMsg;
	}
	
	public static void waitForElementToClick(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.withTimeout(10, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForElements_List(WebDriver driver, List<WebElement> elements)
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.withTimeout(15, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
			
	public static boolean waitForTitlePresent(WebDriver driver, String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.withTimeout(15, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);
		return wait.until(ExpectedConditions.titleContains(title));
	}
	
	public static boolean waitForTitleNotPresent(WebDriver driver, String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.withTimeout(15, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);
		return wait.until(ExpectedConditions.not(ExpectedConditions.titleContains(title)));
	}
	
	public static boolean waitForElementNotToBeSelecetd(WebDriver driver, WebElement element)
	{
		nullifyImplicitlyWait();
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.withTimeout(10, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);
			return wait.until(ExpectedConditions.elementSelectionStateToBe(element, false));
		}
		finally
		{
			enableImplicitlyWait();
		}
	}
	
	
	public static void waitForUrl(WebDriver driver, String url)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.withTimeout(30, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.urlContains(url));
	}
		
	public static boolean validatePageTitleContains(WebDriver driver, String actualTitle)
	{
		try
		{
			waitForTitlePresent(driver, actualTitle);
			Assert.assertEquals(actualTitle, driver.getTitle());
//			Reporter.log("Assertion done on page title.",true);
			return true;
		}catch(Exception e)
		{
			Generic.failATestCase("Exception occured in validating page title"+e);
		}
		return false;
	}
	
	public static void doAssertion(String actual, String expected)
	{
		Assert.assertEquals(actual, expected);
		Reporter.log("PASS : Assertion done on : "+actual,true);
	}
	
	public static void doAssertion(Object actual, Object expected,String message)
	{
		Assert.assertEquals(actual, expected, message);
		Reporter.log("PASS : Assertion done on : "+actual,true);
	}
	
	public static void doAssertion(WebDriver driver,WebElement actual, String xpath)
	{
		String obtainedTxt = driver.findElement(By.xpath(xpath)).getText();
		String actualTxt=actual.getText();
		Assert.assertEquals(actualTxt, obtainedTxt);
//		Reporter.log("Assertion done on.");
	}
	
	public static String selectvalueFromDropDownBySelectClass(List<WebElement> we,String actual)
	{
		String selected = null;
		int index = -1;
		try
		{	
			List<WebElement> list = we;
			int count = list.size();
			for(int i=0; i<count;i++)
			{
				String obtained = list.get(i).getText().trim();
				if(actual.equals(obtained))
				{
					index=i;
					selected=obtained;
					break;
				}else if(obtained.equals("No results found")){
					return null;
				}
					
			}
			list.get(index).click();
//			Generic.forceSleep(2000);
			
		}catch(Exception e)
		{
			Reporter.log("Exception occured in selecting data from drop down"+e.toString(),true);
			
		}
		return selected;
	}
	
	public static String selectACountry(List<WebElement> we,String actual)
	{
		String selected = null;
		int index = -1;
		try
		{	
			List<WebElement> list = we;
			int count = list.size();
			for(int i=0; i<count;i++)
			{
				String obtained = list.get(i).getText().trim();
				if(actual.equals(obtained))
				{
					index=i;
					selected=obtained;
					break;
				}
			}
			list.get(index).click();
			Generic.forceSleep(2000);
			
		}catch(Exception e)
		{
			Reporter.log("Exception occured in selecting data from drop down"+e.toString(),true);
		}
		return selected;
	}
	
	public static void waitForPageLoad(final WebDriver driver)
	{
		forceSleep(1000);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
		
	public static void failATestCase(String message)
	{
		Reporter.log("FAIL- "+message,true);
		Assert.fail(message);
	}
	
	public static void failATestCaseBySoftAssert(String message)
	{
		Reporter.log("FAIL- "+message,true);
		SoftAssert sa = new SoftAssert();
		sa.fail(message);
		sa.assertAll();
	}
	
	public static void moveToElement(final WebElement ele, WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
//		act.moveToElement(clickOnEle) .build().perform();
		
	}

	public static void nullifyImplicitlyWait()
	{
		TestBase.driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	public static void enableImplicitlyWait()
	{
		TestBase.driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	
	public static void waitForDOMLoad(final WebDriver driver) 
	{
		/*WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.withTimeout(10, TimeUnit.SECONDS).pollingEvery(200, TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);
		ExpectedCondition<Boolean> pageLoadCondition = new
		       ExpectedCondition<Boolean>() {
		           public Boolean apply(WebDriver dr) {
		           	return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
		           }
		       };
		       wait.until(pageLoadCondition);*/
	 }
	
	/*public static void waitForDOMLoad(WebDriver driver)
	{
		nullifyImplicitlyWait();
		FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);
		try{
			Function<WebDriver, Boolean> fun = new Function<WebDriver, Boolean>(){
				public Boolean apply(WebDriver driver){
					if(((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete")){
						return true;
					}else{
						return false;
					}
					
				}
				
			};
			if(false==wait.until(fun)){
//				Generic.failATestCase("waited for 10 sec to page laod");
				doSoftAssertion(false, "waited for 10 sec to page laod");
			}
		}catch (NoSuchElementException e){
			Generic.failATestCase("Exception occured in DOMLoad");
		}finally{
			enableImplicitlyWait();
		}

	}*/
	
	public static boolean waitForElement(final WebElement element)
	{
		nullifyImplicitlyWait();
		FluentWait<WebElement> wait = new FluentWait<WebElement>(element);
		wait.withTimeout(10, TimeUnit.SECONDS).pollingEvery(200, TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);
		try
		{
			Function<WebElement, Boolean> fun = new Function<WebElement, Boolean>()
			{

						@Override
						public Boolean apply(WebElement ele) 
						{
							if(!element.isDisplayed())
							{
								return false;
							}
							else
							{
								return true;
							}
							
						}
			};
			return wait.until(fun);
		}catch (TimeoutException e)
		{
			return false;
		}
		catch (NoSuchElementException e)
		{
			return false;
		}
		finally
		{
			enableImplicitlyWait();
		}
		
	}
	
	public static boolean waitForElementNotPresent(final WebElement element)
	{
		nullifyImplicitlyWait();
		FluentWait<WebElement> wait = new FluentWait<WebElement>(element);
		wait.withTimeout(10, TimeUnit.SECONDS).pollingEvery(200, TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);
		try
		{
			Function<WebElement, Boolean> fun = new Function<WebElement, Boolean>()
					{

						@Override
						public Boolean apply(WebElement ele) 
						{
							if(!element.isDisplayed())
							{
								return true;
							}
							else
							{
								return false;
							}
							
						}
					};
						return wait.until(fun);
		}catch (TimeoutException e)
		{
			return false;
		}
		catch (NoSuchElementException e)
		{
			return false;
		}
		finally
		{
			enableImplicitlyWait();
		}
		
	}
	
	public static boolean waitForElement_List(final List<WebElement> element)
	{
		nullifyImplicitlyWait();
		FluentWait<WebElement> wait = new FluentWait<WebElement>((WebElement) element);
		wait.withTimeout(10, TimeUnit.SECONDS).pollingEvery(200, TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);
		try
		{
			Function<WebElement, Boolean> fun = new Function<WebElement, Boolean>()
					{

						@Override
						public Boolean apply(WebElement ele) 
						{
							if(!((WebElement) element).isDisplayed()){
								return false;
							}
							else
							{
								return true;
							}
							
						}
					};
						return wait.until(fun);
		}catch (TimeoutException e)
		{
			return false;
		}
		catch (NoSuchElementException e)
		{
			return false;
		}
		finally
		{
			enableImplicitlyWait();
		}
		
	}
	
	public static boolean waitForElement_LongPeriod(final WebElement element)
	{
		nullifyImplicitlyWait();
		FluentWait<WebElement> wait = new FluentWait<WebElement>(element);
		wait.withTimeout(15, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);
		try
		{
			Function<WebElement, Boolean> fun = new Function<WebElement, Boolean>()
					{

						@Override
						public Boolean apply(WebElement ele) 
						{
							if(!element.isDisplayed())
							{
								return false;
							}
							else
							{
								return true;
							}
							
						}
					};
						return wait.until(fun);
		}catch (TimeoutException e)
		{
//			enableImplicitlyWait();
			return false;
		}
		catch (NoSuchElementException e)
		{
			return false;
		}
		finally
		{
			enableImplicitlyWait();
		}
		
	}
	
	public static boolean waitForElement_smallPeriod(final WebElement element)
	{
		nullifyImplicitlyWait();
		FluentWait<WebElement> wait = new FluentWait<WebElement>(element);
		wait.withTimeout(2, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS);
		try
		{
			Function<WebElement, Boolean> fun = new Function<WebElement, Boolean>()
					{

						@Override
						public Boolean apply(WebElement ele) 
						{
							if(!element.isDisplayed())
							{
								return false;
							}
							else
							{
								return true;
							}
							
						}
					};
						return wait.until(fun);
		}catch (TimeoutException e){
//			enableImplicitlyWait();
			return false;
		}catch (NoSuchElementException e){
			return false;
		}
		finally
		{
			enableImplicitlyWait();
		}
		
	}	
	
//	public static void switchToThirdWindow(WebDriver driver)
//	{
//		try{
//			int size=-1;
//			waitForPageLoad(driver);
//			Set<String> allHandles = driver.getWindowHandles();
//			size = allHandles.size();
//			String presentHandle=null;
//			if(size > 1)						/*old is if(size==2)*/
//			{
//				Iterator<String> it = allHandles.iterator();
//				while(it.hasNext())
//				{
//					presentHandle=it.next();
//					if(!(SuperTestNG.parentWh.equals(presentHandle)) && !(MailinatorPage.mailinatorWindowHandle.equalsIgnoreCase(presentHandle)))
//					{
//						System.out.println("user is in 3rd child browser.");
//						driver.switchTo().window(presentHandle);
////						driver.navigate().to(url);
//					}
//			    }
//				
//			
//			}
//			else
//			{
//				Generic.failATestCase("New window was not opened. Their is only 1 window opened.");
//			}
//		}catch(Exception e){
//			Generic.failATestCase("Exception in Generic.switchToThirdWindow()."+e);
//		}
//		
//	}
	
	
	public static void switchToParentWindow(WebDriver driver)
	{
		driver.close();
		driver.switchTo().window(TestBase.parentWh);
	}
	
	
	public static String[] loopExcelSheetForData(String excelPath, String sheetName, int startRow, int col) {
		int rowCount = getRowCount(excelPath, sheetName);
		String[] var = new String[rowCount];
		int j = 0;
		for (int i = startRow; i <= rowCount; i++) {
			var[j] = getStringCellValue(excelPath, sheetName, i, col);
			j++;
		}
		return var;
	}

	public static boolean isPresentAndDisplayed(final WebElement element) 
	{
		  try {
		    return element.isDisplayed();
		  } catch (NoSuchElementException e) {
		    return false;
		  }
	}
		
	public static Object[][] OneDimToTwoDim( final String[] array, final int rows, final int cols ) 
	{
	    if (array.length != (rows*cols))
	        throw new IllegalArgumentException("Invalid array length");

	    String[][] bidi = new String[rows][cols];
	    for ( int i = 0; i < rows; i++ )
	        System.arraycopy(array, (i*cols), bidi[i], 0, cols);
	    
//	    for (String[] arr : bidi) {
//        }
	    return bidi;
	}
	
	public static void typeDataAndPressTab(String s) 
	{
		Robot robo = null;
		try {
			robo = new Robot();
			robo.setAutoDelay(20);
			byte[] bytes = s.getBytes();
			
			for(Byte b: bytes)
			{
				int code=b;
				if(code>96 && code <123)
				{
					code=code-32;
					robo.keyPress(code);
					robo.keyRelease(code);
					robo.setAutoDelay(20);
				}
				else if(code>64 && code<91)
				{
					robo.keyPress(KeyEvent.VK_SHIFT);
					robo.keyPress(code);
					robo.setAutoDelay(20);
					robo.keyRelease(code);
					robo.keyRelease(KeyEvent.VK_SHIFT);
					
				}
				else
				{
					robo.keyPress(code);
					robo.setAutoDelay(20);
					robo.keyRelease(code);
				}
							
				
			}
			robo.setAutoDelay(20);
			robo.keyPress(KeyEvent.VK_TAB);
			robo.keyRelease(KeyEvent.VK_TAB);
			
			
		} catch (AWTException e) 
		{
			Reporter.log("Exception Inside typeData method while entering authentication data",true);
		}
		
	}
	
	
	
	public static void pressEnterBtn()
	{
		Robot robo;
		try {
			robo = new Robot();
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);
			
		} catch (AWTException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void forceSleep(int timeInMilliSec)
	{
		try {
			Thread.sleep(timeInMilliSec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int randomNumberGenerator()
	{
		int num;
		Random random = new Random();
		num=random.nextInt(1500);
		return num;
	}
	
	public static String alterEmailId_randomgenerator(String email)
	{
		StringTokenizer st = new StringTokenizer(email, "@");
		
		return (String)st.nextElement()+randomNumberGenerator()+"@"+st.nextElement();
		
	}
	
//	public static String alterEmailId(String email)
//	{
//		String key = getStringCellValue(Constants.DATA_SETUP_PATH, "MailosaurCredentials", 1, 1);
//		StringTokenizer st = new StringTokenizer(email, "@");
//		if(SuperTestNG.url.contains("wwwtest.ibm"))
//		{
////			return ((String) st.nextElement()+randomNumberGenerator()+"cdt@"+st.nextElement());
//			return ((String) st.nextElement()+"cdt"+randomNumberGenerator()+"."+key+"@"+st.nextElement());
//		}else if(SuperTestNG.url.contains("wwwstage.ibm"))
//		{
////			return ((String) st.nextElement()+randomNumberGenerator()+"stg@"+st.nextElement());
//			return ((String) st.nextElement()+"stg"+randomNumberGenerator()+"."+key+"@"+st.nextElement());
//		}else if(SuperTestNG.url.contains("www.ibm"))
//		{
////			return ((String) st.nextElement()+randomNumberGenerator()+"prd@"+st.nextElement());
//			return ((String) st.nextElement()+"prod"+randomNumberGenerator()+"."+key+"@"+st.nextElement());
//		}else
////			return ((String) st.nextElement()+randomNumberGenerator()+"tst@"+st.nextElement());
//			return ((String) st.nextElement()+"_dummy"+randomNumberGenerator()+"."+key+"@"+st.nextElement());
//		
//	}
	
	public static void provideAuthentication()
	{
		try {
			Runtime.getRuntime().exec("./Authentication.exe");
		} catch (IOException e) {
			Reporter.log("Exception in providing authentication.",true);
		}
	}
	
	public static void doSoftAssertion(String obtained,String expected)
	{
		TestBase.softAssertion.assertEquals(obtained, expected,"Soft assertion for : "+expected);
	}
	
	public static void doSoftAssertion(boolean condition,String message)
	{
		TestBase.softAssertion.assertTrue(condition,message);
	}
	
	public static void doSoftAssertion(boolean obtained,boolean actual,String message)
	{
		TestBase.softAssertion.assertNotEquals(obtained, actual, message);
	}
	
	public static void refreshPage(WebDriver driver)
	{
		driver.navigate().refresh();
		waitForPageLoad(driver);
	}
	
	public static int getResponseCodeForEachLink(String urlString) {
		HttpURLConnection hUrlCon;
		int code=0;	
		
		try {
			URL url = new URL(urlString);
			hUrlCon = (HttpURLConnection) url.openConnection();
			hUrlCon.setRequestMethod("GET");
			hUrlCon.connect();
			code = hUrlCon.getResponseCode();
			if (code == 200) {
				return code;
			}
		} catch (Exception e) {
			Generic.failATestCase("Exception occured in checking the link- "+urlString+" -->"+e);
		}
		return code;

	}
	
//	public static void setConfigProperties(String obtainedUrl)
//	{
//		Properties ppt = new Properties();
//		OutputStream out = null;
//		
//		try{
//			out=new FileOutputStream(Constants.STORED_PPT_PATH);
//			ppt.setProperty("url", obtainedUrl);
//			ppt.store(out, "Storing data");
//		}catch(IOException io){
//			Generic.failATestCase("Unable to set the properties");
//		}finally {
//			if (out != null) {
//				try {
//					out.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//
//	}
	
//	public static HashMap<String, String> getConfigProperties()
//	{
//		HashMap<String, String> hm = new HashMap<String, String>();
//		Properties ppt = new Properties();
//		InputStream input = null;
//		
//		try
//		{
//			input=new FileInputStream(Constants.LOAD_PPT_PATH);
//			ppt.load(input);
//			Iterator<Entry<Object, Object>> it = ppt.entrySet().iterator();
//			while(it.hasNext()){
//				Entry<Object, Object> entry = it.next();
//				hm.put(entry.getKey().toString(), entry.getValue().toString());
//			}
//			
//			return hm;
//			
//			
//		}catch(IOException io)
//		{
//			
//		}finally {
//			if (input != null) {
//				try {
//					input.close();
//				} catch (IOException e) {
//					Generic.failATestCase("Unable to close the input property file");
//				}
//			}
//		}
//		
//		return null;
//		
//	}
	
//	public static String fecthDetailFromAdopterPage(String adopUrl,String key) throws IOException, ParseException
//	{
//
//		 String searchedValue; 
//		 int start=adopUrl.indexOf("a=")+2;
//		 int end = adopUrl.indexOf("&", start);
//		 String adopter_Name = adopUrl.substring(start, end);
//		 String jsonFileUrl = Constants.ENVT+"/account/ibmidutil/js/lang/us-en/msgs/"+adopter_Name+"_C001_us_en.js";
//		 searchedValue = getResponseFromJsonFile(jsonFileUrl,key);
//
//			return searchedValue;
//	} 

	public static String getResponseFromJsonFile(String jUrl, String key) throws IOException 
	{	
			key = key+"\"";
			int length = key.length()+3;
	        URL website = new URL(jUrl);
	        URLConnection connection = website.openConnection();
	        BufferedReader in = new BufferedReader(
	                                new InputStreamReader(
	                                    connection.getInputStream()));

	        StringBuilder response = new StringBuilder();
	        String inputLine;

	        while ((inputLine = in.readLine()) != null) 
	            response.append(inputLine);

	        in.close();

	        String content =  response.toString();
	        StringTokenizer st = new StringTokenizer(content.substring(content.lastIndexOf(key)+length), "\"]");
			return (String) st.nextElement();
	 }
			
}

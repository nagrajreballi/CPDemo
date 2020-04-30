package com.cpt.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.asserts.SoftAssert;

import com.cpt.qa.util.TestUtil;

public class TestBase 
{
	public static  WebDriver driver;
	public static Properties prop;
	public static File classpathRoot;
	public static String parentWh;
	public static SoftAssert softAssertion= new SoftAssert();
	
	//Constructor
	public TestBase()
	{
		try
		{
			prop=new Properties();
			classpathRoot = new File(System.getProperty("user.dir"));
			//System.out.print(classpathRoot);
			FileInputStream ip=new FileInputStream(classpathRoot + "/src/main/java/com/cpt/qa/config/config.properties");
			//System.out.print(ip);
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	//Initialization
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", classpathRoot + "/Drivers/Chrome/chromedriver.exe");	
			driver = new ChromeDriver();
		}
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers/Firefox/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./Drivers/IE/");	
			driver = new InternetExplorerDriver(); 
		}
		else if (browserName.equals("Safari")) 
		{
			System.setProperty("webdriver.safari.driver", "./Drivers/Chrome/safaridriver/");			
			driver = new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);//here we need to add dynamic waits
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		parentWh = driver.getWindowHandle();
		driver.get(prop.getProperty("url"));
	}
}

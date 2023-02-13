package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.TakesScreenshot;
import com.inetBanking.utilities.ReadConfig;

public class BaseClass
{
	ReadConfig read = new ReadConfig();

	public String baseURL = read.getApplicationURL();
	public String username = read.getUserName();
	public String password = read.getPassword();
	public static WebDriver driver;

	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws Exception
	{
		logger = Logger.getLogger("inetBankingV1");
		PropertyConfigurator.configure("log4j.properties");

		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",read.getChromepath());
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",read.getfirefoxpath());
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");	
	}
	

	public String randometring() 
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return generatedstring;
	}
	
	
}

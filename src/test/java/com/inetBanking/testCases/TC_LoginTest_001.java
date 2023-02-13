package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void logintest() throws IOException
	{

		logger.info("URL is opened");

		LoginPage lp = new LoginPage(driver);

		lp.setUserName(username);
		logger.info("username is entered");

		lp.setPassword(password);
		logger.info("password is entered");

		lp.clickSubmit();
		logger.info("clicked on submit");

		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("login test passed");
			System.out.println("Title of the page is "+driver.getTitle());
		}
		else
		{
			captureScreen(driver,"logintest");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
	}
}

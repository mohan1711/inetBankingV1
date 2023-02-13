package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	Properties pro;

	public ReadConfig()
	{
		File src = new File("E:\\Eclipse programs\\inetBankingV1\\Configuration\\config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} 
		catch (Exception e)
		{
			System.out.println("Exception is "+e.getMessage());
		}
	}
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getUserName()
	{
		String username = pro.getProperty("username");
		return username;
	}

	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}

	public String getChromepath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getfirefoxpath()
	{
		String chromepath = pro.getProperty("firefoxpath");
		return chromepath;
	}
}


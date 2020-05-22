package com.bank.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	public static void initialization() throws IOException 
	{
		// Loading .config properties file
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\bank\\config\\config.properties");
		prop.load(fis);
		String s=prop.getProperty("browser");
		if(s.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\work\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(s.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D\\Selenium\\work\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(s.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\Selenium\\work\\IEDriverServer");
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	}

}

package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TestBase {

	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener ;
	public static Properties prop = new Properties();
	
	

	public TestBase() {
		/*
		 * Steps to read Property: 1.Create Object of Properties class. 2.Create
		 * object of FileInputStream class. 3.Pass the path of .properties file
		 * in FileInputStream constructor, while creating object. 4.Load input
		 * file using load() of Properties class passing ip as
		 * variable.//establish connection
		 * 
		 */
/****************************************important code*********************************************************/
		FileInputStream ip;
		try {
			ip = new FileInputStream(
					"/Users/AmSu/workspace/FreeCRMTest/src/main/" + "java/com/crm/qa/config/config.properties");
			// enhancement-(file path-change to user.dir)
			prop.load(ip);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
/****************************************important code*********************************************************/
	}
	/*
	 * public static void main(String[] args){ try { TestBase.readConfig(); }
	 * catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */

	public static void initialize() {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/AmSu/workspace/FreeCRMTest/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("", "/Users/AmSu/workspace/FreeCRMTest/Drivers/");
			driver = new FirefoxDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("", "/Users/AmSu/workspace/FreeCRMTest/Drivers/");
			driver = new InternetExplorerDriver();
		} else if (browserName.equals("safari")) {
			System.setProperty("", "/Users/AmSu/workspace/FreeCRMTest/Drivers/");
			driver = new SafariDriver();
		} else
			System.out.println("Browser is not set in property file");
		
		e_driver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICILTY_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		
		
	}

}

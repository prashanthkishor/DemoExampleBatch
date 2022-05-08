package com.sgtesting.actiTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Scenario44 {
	public static WebDriver wb=null;
	@BeforeClass
	public static void OpenBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "F:\\SampleAutomation\\Web-Automation2\\Library\\driver\\chromedriver.exe");
			wb=new ChromeDriver();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=1)
	private static void Navigate()
	{
		try
		{
			wb.get("http://localhost:81/login.do");
			Thread.sleep(2000);		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority=2,dataProvider="credentials")
	private static void Login(String user,String pwd)
	{
		try
		{
			wb.findElement(By.id("username")).sendKeys(user);
			wb.findElement(By.name("pwd")).sendKeys(pwd);
			Thread.sleep(2000);
			wb.findElement(By.xpath("//*[@id=\'loginButton\']/div")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@DataProvider(name="credentials")
	public Object[][] getlogindetails()
	{
		return new Object[][] {{"admin","manager"}};
	}
	@Test(priority=3)
	private static void minimizeflyout()
	{
		try
		{
			wb.findElement(By.id("gettingStartedShortcutsMenuCloseId")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=4,dataProvider="createcustomer")
	private static void createcustomer(String cfn)
	{
		try
		{
			wb.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr/td[3]/a/div[1]")).click();
			Thread.sleep(2000);
			wb.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[1]/div[2]/div")).click();
			Thread.sleep(2000);
			wb.findElement(By.xpath("/html/body/div[14]/div[1]")).click();
			Thread.sleep(3000);
			wb.findElement(By.id("customerLightBox_nameField")).sendKeys(cfn);
			Thread.sleep(2000);
			wb.findElement(By.xpath("//*[@id=\'customerLightBox_commitBtn\']/div/span")).click();
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@DataProvider(name="createcustomer")
	public Object[][] getcustomerdetail()
	{
		return new Object[][] {{"kiran"}};
	}
	
	@Test(priority=5,dataProvider="Modifycustomer")
	private static void modifycustomer(String mfdcustomer)
	{
		try
		{
			wb.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[4]")).click();
			Thread.sleep(2000);
			wb.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[2]/div[2]/div[1]/div[3]/div[2]/div/div[1]/textarea")).sendKeys(mfdcustomer);
			wb.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[2]/div[1]/div[1]")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@DataProvider(name="Modifycustomer")
	public Object[][] getmodifycutomer()
	{
		return new Object[][] {{"Prasahnth s/o raju s"}};
	}

	
	@Test(priority=6)
	private static void deletecustomer()
	{
		try
		{
			wb.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[4]")).click();
			Thread.sleep(2000);
			wb.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[2]/div[1]/div[4]/div/div")).click();
			Thread.sleep(2000);
			wb.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[2]/div[4]/div/div[3]/div")).click();
			Thread.sleep(2000);
			wb.findElement(By.id("customerPanel_deleteConfirm_submitTitle")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=7)
	private static void logout()
	{
		try
		{
			wb.findElement(By.xpath("//*[@id=\"logoutLink\"]")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=7)
	private static void closeapp()
	{
		try
		{
			wb.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}


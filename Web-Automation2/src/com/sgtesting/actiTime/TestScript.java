package com.sgtesting.actiTime;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestScript {
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
	@Test(priority=4,dataProvider="createuser")
	private static void createuser(String firstName,String lastName,String email,String username,String password,String passwordCopy)
	{
		try
		{
			wb.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[5]/a/div[1]")).click();
			Thread.sleep(2000);
			wb.findElement(By.xpath("//*[@id=\'createUserDiv\']/div/div[2]")).click();
			Thread.sleep(2000);
			wb.findElement(By.name("firstName")).sendKeys(firstName);
			wb.findElement(By.name("lastName")).sendKeys(lastName);
			wb.findElement(By.name("email")).sendKeys(email);
			wb.findElement(By.name("username")).sendKeys(username);
			wb.findElement(By.name("password")).sendKeys(password);
			wb.findElement(By.name("passwordCopy")).sendKeys(passwordCopy);
			wb.findElement(By.xpath("//*[@id=\'userDataLightBox_commitBtn\']/div/span")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@DataProvider(name="createuser")
	public Object[][] getcreateuserdetails()
	{
		return new Object[][] {{"prashanth","r","prashan@gmail.com","prashanth r","password","password"}};
	}
	@Test(priority=5)
	private static void modifyuser()
	{
		try
		{
			wb.findElement(By.xpath("//span[text()='demo, user']")).click();
			Thread.sleep(2000);
			wb.findElement(By.name("firstName")).sendKeys("12");
		     wb.findElement(By.xpath("//*[@id=\'userDataLightBox_commitBtn\']/div/span")).click();
		     Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=6)
	private static void deleteuser()
	{
		try
		{
			wb.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]")).click();
			Thread.sleep(2000);
			wb.findElement(By.xpath("//*[@id=\'userDataLightBox_deleteBtn\']")).click();
			 Thread.sleep(3000);
			Alert olaert=wb.switchTo().alert();
			olaert.accept();
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
			wb.findElement(By.xpath("//*[@id=\\\\'logoutLink\\\\']")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=8)
	private static void closeApplication()
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



package com.sgtesting.actiTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Scenario77 {
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
	return new Object[][] {{"kalavathi"}};
}

@Test(priority=5,dataProvider="CreateProject")
private static void createproject(String cproj)
{
	try
	{
		wb.findElement(By.xpath("//div[text()='Add New']")).click();
		Thread.sleep(3000);
		wb.findElement(By.xpath("/html/body/div[14]/div[2]")).click();
		Thread.sleep(3000);
		wb.findElement(By.id("projectPopup_projectNameField")).sendKeys(cproj);
		Thread.sleep(1500);
		wb.findElement(By.xpath("//*[@id=\'projectPopup_commitBtn\']/div")).click();
		Thread.sleep(3000);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
@DataProvider(name="CreateProject")
public Object[][] getprojectdetail()
{
	return new Object[][] {{"bahdra Project"}};
}
@Test(priority=6,dataProvider="createtask")
private static void createtask(String crtask)
{
	try
	{
		wb.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr/td[3]/a/div[1]")).click();
		Thread.sleep(2000);
		wb.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[1]/div[1]/div[3]/div")).click();
		Thread.sleep(2000);
		wb.findElement(By.xpath("/html/body/div[13]/div[1]")).click();
		Thread.sleep(2000);
		wb.findElement(By.xpath("//*[@id=\'createTasksPopup_createTasksTableContainer\']/table/tbody/tr[1]/td[1]/input")).sendKeys(crtask);
		wb.findElement(By.xpath("//*[@id=\"createTasksPopup_commitBtn\"]")).click();
		Thread.sleep(2000);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
@DataProvider(name="createtask")
public Object[][] getcreatetaskdetail()
{
	return new Object[][] {{"1"}};
}
@Test(priority=7)
private static void deletetask()
{
	try
	{
		wb.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[1]/div[2]/div[1]/table[1]/tbody/tr/td[2]")).click();
		Thread.sleep(2000);
		wb.findElement(By.xpath("//*[@id=\"taskListBlock\"]/div[3]/div[1]/div[2]/div[3]/div/div/div[2]")).click();
		Thread.sleep(2000);
		wb.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[3]/div[4]/div/div[3]/div")).click();
		Thread.sleep(2000);
		wb.findElement(By.xpath("//*[@id=\'taskPanel_deleteConfirm_submitBtn\']/div")).click();
		Thread.sleep(2000);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
@Test(priority=8)
private static void DeleteProject()
{
	try
	{
		wb.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[3]/div[3]")).click();
		Thread.sleep(3000);
		wb.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[4]/div[1]/div[2]/div[3]/div/div/div[2]")).click();
		Thread.sleep(3000);
		wb.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[4]/div[4]/div/div[3]/div")).click();
		Thread.sleep(3000);
		wb.findElement(By.xpath("//*[@id=\'projectPanel_deleteConfirm_submitBtn\']/div")).click();
		Thread.sleep(3000);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
@Test(priority=8)
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
@Test(priority=9)
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
@Test(priority=10)
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


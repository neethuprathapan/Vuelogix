package testpackage;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import basepackage.baseclass;
import pagepackage.pageclass;
import excelutilities.excelutils;

public class testclass extends baseclass
{
	@Test(priority = 1, enabled=false)
	public void titleverification()
	{
	String exp="Account";
	String actual=driver.getTitle();
	System.out.println(actual);
	
	if(actual.equalsIgnoreCase(exp))
	{
		System.out.println("Title verification is successful");
	}
	else
	{
		System.out.println("Title verification is failed");
	}
	}
	
	
	@Test(priority = 2, enabled = false)
	public void logoverification()
	{
		WebElement we=driver.findElement(By.xpath("//*[@id=\"SiteHeader\"]/div[1]/div/div[1]/div/a[1]/img[1]"));
		boolean logo=we.isDisplayed();
		if(logo)
		{
			System.out.println("logo displayed");
		}
		else
		{
			System.out.println("logo not displayed");
		}
	}
	
	
	@Test(priority = 3, enabled= false)
	public void linkcount()
	{
		List<WebElement> li=driver.findElements(By.tagName("a"));
		System.out.println("Total no of links :"+li.size());
		for(WebElement ele:li)
		{
		String link=ele.getAttribute("href");
		String linktext=ele.getText();
		System.out.println(link+"..."+linktext);
		
		
		}		
	}
	
	@Test(priority = 4, enabled=false)
	public void buttontext()
	{
	WebElement button=driver.findElement(By.xpath("//*[@id=\"customer_login\"]/p[1]/button"));
	String actual=button.getText();
	System.out.println("Button text is present :"+actual);

	}
	
	@Test(priority = 5, enabled = false)
	public void screenshot() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,new File("C:\\Users\\neethu321\\OneDrive\\Desktop\\selenium\\sign.png"));
		
		WebElement button=driver.findElement(By.xpath("//*[@id=\"customer_login\"]/p[1]/button"));
		File buttonscreenshot=button.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(buttonscreenshot,new File("./screenshot/buttonscreenshotsignin.png"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test(priority = 5, enabled= true)
	public void datadriven() throws Exception
	{
		pageclass ob = new pageclass(driver);
		String xl="C:\\Users\\neethu321\\OneDrive\\Desktop\\turtle.xlsx";
		String sheet="Sheet1";
		int rowCount = excelutils.getRowCount(xl, sheet);
		System.out.println(rowCount);
       for (int i=1;i<rowCount;i++)
        {
              String UserName=excelutils.getCellValue(xl, sheet, i, 0);
              System.out.println("username---"+UserName);
              String Pwd=excelutils.getCellValue(xl, sheet, i, 1);
              System.out.println("password---"+Pwd);
              
              
              ob.setvalues(UserName, Pwd);
              ob.signin();
      
        }
              ob.logout();
              Thread.sleep(1000);
              ob.login();
              ob.forgotpassword();
              ob.cancel();
       

	} 
}

package basepackage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class baseclass 
{
	public static ChromeDriver driver;
	
	@BeforeTest
	public void setup()
	{
	driver=new ChromeDriver();
	driver.get("https://turtle.in/account/login?return_url=%2Faccount");
	driver.manage().window().maximize();
	}
	

}

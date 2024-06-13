package pagepackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageclass 
{
  ChromeDriver driver;
  
  @FindBy(name="customer[email]")
  WebElement email;
  
  @FindBy(id="CustomerPassword")
  WebElement password;
  
  @FindBy(xpath="//*[@id=\"customer_login\"]/p[1]/button")
  WebElement signin;
  
  @FindBy(xpath="//*[@id=\"MainContent\"]/div[3]/div/div[1]/div[2]/span[6]/span[2]")
  WebElement logout;
  
  @FindBy(xpath="//*[@id=\"SiteHeader\"]/div[1]/div/div[3]/div/div/a[1]")
  WebElement login;
  
  @FindBy(xpath="//*[@id=\"RecoverPassword\"]")
  WebElement forgotpassword;
  
  @FindBy(xpath="//*[@id=\"HideRecoverPasswordLink\"]")
  WebElement cancel;
  
  public pageclass(ChromeDriver driver)
  {
	  this.driver=driver;
	  PageFactory.initElements(driver , this);
	  
  }
  
  public void setvalues(String emailid, String pswd)
  {
	email.sendKeys(emailid); 
	password.sendKeys(pswd);
  }
  
  public void signin()
  {
	  signin.click();
  }
  
  public void logout()
  {
	  logout.click();
  }
  
  public void login()
  {
	  login.click();
  }
  
  public void forgotpassword()
  {
	  forgotpassword.click();
  }
  
  public void cancel()
  {
	  cancel.click();
  }


}

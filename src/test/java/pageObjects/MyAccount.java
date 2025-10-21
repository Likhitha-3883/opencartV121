package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {
	
	public MyAccount(WebDriver driver)
	{
		super(driver);
	}
	
	//WebElements
	

	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement MyAccounttext;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement Logout;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Login']")
	WebElement Login;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement Continuebtn;
	
	  @FindBy(xpath="//span[normalize-space()='My Account']")
      WebElement Myaccount2;
      
	  @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
      WebElement login2;
	
      @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
      WebElement logout2;
	
	//Actions
	
	public boolean Myaccounttxt()
	{
	boolean Myaccounttxt =	MyAccounttext.isDisplayed();
	return(Myaccounttxt);
	
	}
	
	public void Logoutbtn()
	{
		Logout.click();
	}
	
	public void Loginbtn()
	{
		Login.click();
	}
	
	public void Continue()
	{
		Continuebtn.click();
		
	}
	
	  public void myaccount2()
      {
    	  Myaccount2.click(); 
      }
      
      public void log()
      {
    	  login2.click();
    	  
      }
      
      public void logout22()
      {
    	  logout2.click();
      }
	
	
}

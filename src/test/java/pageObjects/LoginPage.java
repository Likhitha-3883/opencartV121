package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	//Constructor
	public LoginPage(WebDriver driver)
	{
		super(driver);
	
}
	
	//WebElements
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailtxt;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement passwordtxt;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbtn;
	
	//Actions
	
	public void emailtxt(String email)
	{
		emailtxt.sendKeys(email);
	}
	
	public void pwdtxt(String pwd)
	{
		passwordtxt.sendKeys(pwd);
	}
	
	public void loginbutton()
	{
		loginbtn.click();
	}
	

}

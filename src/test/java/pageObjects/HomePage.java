package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	
	
	//constructor
     public HomePage(WebDriver driver)
			{
	         super(driver);
			}
      
      //webElements
      
      @FindBy(xpath="//a[@title='My Account']")
      WebElement actions;
      
      @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
      WebElement Registerbtn;
      
      @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
      WebElement Loginbutton;
      
      
    
      
      //Actions
      public void myacntclick()
      {
    	  actions.click();
      }
      
      public void registerclick()
      {
    	  Registerbtn.click();
      }
      
      public void loginbttn()
      {
    	  Loginbutton.click();
      }
      
    

}

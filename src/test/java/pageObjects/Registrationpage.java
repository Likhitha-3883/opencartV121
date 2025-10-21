

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registrationpage extends BasePage{
	
	public Registrationpage(WebDriver driver)
	{
		super(driver);
	}
	
//webelements
@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtfirstname;
//@FindBy(xpath="//input[@id='input-username']")
//WebElement username;
@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtlastname;
@FindBy(xpath="//input[@id='input-email']")
WebElement txtEmail;
@FindBy(xpath="//select[@id='input-country']")
WebElement txtcountry;
@FindBy(xpath="//input[@id='input-password']")  
WebElement txtpassword;
@FindBy(xpath="//input[@id='input-confirm']")
WebElement txtconfirmpwd;
@FindBy(xpath="//li[2]//a[1]//img[1]")
WebElement icon;
@FindBy(xpath="//input[@id='input-telephone']")
WebElement txttelephone;
@FindBy(xpath="//input[@name='agree']")
WebElement btnagreebtn;
@FindBy(xpath="//input[@value='Continue']")
WebElement btncontbtn;

@FindBy(xpath="//label[normalize-space()='Yes']")
WebElement rdbtnsubs;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement confmsg;


//Actions

public void fname(String fn)
{
	txtfirstname.sendKeys(fn);
}

public void lname(String ln)
{
	txtlastname.sendKeys(ln);
}

public void email(String emailtxt)
{
	txtEmail.sendKeys(emailtxt);
}
public void tel(String phone)
{
	txttelephone.sendKeys(phone);
}
public void pswd(String pwd)
{
	txtpassword.sendKeys(pwd);
}
 public void confpassword(String confpwd)
 {
 txtconfirmpwd.sendKeys(confpwd);
 }
public void checkboxagree()
{
	btnagreebtn.click();
}

public void contbutton()
{
	btncontbtn.click();
}

public void subscribe()
{
rdbtnsubs.click();
}

public String confirmationmsg()
{
	try {
		return(confmsg.getText());
	}
	
catch(Exception e)
{
	return(e.getMessage());
}
	
}
}

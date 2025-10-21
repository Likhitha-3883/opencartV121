package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups= {"sanity","master"})
	public void Verify_TC002_login()
	{
		logger.info("****Validation started***");
		//creating object for Homepage
		
		try {
		HomePage hp = new HomePage(driver);
		{
	logger.info("***Clicking on My Account****");
	hp.myacntclick();
	logger.info("***Clicking on Login link");
	hp.loginbttn();
		}
	
	//creating object for login
	
		LoginPage lp= new LoginPage(driver);
		lp.emailtxt(p.getProperty("email"));
		lp.pwdtxt(p.getProperty("password"));
		lp.loginbutton();
		
		logger.info("***verify***");
		
		MyAccount MA = new MyAccount(driver);
				{
		 boolean MyAcntverify= MA.Myaccounttxt();
			{
				
				Assert.assertEquals(MyAcntverify, true);
				logger.info("***Passed***");
			}
				}
		}
				catch(Exception e)
				{
					Assert.fail();
					logger.info("***failed***");
				}
	}
}
		



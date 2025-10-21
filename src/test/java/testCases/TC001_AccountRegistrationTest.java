package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Registrationpage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups= {"sanity","regression"})
	public void verify_account_registration() throws InterruptedException
	{
		logger.info("*****Starting account_registration" );
	try {	
		
	HomePage hp = new HomePage(driver);
			{
		logger.info("***Clicking on My Account****");
		hp.myacntclick();
		logger.info("***Clicking on Register link");
		hp.registerclick();
			
			}
			
			logger.info("***providing user details***");
			
			Registrationpage rp= new Registrationpage(driver);
			rp.fname(generatedAlpha());
			rp.lname(generatedAlpha());
			rp.email(generatedAlpha()+"@gmail.com");
			rp.tel(generatednumber());
			String password = generatedalpnum();
			rp.pswd(password);
			rp.confpassword(password);
			rp.checkboxagree();
			
			rp.subscribe();
			rp.contbutton();
			String confmsg = rp.confirmationmsg();
			//Assert.assertEquals(confmsg,"Your Account Has Been Created!");
			logger.info("***Validating expected message***");
			if(confmsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			
			else

				{
				  logger.error("***Validation failed***");	
				  logger.debug("***debg logs***");
				  Assert.fail();
				}
	}
			catch(Exception e)
			{
				Assert.fail();
			}
	Thread.sleep(3000);
				
	logger.info("***Validation is completed***");
	
	
	
			}
	}	
			
		


package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.Dataproviders;

public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass= Dataproviders.class, groups= {"sanity", "regression","master", "datadriven"})
	public void Verify_TC003_loginDDT(String email, String pwd, String exp) throws InterruptedException
	{
		logger.info("****DDT Validation started***");
		//creating object for Homepage
		
		try {
			//Homepage
		
			HomePage hp = new HomePage(driver);
		
	hp.myacntclick();
	hp.loginbttn();
		
	//creating object for login
	
		LoginPage lp= new LoginPage(driver);
		lp.emailtxt(email);
		lp.pwdtxt(pwd);
		lp.loginbutton();
		
		
		logger.info("***main validation started***");
		
		//Myaccount obj
		
		MyAccount Ma= new MyAccount(driver);
			
		    Thread.sleep(3000);
			boolean targetpage =Ma.Myaccounttxt();
				
		//valid creds - login pass and valid creds- login fail
				
		if(exp.equalsIgnoreCase("Valid"))
		{
			
				if(targetpage==true) {
					
					logger.info("failing");
					Ma.myaccount2();
					Ma.logout22();
					Ma.Continue();
					Ma.myaccount2();
					Ma.log();
					Assert.assertTrue(true);
			}
			
				else
		{
			Assert.assertTrue(false);
		}
		}


			//Invalid creds- login pass and invalid creds -login fail
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetpage==true)
			{
				
				System.out.println("True");			
				
				Thread.sleep(3000);
				Ma.myaccount2();
				Ma.logout22();
				Ma.Continue();
				Ma.myaccount2();
				Ma.log();
				
				Assert.assertTrue(false);
			}
			else
			{
				System.out.println("True");
				Assert.assertTrue(true);
				
			}
		}
		
		}
		
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		Thread.sleep(2000);
		logger.info("***Finished Testing***");
	}
}




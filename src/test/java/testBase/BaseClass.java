package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	
	
  public static WebDriver driver;
  public Logger logger;//log4j
  public Properties p;
  
  
	@SuppressWarnings("deprecation")
	@Parameters({"os","browser"})
	@BeforeClass(groups= {"sanity", "regression","master", "datadriven"})
	public void setup(String os, String br) throws IOException
	{
		
		p=new Properties();
		FileInputStream fi = new FileInputStream("./src/test/resources/config.properties");
		p.load(fi); 
		
		logger= LogManager.getLogger(this.getClass());
		// driver= new ChromeDriver(); 
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
	DesiredCapabilities capabilities= new DesiredCapabilities();
	//os
	if(os.equalsIgnoreCase("windows"))
	{
		capabilities.setPlatform(Platform.WIN11);
	}
	else if(os.equalsIgnoreCase("mac"))
	{
		capabilities.setPlatform(Platform.MAC);
	}
	else
	{
		System.out.println("No matching os");
		return;
	}
	
		

//browser
switch(br.toLowerCase())
{
case "chrome": capabilities.setBrowserName("chrome");break;
case "edge": capabilities.setBrowserName("MicrosoftEdge");break;
case "firefox" : capabilities.setBrowserName("firefox");break;
default: System.out.println("Invalid browser");return;
}

driver= new RemoteWebDriver(new URL("http://192.168.29.143:4444/wd/hub"),capabilities);


		}

		
	
if(p.getProperty("execution_env").equalsIgnoreCase("local"))
{

		
		   switch(br.toLowerCase())
		     {
		     case "chrome" : driver= new ChromeDriver(); break; 
		     case "edge" : driver= new EdgeDriver(); break;
		     case "firefox" : driver=new FirefoxDriver(); break;
		     default: System.out.println("Invalid browser");return;
		     }
		
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get(p.getProperty("appURL"));
		 driver.manage().window().maximize();
		
}
	}
	
	
	@AfterClass(groups= {"sanity", "regression","master", "datadriven"})
	public void teardown()
	{
		driver.quit();
	}
	
	//random string-Alphabetic
	public String generatedAlpha()
	{
		String Randomalpha = RandomStringUtils.randomAlphabetic(6);
		return Randomalpha; 
	}
	
	//random numeric
	public String generatednumber()
	{
		String randomnum = RandomStringUtils.randomNumeric(10);
		return randomnum;
	}
	
	//randomalphanumeric
	
	public String generatedalphanumeric()
	{
		String randomalphanumeric= RandomStringUtils.randomAlphanumeric(10);
		return randomalphanumeric;
	}
	
	//random alphau+numeric
	public String generatedalpnum()
	{

		String randomalpha = RandomStringUtils.randomAlphabetic(6);
		String randomnum = RandomStringUtils.randomNumeric(10);
		return(randomalpha+"@"+randomnum);

	}
	
	public static String captureScreen(String tname) {
	    String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	    String screenshotPath = System.getProperty("user.dir")
	            + File.separator + "screenshots"
	            + File.separator + tname + "_" + timeStamp + ".png";

	    try {
	        TakesScreenshot ts = (TakesScreenshot) driver;

	        // ✅ Use BASE64 (works with RemoteWebDriver)
	        String base64Screenshot = ts.getScreenshotAs(OutputType.BASE64);

	        byte[] decodedBytes = java.util.Base64.getDecoder().decode(base64Screenshot);
	        File targetFile = new File(screenshotPath);
	        java.nio.file.Files.write(targetFile.toPath(), decodedBytes);

	        System.out.println("✅ Screenshot saved: " + screenshotPath);
	        return screenshotPath;
	    } catch (Exception e) {
	        System.out.println("❌ Failed to capture screenshot: " + e.getMessage());
	        return null;
	    }
	}

}
	

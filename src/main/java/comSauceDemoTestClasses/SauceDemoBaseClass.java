package comSauceDemoTestClasses;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import comSauceDemoPomClasses.HomepageLogout;
import comSauceDemoPomClasses.LoginPage;


public class SauceDemoBaseClass
{
    public  WebDriver driver;
      Logger log;
      
       @BeforeClass
       
       public void BrowserOpen()
      {
    	Logger log= Logger.getLogger("SauceDemotejasV5");
    	 PropertyConfigurator.configure("Log4j.Properties");  
  	   
    
        System.setProperty("webdriver.chrome.driver",
  			".//drivers//chromedriver.exe");
  	
        driver= new ChromeDriver();
       log.info("open browser");

       driver.manage().window().maximize(); 
     }
    
           
      
        @BeforeMethod
      
     public void SetUpMethod() 
  {  
        Logger log= Logger.getLogger("SauceDemotejasV5");
       	PropertyConfigurator.configure("Log4j.Properties");  
       	   
       
        	
        	
        	
	 driver.get("https://www.saucedemo.com/");
	 log.info("open sauce demo url");

      driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

     LoginPage l= new LoginPage( driver);
     
     l.senduserName();
     log.info("Send Username");
     
     l.sendpassword();
     log.info("send Password");
     
     l.login();
     log.info("login succesfull");
	
     }
	
    @AfterMethod
	public void tearDownMethod() throws InterruptedException
	{
		 // logout functinality
		   HomepageLogout hc= new  HomepageLogout(driver);
		   hc.dotclick();
		   Thread.sleep(4000);
		   hc.logout();
		   Thread.sleep(4000);
	}
	
	@AfterClass
   public void quit()
   {
		driver.quit();
   }

}

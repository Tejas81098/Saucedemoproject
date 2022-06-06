package comSauceDemoTestClasses;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import comSauceDemoPomClasses.HomepageLogout;
import comSauceDemoPomClasses.LoginPage;

public class TC002LogoutFunctinality extends SauceDemoBaseClass
{
     @Test(priority=2)
     
     public void homepagelogout() throws InterruptedException
     {
	
		   // logout functinality
		   HomepageLogout hc= new  HomepageLogout(driver);
		   hc.dotclick();
		   Thread.sleep(4000);
		   hc.logout();
		   Thread.sleep(4000);
	      
		   
		     String expectedtitle="Swag Labs";
		     String actualtitle=driver.getTitle();
		     
		     String title = driver.getTitle();
		 //   log.info(title);
		     
		     Assert.assertEquals(actualtitle,expectedtitle);
		    
		}
}



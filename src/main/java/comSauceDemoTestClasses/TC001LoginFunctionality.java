package comSauceDemoTestClasses;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(UtilitypomClases.Listeners.class)
public class TC001LoginFunctionality extends SauceDemoBaseClass
{
     @Test(priority=1)
     
     public void Verifylogin()

     {
	     String expectedUrl="h://www.saucedemo.com/inventory.html";
	     String actualUrl= driver.getCurrentUrl();
	    
	     System.out.println(actualUrl);
	     
	     // Applying Assertion 
	     
	    Assert.assertEquals(actualUrl,expectedUrl);
		
	}
}



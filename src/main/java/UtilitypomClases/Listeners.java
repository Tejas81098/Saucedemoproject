package UtilitypomClases;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import comSauceDemoTestClasses.TC001LoginFunctionality;


public class Listeners implements ITestListener
{
	
		WebDriver driver;
		
		public void onTestStart( ITestResult result)
		{
			System.out.println("Execution is started");
		}
		
		public void onTestSuccess(ITestResult result)
		{
			System.out.println("TestCase is successfully passed");
		}
		
		
		public void onTestFailure(ITestResult result)
		{
			System.out.println("TestCase is failed and hence taking screenshot");
			
		   	    this.driver=((TC001LoginFunctionality)result.getInstance()).driver;
		   	    
		   		   TakesScreenshot t = (TakesScreenshot)driver;
		   		   
		   		   File SourceFile=t.getScreenshotAs(OutputType.FILE);
		   		   File destFile= new File("./screenshot//Tejas.jpg");
				
		   		   try 
		   		   {
					FileHandler.copy(SourceFile, destFile);
				    } 
		   		   catch (IOException e) 
		   		   {
					  System.out.println("take Sc");
				   }
		}
        
		public void onTestSkipped(ITestResult result)
		{
			System.out.println("TestCase is failed and hence taking screenshot");	
	    }
		
		public void onstart(ITestResult result)
		{
			System.out.println("TestCase Methd is Start");	
	    }
		public void onFail(ITestResult result)
		{
			System.out.println("TestCase is finished");	
	    }


}

package homesPackage;

import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.nativekey.AndroidKey;

public class Basics extends Base {



	@Test
	public void testMethod() throws MalformedURLException
	{

		// creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Test One", "Sample Test Case for Demo");

        test1.log(Status.INFO, "Test One Started");
        
		getdriver().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		if(getdriver().findElementsById("ent.homes.hdc:id/btnSkip").size()>0)
		{
			getdriver().findElementById("ent.homes.hdc:id/btnSkip").click();
			test1.log(Status.PASS, "Tap on Skip CTA");
		}
		else
		{
			getdriver().findElement(By.id("ent.homes.hdc:id/fabSearch")).click();
			test1.log(Status.PASS, "Tap on Search icon to search the properties");
		}
		
		
		
		WebDriverWait wait = new WebDriverWait(getdriver(), 30);
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("ent.homes.hdc:id/fabSearch")));
		
		//getdriver().findElement(By.id("ent.homes.hdc:id/fabSearch")).click();
		
		
		
		getdriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		getdriver().findElementById("ent.homes.hdc:id/search").click();
		test1.log(Status.PASS, "Tap on Search location field");
		
		getdriver().hideKeyboard();
		Actions a = new Actions(driver);
		a.sendKeys("23451").build().perform();
		//a.perform();
		//getdriver().findElementById("ent.homes.hdc:id/search").sendKeys("23451");
		
		
		//test1.log(Status.PASS, "Enter 'ZipCode - 23451' at Searchlocation field");
		
		getdriver().hideKeyboard();
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//android.widget.TextView[@text='23451']")));
		try {
			getdriver().findElementByXPath("//android.widget.TextView[@text='23451']").click();
			test1.log(Status.PASS, "Tap on enter zipcode option from the dropdown list");
		}
		catch(Exception E)
		{
			test1.log(Status.FAIL, "Tap on enter zipcode option from the dropdown list");
		}
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("ent.homes.hdc:id/location_title")));
		
		test1.log(Status.INFO, "Test One Completed.");
	}
}

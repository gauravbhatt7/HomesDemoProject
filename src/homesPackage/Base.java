package homesPackage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base extends ReportDemo {

	public static AndroidDriver<AndroidElement> driver;
	
	@BeforeMethod
	public static AndroidDriver<AndroidElement> DeviceCapabilities() throws MalformedURLException {



		DesiredCapabilities cap=new DesiredCapabilities();
		//		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "GauravEmulator");
		//		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		//		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 5 pro");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");

		cap.setCapability(MobileCapabilityType.UDID, "4b84dcc8"); //Give Device ID of your mobile phone

		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
		cap.setCapability("appPackage", "ent.homes.hdc");
		cap.setCapability("appActivity", "com.homes.homesdotcom.features.home.HomeActivity");
		cap.setCapability(MobileCapabilityType.NO_RESET, "true");
		cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true");
		cap.setCapability(AndroidMobileCapabilityType.NO_SIGN, "true");

		
		 driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);

		return driver;
	}

	//@BeforeMethod
	public static AndroidDriver<AndroidElement> EmulatorCapabilities() throws MalformedURLException {

		File f=new File("src");
		File fs=new File(f,"Homes.apk");

		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "GauravEmulator");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());



		 driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);

		return driver;
	}

	public AndroidDriver<AndroidElement> getdriver()
	{
		return driver;
	}
	
	/*public void TypeInField(String Id, String value){
	    String val = value; 
	    getdriver().findElement(By.id(Id));
	    getdriver().findElementById(Id).clear();

	    String s="";
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < val.length(); i++){
	        char c = val.charAt(i);
	        
	         s=sb.append(c).toString();
	        getdriver().findElementById(Id).sendKeys(s);
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }       
	}*/
	
	@AfterMethod
	public void afterMethod()
	{
		getdriver().quit();
	}
}

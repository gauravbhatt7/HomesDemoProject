package homesPackage;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportDemo {

	ExtentSparkReporter htmlReporter;
	ExtentReports extent;

	@BeforeSuite
	public void reportSetup()
	{
		htmlReporter = new ExtentSparkReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@AfterSuite
	public void reportTeardown()
	{
		// calling flush writes everything to the log file
		extent.flush();
	}
}

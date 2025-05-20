package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentReportManager;
import utils.Log;

public class BaseTest {
  protected WebDriver driver;
  protected static ExtentReports extent;
  protected ExtentTest test;
  
  @BeforeSuite  
  public void SetupReport() {
	  extent = ExtentReportManager.getReportsInstance();
  }
  @AfterSuite
  public void TeardownReport() {
	 extent.flush();
  }
  
 @BeforeMethod
  public void SetUp() {
	 Log.info("Settingup the WedDriver...");
	 WebDriverManager.chromedriver().setup(); // Automatically handles driver setup
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     Log.info("Navigating to URL...");
     driver.get("https://admin-demo.nopcommerce.com/login");
  }
 
 @AfterMethod
 public void tearDown(ITestResult result) {
	 if(result.getStatus()== ITestResult.FAILURE) {
		 String screenshotPath = ExtentReportManager.captureScreenShot(driver, "LoginFailure");
		 test.fail("test failed check screenshot", 
				 MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	 }
	 
	 Log.info("closing browser...");
	 if( driver!=null) {
		 driver.quit();
	 }
 }
}

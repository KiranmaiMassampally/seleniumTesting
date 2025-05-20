 package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;
@Test
public class LoginTest extends BaseTest{
		//only test scripts here

public void TestValidLogin() {
		
		Log.info("Starting logging test...");
		test = ExtentReportManager.createTest("LoginTests");
		LoginPage loginPage = new LoginPage(driver);
		test.info("Navigating to the page");
		
		
		Log.info("Adding the credentialss...");
		test.info("adding credentials");
		
		loginPage.enterUserName("admin@yourstore.com");
		loginPage.enterPassword("admin");
		test.info("Clicking on login Button");
		loginPage.clickLogin();
		
		System.out.println("title of page:"+driver.getTitle());
		Log.info("Verifying title...");
		test.info("Verifying page title");
		Assert.assertEquals(driver.getTitle(),"Just a moment...");
		test.info("Login successfull");
		
	}
@Test
public void TestLoginWithWrongDetails() {
	
	Log.info("Starting logging test...");
	test = ExtentReportManager.createTest("LoginTests with invalid Creds");
	LoginPage loginPage = new LoginPage(driver);
	test.info("Navigating to the page");
	
	
	Log.info("Adding the credentialss...");
	test.info("adding credentials");
	
	loginPage.enterUserName("test@yourstore.com");
	loginPage.enterPassword("test");
	test.info("Clicking on login Button");
	loginPage.clickLogin();
	
	System.out.println("title of page:"+driver.getTitle());
	Log.info("Verifying title...");
	test.info("Verifying page title");
	Assert.assertEquals(driver.getTitle(),"Just a moment...");
	test.info("Login successfull");
	
}

}
 
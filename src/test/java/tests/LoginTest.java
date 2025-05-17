 package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
@Test
public class LoginTest extends BaseTest{
		//only test scripts here
	public void TestValidLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("admin@yourstore.com");
		loginPage.enterPassword("admin");
		loginPage.clickLogin();
		System.out.println("title of page:"+driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"Just a moment...");
	}

}

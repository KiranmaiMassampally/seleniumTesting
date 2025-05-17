package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	//By is a class frm slelenium lib
	private By usernameTextBox = By.id("Email");
	private By passwordTextBox = By.id("Password");
	private By loginButton = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button");
	
	public LoginPage(WebDriver driver){
		this.driver= driver;
	}
    public void enterUserName(String username) {
    	driver.findElement(usernameTextBox).clear();
    	driver.findElement(usernameTextBox).sendKeys("admin@yourstore.com");;
    }
    public void enterPassword(String password) {
    	driver.findElement(passwordTextBox).clear();
    	driver.findElement(passwordTextBox).sendKeys("admin");
    }
    public void clickLogin() {
    	driver.findElement(loginButton).click();
    }
}

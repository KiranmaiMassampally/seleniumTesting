package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Log;

public class LoginPage {
	
	private WebDriver driver;
	@FindBy(id="Email")
	WebElement usernameTextbox;
	@FindBy(id="Password")
	WebElement passwordTextbox;
	@FindBy(xpath = ("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button"))
	WebElement loginButton;
	
//	//By is a class frm slelenium lib
//	private By usernameTextBox = By.id("Email");
//	private By passwordTextBox = By.id("Password");
//	private By loginButton = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button");
	
	public LoginPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
    public void enterUserName(String username) {
    	usernameTextbox.clear();
    	usernameTextbox.sendKeys(username);
    	
//     	driver.findElement(usernameTextbox).clear();
//    	driver.findElement(usernameTextbox).sendKeys("admin@yourstore.com");;
    }
    public void enterPassword(String password) {
    	
    	passwordTextbox.clear();
    	passwordTextbox.sendKeys(password);
    	
//    	driver.findElement(passowrdTextBox).clear();
//    	driver.findElement(passowrdTextBox).sendKeys("admin");
    }
    public void clickLogin() {
    	Log.info("user Logged in.. ");
    	//driver.findElement(loginButton).click();
    	loginButton.click();
    }
}

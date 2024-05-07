package AutomationFramework.hrms;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super();
		//this.driver=driver;
		//PageFactory.initElements(driver, this);
	}
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	
	//Email Text Box
	@FindBy(xpath = "//input[@name='email']")
	static WebElement enterEmail;
	
	//Password field
	@FindBy(xpath = "//input[@name='password']")
	WebElement enterPassword;
	
	//Login button
	@FindBy(xpath = "//button[@type='submit']")
	WebElement clickLogin;
	
	//Logout Menu
	@FindBy(xpath = "(//div[@class='placeholder-initial'])[1]")
	WebElement logoutMenu;
	
	//Logout button on Menu
	@FindBy(xpath = "(//div[text()='Logout'])")
	WebElement logoutbuttonMenu;
	
	//Logout button on popup
	@FindBy(xpath = "(//button[text()='Log Out'])")
	WebElement logOutbutton;
	
	public void enterEmailId(String email) {
		enterEmail.sendKeys(email);
	}
	public void enterPassword(String password) {
		enterPassword.sendKeys(password);
	}
	public void clickLoginButton() {
		clickLogin.click();
	}
	
	public void clickLogoutMenuDashboard() {
		logoutMenu.click();
	}
	
	public void clickLogoutButtonMenu() {
		logoutbuttonMenu.click();
	}
	
	public void clickLogoutButtononPopup() {
		logOutbutton.click();
	}
	
	//login actions
	public void Login(String email, String password) {
		enterEmailId(email);
		enterPassword(password);
		clickLoginButton();
		
	}
	
	//Logout actions
	public void LogOut() {
		wait.until(ExpectedConditions.elementToBeClickable(logoutMenu));
		clickLogoutMenuDashboard();
		clickLogoutButtonMenu();
		//wait.until(ExpectedConditions.elementToBeClickable(logoutMenu));
		clickLogoutButtononPopup();
		
	}
	
	//Incorrect cred error message
	@FindBy(xpath = "//div[@class='tab-content']//form/span")
	public
	static
	WebElement validationError;
	//String loginError =	incorrectCredError.getText();
	public void incorrectCredErrorMsg() {
	wait.until(ExpectedConditions.elementToBeClickable(validationError));	
	String loginError =	validationError.getText();
	}
	
}

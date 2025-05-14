package AutomationFramework.hrms;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import HRMS.resources.BaseClass;


public class LoginPage extends BaseClass {

	private WebDriver driver;
	private WebDriverWait wait;

	public LoginPage(WebDriver driver) {
//		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
//	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	
	//Email Text Box
	@FindBy(xpath = "//input[@placeholder='Email ID / Mobile Number']")
	WebElement enterEmail;
	
	//Password field
	@FindBy(xpath = "//input[@type='password']")
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
	
	public void clickPassword() {
		enterPassword.click();
	}
	public void enterPassword(String password) {
		enterPassword.sendKeys(password);
	}
	
	public void clickNextButton() {
		clickLogin.click();
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
	public void login(String email, String password) {
		enterEmailId(email);
		clickNextButton();
		wait.until(ExpectedConditions.elementToBeClickable(enterPassword));
		clickPassword();
		enterPassword(password);
		clickLoginButton();
		
	}
	
	//Logout actions
	public void logOut() {
		wait.until(ExpectedConditions.elementToBeClickable(logoutMenu));
		clickLogoutMenuDashboard();
		clickLogoutButtonMenu();
		//wait.until(ExpectedConditions.elementToBeClickable(logoutMenu));
		clickLogoutButtononPopup(); 
		
	}
	
	//Incorrect cred error message
	@FindBy(xpath = "//div[@class='dsm-inputbox-error-msg ']")
	public static WebElement validationError;
	public String incorrectCredErrorMsg() {
	wait.until(ExpectedConditions.elementToBeClickable(validationError));	
	return validationError.getText();
	}
	
}

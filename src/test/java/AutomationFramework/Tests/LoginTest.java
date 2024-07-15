package AutomationFramework.Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AutomationFramework.hrms.LoginPage;
import HRMS.resources.BaseClass;
import utils.ScreenshotUtil;


public class LoginTest {

	WebDriver driver;
	LoginPage Loginpage;
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
	
	@BeforeTest
	public void setupBrowser() {
		driver = BaseClass.setDriver("CHROME");
		Loginpage = PageFactory.initElements(driver, LoginPage.class);
		driver.get("https://dev-portal.mewurk.com/login");
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void loginPageObject( ) {
		Loginpage.Login("chetana.r@mewurk.com", "Mewurk@123");
//		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='placeholder-initial'])[1]")));
		Loginpage.LogOut();
	}
	
	@Test(priority = 2)
	public void ErrorValidationLogin() throws InterruptedException {
		Loginpage.Login("chetana.r@mewurk.com", "Mewurk@1");
		Thread.sleep(2000);
		Assert.assertEquals(LoginPage.validationError.getText(),"Incorrect credentials. Please try again.");
		if(LoginPage.validationError.getText()=="Incorrect credentials. Please try again") {
			
		System.out.println("ErrorValidation Test is passed");
	}
		else {
			System.out.println("Error Validation is incorrect");
			ScreenshotUtil.takeScreenshot(driver, "Validation Message didn't match Actual Message");
		}
			
		
	}
//	@Test(priority = 3)
//	public void ErrorforEmailIdnotexist() throws InterruptedException {
//		driver.navigate().refresh();
//		Loginpage.Login("admin@mewurk.com", "Mewurk@123");
//		Thread.sleep(2000);
//		Assert.assertEquals(LoginPage.validationError.getText(), "This email ID doesn't exist. Please contact your admin or try creating a new account through sign up.");
//	}
	
}

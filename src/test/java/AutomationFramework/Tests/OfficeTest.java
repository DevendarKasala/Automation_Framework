package AutomationFramework.Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AutomationFramework.Implementation.OfficeSettings;
import AutomationFramework.hrms.LoginPage;
import AutomationFramework.hrms.OfficePageobject;
import HRMS.resources.BaseClass;

public class OfficeTest {

	WebDriver driver;
	LoginPage Loginpage;
	OfficeSettings officesettings;
	OfficePageobject officepage;
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@BeforeTest
	public void setupBrowser() {
		driver = BaseClass.setDriver("CHROME");
		Loginpage = PageFactory.initElements(driver, LoginPage.class);
		officepage = PageFactory.initElements(driver, OfficePageobject.class );
		officesettings = PageFactory.initElements(driver, OfficeSettings.class);
		driver.get("https://dev-portal.mewurk.com/login");
		driver.manage().window().maximize();
		Loginpage.Login("admin1@mewurk.com", "Mewurk@123");
	}
	
	@Test
	public void AddnewOffice() {
		
		officesettings.CreateOffice();
	}
}

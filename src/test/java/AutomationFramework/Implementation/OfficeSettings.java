package AutomationFramework.Implementation;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import AutomationFramework.hrms.LoginPage;
import AutomationFramework.hrms.OfficePageobject;
import HRMS.resources.BaseClass;


public class OfficeSettings extends BaseClass{

	WebDriver driver;
	LoginPage Loginpage;
	OfficePageobject officepage;
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
	
	
	public void CreateOffice() {
//		officepage = PageFactory.initElements(driver, OfficePageobject.class);
		this.officepage.ClickSettings();
		officepage.AddNewOfficeBtn();
		officepage.enterOfficeName("Bangalore");
		officepage.ClickOfficeTypedropdown();
		officepage.SelectOfficeType();
		officepage.EnterAddress("Marathahalli, Bangalore.");
		officepage.Clickcitydropdown();
		officepage.EnterCityValue("Bangalore");
		officepage.SelectCityOption();
		officepage.EnterPincode("530067");
		officepage.enterPrimaryContactName("Admin");
		officepage.enterPrimaryContactNumber("8595874830");
		officepage.clickSubmitofficebtn();
	}
}
	
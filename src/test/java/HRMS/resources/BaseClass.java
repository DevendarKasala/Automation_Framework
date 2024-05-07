package HRMS.resources;

import java.util.Collections;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	static WebDriver driver;
	
	
	public static WebDriver setDriver(String browserName) {
		
		
		if(browserName.equals("CHROME")) {
			WebDriverManager.chromedriver().setup();
			
			//create instance of driver
			driver = new ChromeDriver(getChromeOptions());
		}
		else {
			driver = null;
			
		}
		return driver;
	}
	public static ChromeOptions getChromeOptions() {
		
		final ChromeOptions chromeoptions = new ChromeOptions();
//		chromeoptions.addArguments("--headless");
		chromeoptions.addArguments("disable-infobars");
		chromeoptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		chromeoptions.addArguments("--disable-gpu");
		chromeoptions.addArguments("--disable extensions");
		chromeoptions.addArguments("--no-sandbox");
		chromeoptions.addArguments("--disable-dev-shm-usage");
		chromeoptions.addArguments("--window-size=1580, 1280");
		
		final HashMap<String, Object> prefs = new HashMap();
		prefs.put("credentials_enable_Service", false);
		prefs.put("profile.password_manager_enabled", false);
		chromeoptions.setExperimentalOption("prefs", prefs);
		
		return chromeoptions;
	}
	
	
}

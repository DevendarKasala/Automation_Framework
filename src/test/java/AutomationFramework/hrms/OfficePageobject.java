package AutomationFramework.hrms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OfficePageobject {
	
	WebDriver driver;

	public OfficePageobject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	//settings link in L1 Menu
	@FindBy(xpath = "//a[(@href='/settings')]")
	WebElement settingslink;
	
	public void ClickSettings() {
		settingslink.click();
	}
	
	//companysetup link in L2 Menu
	@FindBy(xpath = "//span[text()='Company Setup']")
	WebElement companysetuplink;
	
	public void ClickCompanysetup() {
		companysetuplink.click();
	}
	
	//Offices link
	@FindBy(xpath = "//a[text()='Offices']")
	WebElement officeslink;
	
	public void ClickOfficesLink() {
		officeslink.click();
	}
	
	//Add new Office button
	@FindBy(xpath = "//button[contains(@class,'add-office')]")
	WebElement addnewofficebtn;
	
	public void AddNewOfficeBtn() {
		addnewofficebtn.click();
	}
	
	//Office name input Box
	@FindBy(xpath = "//input[@placeholder='e.g. Mumbai Office']")
	WebElement officenameinput;
	
	public void enterOfficeName(String name) {
		officenameinput.sendKeys(name);
	}
	
	//Office Type dropdown
	@FindBy(xpath = "//button[text()='Select']")
	WebElement officetypedrpdwn;
	
	public void ClickOfficeTypedropdown() {
		officetypedrpdwn.click();
	}
	
	//Select option(Head Quarters from Officetype Menu
	@FindBy(xpath = "//div[@class='dropdown-menu-items']/a//span[text()='Head Quarter']")
	WebElement selectofficeType;
	
	public void SelectOfficeType() {
		selectofficeType.click();
	}
	
	//Address field
	@FindBy(xpath = "//textarea[@placeholder='Street name']")
	WebElement addresstextarea;
	
	public void EnterAddress(String address) {
		addresstextarea.sendKeys(address);
	}
	
	//Click City dropdown
	@FindBy(xpath = "//button[text()='Search City']")
	WebElement searchcitydropdown;
	
	public void Clickcitydropdown() {
		searchcitydropdown.click();
	}
	
	//enter city text area
	@FindBy(xpath = "//button[@class='dropdown-btn placeholder-text']/input")
	WebElement entercitytext;
	
	public void EnterCityValue(String enterCity) {
		entercitytext.sendKeys(enterCity);
	}
	
	//Select entered city option from the dropdown
	@FindBy(xpath = "//div[@class='show dropdown']/div/a")
	WebElement selectcityoption;
	
	public void SelectCityOption() {
		selectcityoption.click();
	}
	
	//PIN Code field
	@FindBy(xpath = "//input[@placeholder='Pin Code']")
	WebElement officepincode;
	
	public void EnterPincode(String pincode) {
		officepincode.sendKeys(pincode);
	}
	
	//State dropdown in office
	@FindBy(xpath = "(//button[text()='Select'])[2]")
	WebElement statedropdown;
	
	public void clickStatedropdown() {
		statedropdown.click();
	}
	
	//Primary Contact Name in office
	@FindBy(xpath = "//input[@placeholder='e.g. John Doe']")
	WebElement primarycontactname;
	
	public void enterPrimaryContactName(String contactname) {
		primarycontactname.sendKeys(contactname);
	}
	
	//primary contact number in office
	@FindBy(xpath = "//input[@placeholder='xxxxxxxxxx']")
	WebElement primarycontactnumber;
	
	public void enterPrimaryContactNumber(String contactnum) {
		primarycontactnumber.sendKeys(contactnum);
	}
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement addofficesubmit;
	
	public void clickSubmitofficebtn() {
		addofficesubmit.click();
	}
	
	
	
}

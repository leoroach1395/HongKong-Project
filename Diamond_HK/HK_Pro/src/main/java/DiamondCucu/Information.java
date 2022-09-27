package DiamondCucu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Information {
 public WebDriver driver;
 public Information(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
		}	
 @FindBy(xpath="//input[@class='input-text email-input']")
	private WebElement email;

	public WebElement getemail() {
		return email;
}
	@FindBy(xpath="//div[@class='field custom_firstname placeholder1 _required floating-label']//input[@class='input-text']")
	private WebElement Firstname;

	public WebElement getFirstname() {
		return Firstname;
	}
	@FindBy(xpath="//div[@class='field custom_lastname placeholder1 _required floating-label']//input[@class='input-text']")
	private WebElement Lastname;

	public WebElement getLastname() {
		return Lastname;
	}
	@FindBy(xpath="//div[@class='field custom_street_0 placeholder1 _required floating-label']//input[@class='input-text']")
	private WebElement First_address;

	public WebElement getFirst_address() {
		return First_address;
	}
	@FindBy(xpath="//div[@class='field custom_street_1 placeholder1 floating-label']//input[@class='input-text']")
	private WebElement Second_address;

	public WebElement getSecond_address() {
		return Second_address;
	}
	
	@FindBy(xpath="//div[@class='field custom_city placeholder1 _required floating-label']//input[@class='input-text']")
	private WebElement city_address;

	public WebElement getcity_address() {
		return city_address;
	}
	
	@FindBy(xpath="//div[@class='field custom_country placeholder1 _required']//select[@class='select']")
	private WebElement country_dropdown;//India

	public WebElement getcountry_dropdown() {
		return country_dropdown;
	}
	
	@FindBy(xpath="//div[@class='field _required']//select[@class='select']")
	private WebElement state_sk;

	public WebElement getstate_sk() {
		return state_sk;
	}
	@FindBy(xpath="//div[@class='field custom_postcode placeholder1 floating-label _required']//input[@class='input-text']")
	private WebElement postal_code;

	public WebElement getpostal_code() {
		return postal_code;
	}
	@FindBy(xpath="//div[@class='iti__selected-flag']")
	private WebElement phn_countrychoose;

	public WebElement getphn_countrychoose() {
		return phn_countrychoose;
	}
	
	@FindBy(xpath="//li[@data-country-code='in']")
	private WebElement phn_countrycode;

	public WebElement getphn_countrycode() {
		return phn_countrycode;
	}
	
	@FindBy(xpath="//input[@class='input-text g-validate-init-number']")
	private WebElement phn_num;

	public WebElement getphn_num() {
		return phn_num;
	}
	
	
}

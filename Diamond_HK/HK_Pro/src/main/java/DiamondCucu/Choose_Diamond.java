package DiamondCucu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Choose_Diamond {
	public  WebDriver driver;
	
	public Choose_Diamond(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2,this);
	}
@FindBy(xpath="//*[@id=\"139480337\"]/td[14]")
private WebElement view;

public WebElement getView() {
	return view;
}







}

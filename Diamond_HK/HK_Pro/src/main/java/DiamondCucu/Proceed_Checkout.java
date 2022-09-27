package DiamondCucu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Proceed_Checkout {
	public WebDriver driver;
	
	@FindBy(xpath="//button[@class='action primary checkout']")
	private WebElement checkout;

	public Proceed_Checkout(WebDriver driver2) {
  this.driver=driver2;
  PageFactory.initElements(driver, this);
	}

	public WebElement getCheckout() {
		return checkout;
	}
	
	

}

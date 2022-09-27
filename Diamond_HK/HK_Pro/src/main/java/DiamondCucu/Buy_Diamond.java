package DiamondCucu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Buy_Diamond {
public static WebDriver driver;

@FindBy(xpath="//div[@class='box-tocart']//button[@id='product-addtocart-button']")
private WebElement Buy;

public Buy_Diamond(WebDriver driver2) {
Buy_Diamond.driver=driver2;
PageFactory.initElements(driver2, this);
}

public WebElement getBuy() {
	return Buy;
}






	
}

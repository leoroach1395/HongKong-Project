package DiamondCucu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Update {
	public WebDriver driver;

	@FindBy(xpath="//span[.='Update Cart']")
	private WebElement Update;

	public Update(WebDriver driver2) {
	this.driver=driver2;
	PageFactory.initElements(driver2, this);
	}

	public WebElement getUpdate() {
		return Update;
	}

}

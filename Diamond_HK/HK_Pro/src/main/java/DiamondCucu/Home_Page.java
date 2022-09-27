package DiamondCucu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	public WebDriver driver;
	public Home_Page(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}
	@FindBy(xpath="//li[@class='inmenu-buy-diamonds']//a[@class='innermenu-alink']")
	private WebElement BuyDiamond;
	
	public WebElement getBuyDiamond() {
		
		return BuyDiamond;
	}
	
	

}

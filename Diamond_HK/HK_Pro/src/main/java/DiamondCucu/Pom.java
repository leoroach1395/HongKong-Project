package DiamondCucu;

import org.openqa.selenium.WebDriver;

public class Pom {
	public static WebDriver driver;
	public static Home_Page home;
	public static Choose_Diamond choose;
	public static Buy_Diamond Buy;
	public static Update update;
	public static Proceed_Checkout checkout;
	public static Information information;

	public  Information getInformation() {
		Information information=new Information(driver);
		return information;
	}

	public  Update getUpdate() {
		Update update=new Update(driver);
		return update;
	}
	
	public Pom(WebDriver driver2) {
		   Pom.driver=driver2;
			}
	public Proceed_Checkout getCheckout() {
		Proceed_Checkout checkout=new Proceed_Checkout(driver);
		return checkout;
	}
	
	public Home_Page getHome() {
		Home_Page home=new Home_Page(driver);
		return home;
	}
	public Choose_Diamond getChoose() {
		Choose_Diamond choose=new Choose_Diamond(driver);
		return choose;
	}

	public Buy_Diamond getBuy() {
		Buy_Diamond Buy=new Buy_Diamond(driver);
		return Buy;
	}


}

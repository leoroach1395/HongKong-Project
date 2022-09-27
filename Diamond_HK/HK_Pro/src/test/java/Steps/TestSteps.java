package Steps;

import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import DiamondCucu.BaseClass;
import DiamondCucu.Pom;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSteps extends BaseClass {

	public static WebDriver driver;
	public static Pom manager;
	
	@Given("user enter the {string}")
	public void user_enter_the(String string) {
	   
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		manager= new Pom(driver);
		launchSite(driver, string);
		maximize(driver);
		implicitWait(driver, 10);
	}	

	@And("user should see the page title as {string}")
	public void user_should_see_the_page_title_as(String string) {
		
		String title = driver.getTitle();
		Assert.assertEquals(string, title);
		System.out.println(title);
	}	
	@Given("user enters the buy diamonds module")
	public void user_enters_the_buy_diamonds_module() {
    clickOnElement(manager.getHome().getBuyDiamond());
	}

	@Then("user view the choosed product using by click and Navigates to Buy diamond")
	public void user_view_the_choosed_product_using_by_click_and_navigates_to_buy_diamond() {
      jSscrollToElement(manager.getChoose().getView(), driver);
      mouseActions(manager.getChoose().getView(),"click", driver);
	}

	@Then("user click buy diamond and Navigates to Shopping cart")
	public void user_click_buy_diamond_and_navigates_to_shopping_cart() {
     jSscrollToElement(manager.getBuy().getBuy(), driver);
		clickOnElement(manager.getBuy().getBuy());
	}

	@Then("user click the Proceed to checkout and it Navigates to Shipping Address")
	public void user_click_the_proceed_to_checkout_and_it_navigates_to_shipping_address() throws InterruptedException {
     jSscrollToElement(manager.getCheckout().getCheckout(), driver);
		clickOnElement(manager.getCheckout().getCheckout());
	}

   
	@When("User Enter the first Name {string}")
	public void user_enter_the_first_name(String string) {
    
		enterValues(manager.getInformation().getFirstname(), string);
	}

	@When("User Enter the Last Name {string}")
	public void user_enter_the_last_name(String string) {
     enterValues(manager.getInformation().getLastname(), string);
	}

	@When("User Enter the First address {string}")
	public void user_enter_the_first_address(String string) {
enterValues(manager.getInformation().getFirst_address(), string);
	}

	@When("User Enter the Second address {string}")
	public void user_enter_the_second_address(String string) {
enterValues(manager.getInformation().getSecond_address(), string);
	}

	@When("User Enter the city {string}")
	public void user_enter_the_city(String string) {
enterValues(manager.getInformation().getcity_address(), string);
	}

	@When("User Select the country")
	public void user_select_the_country() {
  singleDropDown(manager.getInformation().getcountry_dropdown(),"India");
	}

	@When("User Enter the state {string}")
	public void user_enter_the_state(String string) {
singleDropDown(manager.getInformation().getstate_sk(), string);	
	}

	@When("User Enter the Postalcode {string}")
	public void user_enter_the_postalcode(String string) {
enterValues(manager.getInformation().getpostal_code(), string);
	}
	@Then("User Select the country and Enter the contact num {string}")
	public void user_select_the_country_and_enter_the_contact_num(String string) {
     clickOnElement(manager.getInformation().getphn_countrychoose());
		mouseActions(manager.getInformation().getphn_countrycode(), "mouseover", driver);
		mouseActions(manager.getInformation().getphn_countrycode(), "click", driver);
		enterValues(manager.getInformation().getphn_num(), string);
	}
	@AfterClass
public void close_Browser() {
driver.quit();
}
	
}

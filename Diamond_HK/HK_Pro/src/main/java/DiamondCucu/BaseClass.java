package DiamondCucu;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver browserSetting(String browser) {

		if (browser.equalsIgnoreCase("CHROME")) {

			System.setProperty("webdriver.chrome.driver", "D:\\Anish_Mav_PT001\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("FIREFOX")) {

			System.setProperty("webdriver.gecko.driver", "D:\\Anish_Mav_PT001\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

		else if (browser.equalsIgnoreCase("EDGE")) {

			System.setProperty("webdriver.edge.driver", "D:\\Anish_Mav_PT001\\Driver\\msedgedriver.exe");
			driver = new EdgeDriver();

		}

		return driver;

	}

	public static  void launchSite(WebDriver driver, String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void maximize(WebDriver driver) {
		driver.manage().window().maximize();

	}

	public static void minimize(WebDriver driver) {
		driver.manage().window().minimize();

	}

	public static void close(WebDriver driver) {
		driver.close();

	}

	public static void quit(WebDriver driver) {
		driver.quit();

	}

	public static void goTo(WebDriver driver, String url) {

		driver.navigate().to(url);
	}

	public static void goBack(WebDriver driver) {

		driver.navigate().back();
	}

	public static void goForward(WebDriver driver) {

		driver.navigate().forward();
	}

	public static void refresh(WebDriver driver) {

		driver.navigate().refresh();
	}
	public static void getTitle(String string) {
driver.get(string);
	}

	public static void mouseActions(WebElement ele, String typeofActions, WebDriver driver) {
		Actions mouseAction = new Actions(driver);
		String str = typeofActions.replaceAll(" ", "");

		if (str.equalsIgnoreCase("click")) {

			mouseAction.click(ele).build().perform();
		}

		if (str.equalsIgnoreCase("rightclick")) {
			mouseAction.contextClick(ele).build().perform();
		}

		if (str.equalsIgnoreCase("mouseover")) {
			mouseAction.moveToElement(ele).build().perform();
		}

	}

	public static void dragAndDrop(WebDriver driver, WebElement src, WebElement dest) {
		Actions mouseAction = new Actions(driver);
		mouseAction.dragAndDrop(src, dest).build().perform();

	}

	public static void explicitWait(WebDriver driver, WebElement ele, int seconds) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void fluentWait(WebDriver driver, int seconds, int millis) {

		Wait<WebDriver> d = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(seconds))
				.pollingEvery(Duration.ofMillis(millis)).ignoring(NoSuchElementException.class);

	}

	public static void implicitWait(WebDriver driver, int seconds) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public static WebElement getElementById(WebDriver driver, String ele) throws InterruptedException {
		while (true) {
			try {
				WebElement e = driver.findElement(By.id(ele));
				return e;
			} catch (Exception e) {
				driver.navigate().refresh();

			}
			// return null;
		}
	}

	public static List<WebElement> getElementsById(WebDriver driver, String ele) throws InterruptedException {
		while (true) {
			try {
				List<WebElement> elements = driver.findElements(By.id(ele));
				return elements;
			} catch (Exception e) {
				driver.navigate().refresh();

			}
			// return null;
		}
	}

	public static WebElement getElementByName(WebDriver driver, String name) throws InterruptedException {
		while (true) {
			try {
				WebElement e = driver.findElement(By.name(name));
				return e;
			} catch (Exception e) {
				driver.navigate().refresh();

			}
			// return null;
		}
	}

	public static List<WebElement> getElementsByName(WebDriver driver, String ele) throws InterruptedException {
		while (true) {
			try {
				List<WebElement> elements = driver.findElements(By.name(ele));
				return elements;
			} catch (Exception e) {
				driver.navigate().refresh();

			}
			// return null;
		}
	}

	public static WebElement getElementByXpath(WebDriver driver, String xpath) throws InterruptedException {
		while (true) {
			try {
				WebElement e = driver.findElement(By.xpath(xpath));
				return e;
			} catch (Exception e) {
				driver.navigate().refresh();

			}
			// return null;
		}
	}

	public static List<WebElement> getElementsByXpath(WebDriver driver, String ele) throws InterruptedException {
		while (true) {
			try {
				List<WebElement> elements = driver.findElements(By.xpath(ele));
				return elements;
			} catch (Exception e) {
				driver.navigate().refresh();

			}
			// return null;
		}
	}

	public static void clickOnElement(WebElement ele) {

		ele.click();

	}

	public static void enterValues(WebElement ele, String value) {

		try {
			if (ele.isEnabled() && ele.isDisplayed()) {
				ele.sendKeys(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void singleDropDown(WebElement ele, Object sel) {
		Select s = new Select(ele);

		if (sel instanceof Integer) {

			s.selectByIndex((int) sel);
		}

		if (sel instanceof String) {
			s.selectByVisibleText((String) sel);
		}

	}
	// MULTI DROP DOWN BY INDEX
	/*
	 * public static void multiDropDownByIndex(WebElement ele, int a, int b, int c,
	 * int d, int e, int f, int g, int h, int I, int j, int k, int l) { Select s =
	 * new Select(ele);
	 * 
	 * if (s.isMultiple()) {
	 * 
	 * List<WebElement> options = s.getOptions();
	 * 
	 * for (int i = 0; i <= options.size(); i++) {
	 * 
	 * if (i == a || i == b || i == c || i == d || i == e || i == f || i == g || i
	 * == h || i == I || i == j || i == k || i == l) {
	 * 
	 * s.selectByIndex(i);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * } //MULTI DROP DOWN BY TEXT public static void multiDropDownByText(WebElement
	 * ele, String a, String b, String c, String d, String e, String f) { Select s =
	 * new Select(ele);
	 * 
	 * if (s.isMultiple()) {
	 * 
	 * List<WebElement> options = s.getOptions();
	 * System.out.println("All Texts in the DropDown is:"); for (WebElement str :
	 * options) {
	 * 
	 * System.out.println(str.getText()); } for (int i = 0; i <= options.size();
	 * i++) { if (options.get(i).getText().equals(a)) { s.selectByVisibleText(a); }
	 * 
	 * if (options.get(i).getText().equals(b)) { s.selectByVisibleText(b); }
	 * 
	 * if (options.get(i).getText().equals(c)) { s.selectByVisibleText(c); }
	 * 
	 * if (options.get(i).getText().equals(d)) { s.selectByVisibleText(d); }
	 * 
	 * if (options.get(i).getText().equals(e)) { s.selectByVisibleText(e); }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 */

	public static void screenShot(WebDriver driver, String name) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\Anish_Mav_PT001\\Screenshot\\" + name + ".png");
		FileUtils.copyFile(src, dest);

	}

	public static void jSclick(WebElement ele, WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);

	}

	public static void jSscrollToElement(WebElement ele, WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);

	}

	public static void jSscrollDown(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");

	}

	public static void jSscrollUp(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0);");

	}

	public static void windowSwitch(WebDriver driver, String title) throws InterruptedException {

		Set<String> w = driver.getWindowHandles();
		for (String str : w) {

			if (driver.switchTo().window(str).getTitle().contains(title)) {
				driver.switchTo().window(str);
				break;
			}

		}

	}

	public static void getWindowstitle(WebDriver driver) {

		Set<String> w = driver.getWindowHandles();
		System.out.println();
		System.out.println("Titles of all the windows or tabs are as follows:");

		for (String str : w) {

			String title = driver.switchTo().window(str).getTitle();
			System.out.println(title);
		}

	}

	public static void robotUpDown(WebDriver driver, String action, int numOfPress) throws AWTException {

		Robot r = new Robot();

		if (action.contains("up")) {
			for (int i = 1; i <= numOfPress; i++) {
				r.keyPress(KeyEvent.VK_UP);
				r.keyRelease(KeyEvent.VK_UP);
			}
		}

		if (action.contains("down")) {
			for (int i = 1; i <= numOfPress; i++) {
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
			}
		}

		if (action.contains("enter")) {
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);

		}
	}

	public static void alertHandling(WebDriver driver, String action) throws InterruptedException {

		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		if (action.equalsIgnoreCase("accept")) {
			alert.accept();
		}

		if (action.equalsIgnoreCase("dismiss")) {
			alert.dismiss();
		}

	}

	public static void frameHandling(WebDriver driver, int index) {

		driver.switchTo().frame(index);
	}

	public static void defaultContent(WebDriver driver) {

		driver.switchTo().defaultContent();
	}

	public static void getOptions(WebDriver driver, WebElement ele) {
		try {
			Select s = new Select(ele);
			List<WebElement> options = s.getOptions();
			System.out.println("All options are:");
			for (WebElement str : options) {

				System.out.println(str.getText());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getAllSelectedOptions(WebDriver driver, WebElement ele) {
		try {
			Select s = new Select(ele);
			List<WebElement> options = s.getAllSelectedOptions();
			System.out.println("All Selected options are:");
			for (WebElement str : options) {

				System.out.println(str.getText());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void multiDropDown(WebDriver driver, WebElement ele, Object a, Object b, Object c, Object d, Object e,
			Object f) throws InterruptedException {
		Select s = new Select(ele);

		ArrayList<Object> ar = new ArrayList<Object>();
		ar.add(a);
		ar.add(b);
		ar.add(c);
		ar.add(d);
		ar.add(e);
		ar.add(f);
		if (s.isMultiple()) {
			for (Object list : ar) {

				if (list instanceof String) {

					String string = list.toString();

					if (string.equals(a)) {
						s.selectByVisibleText((String) a);
					}

					if (string.equals(b)) {
						s.selectByVisibleText((String) b);
					}

					if (string.equals(c)) {
						s.selectByVisibleText((String) c);
					}

					if (string.equals(d)) {
						s.selectByVisibleText((String) d);
					}

					if (string.equals(e)) {
						s.selectByVisibleText((String) e);
					}

					if (string.equals(f)) {
						s.selectByVisibleText((String) f);
					}
				}

				else {

					if (list instanceof Integer) {
						String str = list.toString();

						for (int i = Integer.parseInt(str); i <= s.getOptions().size();) {
							s.selectByIndex(i);
							break;
						}

					}

				}

				Thread.sleep(2000);

			}

		}
	}

	public static void deSelectMultiDropdown(WebDriver driver, WebElement ele, Object a, Object b, Object c, Object d,
			Object e, Object f) throws InterruptedException {
		Select s = new Select(ele);

		ArrayList<Object> ar = new ArrayList<Object>();
		ar.add(a);
		ar.add(b);
		ar.add(c);
		ar.add(d);
		ar.add(e);
		ar.add(f);
		if (s.isMultiple()) {
			for (Object list : ar) {

				if (list instanceof String) {
                    
					String string = list.toString();

					if (string.equals(a)) {
						s.deselectByVisibleText((String) a);
					}

					if (string.equals(b)) {
						s.deselectByVisibleText((String) b);
					}

					if (string.equals(c)) {
						s.deselectByVisibleText((String) c);
					}

					if (string.equals(d)) {
						s.deselectByVisibleText((String) d);
					}

					if (string.equals(e)) {
						s.deselectByVisibleText((String) e);
					}

					if (string.equals(f)) {
						s.deselectByVisibleText((String) f);
					}
				}

				else {

					if (list instanceof Integer) {
						String str = list.toString();

						for (int i = Integer.parseInt(str); i <= s.getOptions().size();) {
							s.deselectByIndex(i);
							break;
						}

					}

				}

				Thread.sleep(2000);

			}

		}
	}

	public static void deSelectAll(WebDriver driver, WebElement ele) {
		try {
			Select s = new Select(ele);
			s.deselectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void firstSelectedOption(WebDriver driver, WebElement ele) {
		try {
			Select s = new Select(ele);
			s.getFirstSelectedOption();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void isEnable(WebDriver driver, WebElement ele) {

		ele.isEnabled();
	}

	public static void isDisplayed(WebDriver driver, WebElement ele) {

		ele.isDisplayed();
	}

	public static void isSelected(WebDriver driver, WebElement ele) {

		ele.isSelected();
	}

	public static void getPageURL(WebDriver driver) {

		driver.getCurrentUrl();
	}

	public static void getText(WebDriver driver, WebElement ele) {

		ele.getText();

	}

	public static void changeBGcolor(WebDriver driver, WebElement ele, String color) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].style.backgroundcolor='" + color + "'", ele);
	}

	public static void flashElement(WebDriver driver, WebElement ele, int flashTime) throws InterruptedException {

		String bgColor = ele.getCssValue("backgroundcolor");
		for (int i = 0; i < flashTime; i++) {
			changeBGcolor(driver, ele, "#FF0000");
			Thread.sleep(100);
			changeBGcolor(driver, ele, bgColor);

		}
	}

	//public static String getParticularCellValue(int sheetNo, int rowNo, int cellNo) throws IOException {

//		File src = new File("D:\\Anish_Mav_PT001\\dataDriven.xlsx");

//		FileInputStream input = new FileInputStream(src);
////
//		Workbook wr = new XSSFWorkbook(input);
//
//		Sheet sheet1 = wr.getSheetAt(sheetNo);
//
//		Row row = sheet1.getRow(rowNo);
//
//		
//		Cell cell = row.getCell(cellNo);
//
//		CellType cellType = cell.getCellType();
//
//		if (cellType.equals(cellType.STRING)) {
//			String str = cell.getStringCellValue();
//
//			return str;
//		}
//
//		return null;
//
//	}
	

	public static void webTable(WebDriver driver, String xpath, String rows, String cols) {

		String table = "//table";
		String o = "[";
		String path = xpath;
		String n = "]";
		String tbody = "//tbody";
		String tr = "//tr";
		String p = "[";
		String trd = rows;
		String e = "]";
		String td = "//td";
		String o1 = "[";
		String col = cols;
		String c = "]";

		if (xpath.contains(null) && rows.contains(null) && cols.contains(null)) {

			String concat1 = table.concat(tbody).concat(tr).concat(td);

			List<WebElement> tables = driver.findElements(By.xpath(concat1));

			for (WebElement content : tables) {

				String text = content.getText();
				System.out.println(text);
			}

		}

		if (xpath.contains(null)) {

			String concat2 = table.concat(tbody).concat(tr).concat(p).concat(trd).concat(e).concat(td).concat(o1)
					.concat(col).concat(c);

			List<WebElement> tables = driver.findElements(By.xpath(concat2));

			for (WebElement content : tables) {

				String text = content.getText();
				System.out.println(text);
			}

		}

		if (rows.contains(null) && cols.contains(null)) {

			String concat3 = table.concat(o).concat(path).concat(n).concat(tbody).concat(tr).concat(td);

			List<WebElement> tables = driver.findElements(By.xpath(concat3));

			for (WebElement content : tables) {

				String text = content.getText();
				System.out.println(text);
			}

		}

		if (xpath.contains(null) && rows.contains(null)) {

			String concat4 = table.concat(tbody).concat(tr).concat(td).concat(o1).concat(col).concat(c);
			List<WebElement> tables = driver.findElements(By.xpath(concat4));

			for (WebElement content : tables) {

				String text = content.getText();
				System.out.println(text);

			}
		}

		else {

			String concat = table.concat(o).concat(path).concat(n).concat(tbody).concat(tr).concat(p).concat(trd)
					.concat(e).concat(td).concat(o1).concat(col).concat(c);

			List<WebElement> tables = driver.findElements(By.xpath(concat));

			for (WebElement content : tables) {

				String text = content.getText();
				System.out.println(text);

			}

		}

	}


}

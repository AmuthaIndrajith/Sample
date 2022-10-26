package org.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Robot r;
	public static Actions a;
	public static Select s;
	public static WebDriverWait w;

	// 1.Launch Browser
	public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	// 2.Launch Edge
	public static void launchEdge() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	// 3.Launch Firefox
	public static void launchFirefox() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	// 4.Url
	public static void loadUrl(String url) {
		driver.get(url);
	}

	// 5.Maximize
	public static void winMax() {
		driver.manage().window().maximize();
	}

	// 6.Title
	public static void printTitle() {
		System.out.println(driver.getTitle());
	}

	// 7.CurrentUrl
	public static void printCurrentUrl() {
		System.out.println(driver.getCurrentUrl());
	}

	// 8.SendKeys
	public static void fill(WebElement ele, String value) {
		ele.sendKeys(value);
	}

	// 9.Click
	public static void btnClick(WebElement ele) {
		ele.click();
	}

	// 10.Get Text
	public static void printText(WebElement ele) {
		String text = ele.getText();
		System.out.println(text);
	}

	// 11.Get Attribute Name
	public static void getAttributeName(WebElement ele, String name) {
		String attName = ele.getAttribute(name);
		System.out.println(attName);
	}

	// 12.Get Attribute Value
	public static void getAttributeValue(WebElement ele, String value) {
		String attValue = ele.getAttribute(value);
		System.out.println(attValue);
	}

	// 13.Enter
	public static void enterBtn() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	// 14.Down
	public static void downArrow() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	// 15.UP
	public static void upArrow() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}

	// 16.Tab
	public static void tab() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}

	// 17.Copy
	public static void copy() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}

	// 18.Paste
	public static void paste() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}

	// 19.Cut
	public static void cut() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_X);
	}

	// 20.SelectAll
	public static void selectAll() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
	}

	// 21.ForLoopDown
	public static void loopDown(int num) throws AWTException {
		r = new Robot();
		for (int i = 0; i <= num; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
	}

	// 22.CursorMouseOver
	public static void cusorMove(WebElement ref) {
		a = new Actions(driver);
		a.moveToElement(ref).perform();
	}

	// 23.CursorMouseOver and RightClick
	public static void CursorRightclick(WebElement ref) {
		a = new Actions(driver);
		a.moveToElement(ref).contextClick(ref).build().perform();
	}

	// 24.CursorMouseOver and DoubleClick
	public static void cursorDoubleclick(WebElement ref) {
		a = new Actions(driver);
		a.moveToElement(ref).doubleClick().build().perform();
	}

	// 25.CursorMouseOver and Click
	public static void cursorClick(WebElement ref) {
		a = new Actions(driver);
		a.moveToElement(ref).click().build().perform();
	}

	// 26.DoubleClick and RightClick
	public static void doubleContextclick(WebElement ref) {
		a = new Actions(driver);
		a.doubleClick(ref).contextClick(ref).build().perform();
	}

	// 27.DragAndDrop
	public static void dragDrop(WebElement src, WebElement des) {
		a = new Actions(driver);
		a.dragAndDrop(src, des).perform();
	}

	// 28.Simple Alert Accept
	public static void toAccept() {
		driver.switchTo().alert().accept();
	}

	// 29.Confirm Alert Dismiss
	public static void toDismiss() {
		driver.switchTo().alert().dismiss();
	}

	// 30.Prompt Send Keys
	public static void toSendkeys(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	// 31.Alert Get Text
	public void toGetText() {
		driver.switchTo().alert().getText();
	}

	// 32. Prompt Alert
	public static void promptAlert(String str) {
		Alert at = driver.switchTo().alert();
		at.sendKeys(str);
		at.accept();
	}

	// 33.Frame Id
	public static void frameId(String id) {
		driver.switchTo().frame(id);
	}

	// 34.Frame Name
	public static void frameName(String name) {
		driver.switchTo().frame(name);
	}

	// 35.Frame WebElement
	public static void frameWeb(WebElement ele) {
		driver.switchTo().frame(ele);
	}

	// 36.Frame Index
	public static void frameIndex(int index) {
		driver.switchTo().frame(index);
	}

	// 37.Screenshot
	public static void screenshot(String name) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("E:\\Selenium Training\\eclipsework\\SeleniumProject\\screenshot\\" + name + ".jpg");
		FileUtils.copyFile(src, des);
	}

	// 38.Select By Value
	public static void selectValue(WebElement ele, String value) {
		s = new Select(ele);
		s.selectByValue(value);
	}

	// 39.Select By VisibleText
	public static void selectVisibleText(WebElement ele, String value) {
		s = new Select(ele);
		s.selectByVisibleText(value);
	}

	// 40.Select By Index
	public static void selectIndex(WebElement ele, int index) {
		s = new Select(ele);
		s.selectByIndex(index);
	}

	// 41.Is Multiple
	public static void multiple(WebElement ele) {
		s = new Select(ele);
		boolean b = s.isMultiple();
		System.out.println(b);
	}

	// 42.Get Options
	public static void options(WebElement ele) {
		s = new Select(ele);
		s.getOptions();
	}

	// 43.Get All Selected Options
	public static void allOptions(WebElement ele) {
		s = new Select(ele);
		List<WebElement> li = s.getAllSelectedOptions();
		for (WebElement elem : li) {
			System.out.println(elem.getText());
		}
	}

	// 44.Get First Selected Option
	public static void firstSelectOption(WebElement ele) {
		s = new Select(ele);
		WebElement elem = s.getFirstSelectedOption();
		System.out.println(elem.getText());
	}

	// 45.DeSelect By Index
	public static void deSelectIndex(WebElement ele, int index) {
		s = new Select(ele);
		s.deselectByIndex(index);
	}

	// 46.DeSelect By Value
	public static void deSelectValue(WebElement ele, String value) {
		s = new Select(ele);
		s.deselectByValue(value);
	}

	// 47.DeSelect By VisibleText
	public static void deSelectVisibleText(WebElement ele, String value) {
		s = new Select(ele);
		s.deselectByVisibleText(value);
	}

	// 48.DeSelect All
	public static void deSelectFull(WebElement ele) {
		s = new Select(ele);
		s.deselectAll();
	}

	// 49.Windows Handling
	public static void windowHand() {
		String parentID = driver.getWindowHandle();
		Set<String> allwindowId = driver.getWindowHandles();
		for (String eachId : allwindowId) {
			if (!parentID.equals(eachId)) {
				driver.switchTo().window(eachId);
			}
		}
	}

	// 50.Alert Is Present
	public static void alertPresent(int sec) {
		w = new WebDriverWait(driver, sec);
		w.until(ExpectedConditions.alertIsPresent());
	}

	// 51.Element Selection State ToBe
	public static void eleSelectionStateToBe(By locator, boolean selected, int sec) {
		w = new WebDriverWait(driver, sec);
		w.until(ExpectedConditions.elementSelectionStateToBe(locator, selected));
	}

	// 52.Element ToBe Clickable
	public static void eleClickable(By locator, int sec) {
		w = new WebDriverWait(driver, sec);
		w.until(ExpectedConditions.elementToBeClickable(locator));
	}

	// 53.Element ToBe Selected
	public static void eleSelected(WebElement ele, int sec) {
		w = new WebDriverWait(driver, sec);
		w.until(ExpectedConditions.elementToBeSelected(ele));
	}

	// 54.Frame ToBe Available And Switch Text
	public static void frameAvailableSwitch(By locator, int sec) {
		w = new WebDriverWait(driver, sec);
		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	// 55.Invisibility of the Element Located
	public static void invisibilityEleLocated(By locator, int sec) {
		w = new WebDriverWait(driver, sec);
		w.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	// 56.Invisibility of the Element with Text
	public static void invisibilityEleText(By locator, String text, int sec) {
		w = new WebDriverWait(driver, sec);
		w.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
	}

	// 57.Presence of All Elements Located By
	public static void presenceAllEleLoc(By locator, int sec) {
		w = new WebDriverWait(driver, sec);
		w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	// 58.Presence of Element Located
	public static void presenceEleLocated(By locator, int sec) {
		w = new WebDriverWait(driver, sec);
		w.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	// 59.Text ToBe Present In Element
	public static void txtPresentEle(WebElement ele, String text, int sec) {
		w = new WebDriverWait(driver, sec);
		w.until(ExpectedConditions.textToBePresentInElement(ele, text));
	}

	// 60.Text ToBe Present In Element Located
	public static void txtPresentinEleLoc(By locator, String text, int sec) {
		w = new WebDriverWait(driver, sec);
		w.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

	// 61.Text ToBe Present In Element Value
	public static void txtPresentinEleValue(By locator, String text, int sec) {
		w = new WebDriverWait(driver, sec);
		w.until(ExpectedConditions.textToBePresentInElementValue(locator, text));
	}

	// 62.Title Is
	public static void titleis(String title, int sec) {
		w = new WebDriverWait(driver, sec);
		w.until(ExpectedConditions.titleIs(title));
	}

	// 63.Title Contains
	public static void titleCon(String title, int sec) {
		w = new WebDriverWait(driver, sec);
		w.until(ExpectedConditions.titleContains(title));
	}

	// 64.Visibility Of
	public static void visibilityof(WebElement ele, int sec) {
		w = new WebDriverWait(driver, sec);
		w.until(ExpectedConditions.visibilityOf(ele));
	}

	// 65.Visibility Of All Elements
	public static void visibilityAllEle(WebElement ele, int sec) {
		w = new WebDriverWait(driver, sec);
		w.until(ExpectedConditions.visibilityOfAllElements(ele));
	}

	// 66.Visibility Of All Elements Located By
	public static void visibilityofAllEleLocBy(By locator, int sec) {
		w = new WebDriverWait(driver, sec);
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	// 67.Visibility Of All Elements Located
	public static void visibilityofAllEleLoc(By locator, int sec) {
		w = new WebDriverWait(driver, sec);
		w.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// 68.Get TagName
	public static void togetTagName(WebElement ele) {
		System.out.println(ele.getTagName());
	}

	// 69.Close
	public static void toClose() {
		driver.close();

	}

	// 70.Quit
	public static void toQuit() {
		driver.quit();
	}

	// 71. Read the value from excel
	public static String getData(String sExcel, int rowNumber, int cellNumber) throws IOException {
		// 1. Declare the location of ur excel sheet
		File f = new File("E:\\Selenium Training\\eclipsework\\FrameworkProject\\target\\testData\\Fam.xlsx");

		// 2. To Read the file
		FileInputStream fin = new FileInputStream(f);

		// 3. Type of Workbook
		Workbook w = new XSSFWorkbook(fin);

		// 4. Get the sheet from Workbook
		Sheet s = w.getSheet(sExcel);

		Row row = s.getRow(rowNumber);
		Cell cell = row.getCell(cellNumber);

		int cellType = cell.getCellType();
		String value = "";
		if (cellType == 1) {
			value = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date d = cell.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd MMM yyyy z");
			value = sim.format(d);
		} else {
			double d = cell.getNumericCellValue();
			long l = (long) d;
			value = String.valueOf(l);
		}
		return value;
	}
}

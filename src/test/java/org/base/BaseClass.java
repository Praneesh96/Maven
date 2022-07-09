package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	WebDriver driver;
//1
	public void launchBrowser() {
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
//2
	public void maximize() {
		driver.manage().window().maximize();
	}
//3
	public void launchUrl(String url) {
		driver.navigate().to(url);
	}
//4
	public WebElement byId(String value) {
		WebElement element = driver.findElement(By.id(value));
		return element;
	}
//5
	public WebElement byName(String value) {
		WebElement element = driver.findElement(By.name(value));
		return element;
	}
//6
	public WebElement className(String value) {
		WebElement element = driver.findElement(By.className(value));
		return element;
	}
//7
	public WebElement xPath(String value) {
		WebElement element = driver.findElement(By.xpath(value));
		return element;
	}
//8
	public void sendkeys(WebElement element, String data) {
		element.sendKeys(data);
	}
//9
	public void click(WebElement element) {
		element.click();
	}
//10
	public void closeWindow() {
		driver.close();
	}
//11
	public void closeAllWindows() {
		driver.quit();
	}
//12
	public void refresh() {
		driver.navigate().refresh();
	}
//13
	public void backword() {
		driver.navigate().back();
	}
//14
	public void forward() {
		driver.navigate().forward();
	}
//15
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}
//16
	// 99% ---->stored in value
	public String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
//17
	// 1%------->stored in someother name so we can put the attributevalue by giving
	// input
	public String getAttributeValue(WebElement element, String attributevalue) {
		String attribute = element.getAttribute(attributevalue);
		return attribute;
	}
//18
	public void mouseOverAction(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
//19
	public void dragAndDrop(WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}
//20
	public void rightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
//21
	public void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
//22
	public void robotShift() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_SHIFT);
	}
//23
	public void robotEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
//24
	public void robotTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}
//25
	public void robotUp() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
	}
//26
	public void robotDown() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}
//27	
	public void simpleAlert() {
		Alert al=driver.switchTo().alert();
		al.accept();
	}
//28	
	public void confirmAlert() {
		Alert al=driver.switchTo().alert();
		al.dismiss();
	}
//29	
	public void promptAlert(String value) {
		Alert al=driver.switchTo().alert();
		al.sendKeys(value);
	}
//30	
	public void sendKeysJs(WebElement element,String text) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value,'"+text+"')", element);
	}
//31	
	public void clickJs(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",element);
	}
//32	
	public String getAttributeJs(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Object executeScript = js.executeScript("returnarguments[0].getAttribute('value')", element);
		String text = executeScript.toString();
		return text;
	}
//33	
	public void scrollDownJs(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView(true)", element);
	}
//34	
	public void scrollUpJs(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView(false)",element);
	}
//35	
	public void threadSleep(int mills) throws InterruptedException {
		Thread.sleep(mills);
	}
//36	
	public void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	} 
//37	
	public void screenshot() throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		File d=new File("path of the location");
		FileUtils.copyFile(s, d);
	}
//38	
	public void screenshotParticularWebElement(WebElement element) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File s = element.getScreenshotAs(OutputType.FILE);
		File d = new File("path of the location");
		FileUtils.copyFile(s, d);
	}
//39	
	public void dropDownSelectByIndex(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
//40	
	public void dropDownSelectByAttributeValue(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
//41	
	public void dropDownSelectByVisibleText(WebElement element,String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
//42	
	public List<WebElement> dropDownGetOptions(WebElement element) {
		Select select=new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
		
	}
//43	
	public List<WebElement> dropDownGetAllSelectedOptions(WebElement element) {
		Select select=new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;
	}
//44	
	public WebElement dropDownGetFirstSelecteOption(WebElement element) {
		Select select=new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		return firstSelectedOption;
	}
//45	
	public void ddnDeselectByIndex(WebElement element,int index) {
		
		Select select =new Select(element);
		select.deselectByIndex(index);
	}
//46	
	public void dDnDeselectAll(WebElement element) {
		Select select=new Select(element);
		select.deselectAll();
	}
//47	
	public boolean dDnisMultiple(WebElement element) {
		Select select=new Select(element);
		boolean b = select.isMultiple();
		return b;
	}
//48	
	public void dDndeselectByvalue(WebElement element,String value) {
		Select select=new Select(element);
		select.deselectByValue(value);
	}
//49	
	public void dDndeSelectByVisibleText(WebElement element,String text) {
		Select select=new Select(element);
		select.deselectByVisibleText(text);
	}
//50	
	public void frameById(String name) {
		driver.switchTo().frame(name);
	}
//51	
	public void frameByElement(WebElement element) {
		driver.switchTo().frame(element);
	}
//52
	public void frameByIndex(int index) {
		driver.switchTo().frame(index);
	}
//53	
	public void returnFromFrame() {
		driver.switchTo().defaultContent();
	} 
//54	
	public String windowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
//55	
	public Set<String> windowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
		
	}
//56	
	public void switchToParentWindow(String element) {
			driver.switchTo().window(element);
	}
//57
	public void clear(WebElement element) {
		element.clear();
	}
//58	
	public String getDataInExcel(String sheetname,int rownum,int cellnum) throws IOException {
		String res=null;
		
		File file=new File("C:\\Users\\MYPC\\eclipse-workspace\\FrameWork\\ExcelWorkSheet\\Book1.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType type = cell.getCellType();
		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
				res = dateFormat.format(dateCellValue);
			}
			else {
				double numericCellValue = cell.getNumericCellValue();
//				BigDecimal b=BigDecimal.valueOf(numericCellValue);	
				long l=(long) numericCellValue;
				res = String.valueOf(l);
			}break;
		default:
			break;
		}
		return res;		
	}
//59	
	public void updateDataInExcel(String sheetname,int rownum,int cellnum,String oldData,String newData) throws IOException {
		
		File file=new File("C:\\Users\\MYPC\\eclipse-workspace\\FrameWork\\ExcelWorkSheet\\Book1.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
		if (value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream output=new FileOutputStream(file);
		workbook.write(output);
	}
//60	
	public void createRowAndCellInExcel(String sheetname,int rownum,int cellnum,String newData) throws IOException {
		File file=new File("C:\\Users\\MYPC\\eclipse-workspace\\FrameWork\\ExcelWorkSheet\\Book1.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.createRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(newData);
		FileOutputStream output=new FileOutputStream(file);
		workbook.write(output);
	}

//62	
	public void createNewExcelWorkbook(String pathofthefilelocation,String sheetname,int rownum,int cellnum,String newData) throws IOException {
		File file=new File(pathofthefilelocation);
		Workbook workbook=new XSSFWorkbook();
		Sheet sheet = workbook.createSheet(sheetname);
		Row createRow = sheet.createRow(rownum);
		Cell createCell = createRow.createCell(cellnum);
		createCell.setCellValue(newData);
		FileOutputStream output =new FileOutputStream(file);
		workbook.write(output);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}	


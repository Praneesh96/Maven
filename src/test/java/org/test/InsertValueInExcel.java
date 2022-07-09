package org.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InsertValueInExcel {

	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\MYPC\\eclipse-workspace\\FrameWork\\ExcelWorkSheet\\DemoTesting.xlsx");

		Workbook workbook = new XSSFWorkbook();

		Sheet sheet = workbook.createSheet("DemoTestingDropDown");
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		
		
		driver.manage().window().maximize();
		driver.navigate().to("http://demo.automationtesting.in/Register.html");

		WebElement skillsDropDown = driver.findElement(By.id("Skills"));

		Select select = new Select(skillsDropDown);

		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);

			String text = webElement.getText();

			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(text);
				
		}
		FileOutputStream stream = new FileOutputStream(file);
		workbook.write(stream);
	}

}

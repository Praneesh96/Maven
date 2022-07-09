package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class AdactinHotel {

	
	public static void main(String[] args) throws IOException {
		BaseClass base=new BaseClass();
		base.launchBrowser();
		base.maximize();
		base.implicitWait(30);
		base.launchUrl("http://adactinhotelapp.com/");
		
		WebElement txtUserName = base.byId("username");
		
		String excel = base.getDataInExcel("Adactin", 1, 0);
		base.sendkeys(txtUserName, excel);
		
		WebElement txtPassword = base.byId("password");
		String excel2 = base.getDataInExcel("Adactin", 1, 1);
		base.sendkeys(txtPassword, excel2);
		
		WebElement btnClick = base.byId("login");
		base.click(btnClick);
		
		WebElement location = base.byId("hotels");
		List<WebElement> options = base.dropDownGetOptions(location);
		File file=new File("C:\\Users\\MYPC\\eclipse-workspace\\FrameWork\\ExcelWorkSheet\\Book1.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook= new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("Adactin");
		
		
		for (int i = 0; i < options.size(); i++) {
			WebElement element = options.get(i);
			String text = element.getText();
			
			Row row = sheet.createRow(i+2);
			Cell cell = row.createCell(3);
			cell.setCellValue(text);
		}
		
		FileOutputStream output=new FileOutputStream(file);
		workbook.write(output);
		
		
		
		
	}

}

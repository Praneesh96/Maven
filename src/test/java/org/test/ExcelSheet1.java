package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheet1 {

	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\MYPC\\eclipse-workspace\\FrameWork\\ExcelWorkSheet\\Book1.xlsx");

		FileInputStream stream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet("TestData");

		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);

			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);

				CellType type = cell.getCellType();

				switch (type) {
				case STRING:
					String s = cell.getStringCellValue();
					System.out.print(s);
					break;
					case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
						String format = dateFormat.format(dateCellValue);
						System.out.println(format);
					} else {
						double d = cell.getNumericCellValue();
						BigDecimal b = BigDecimal.valueOf(d);
						String print = b.toString();
						System.out.println(print);
					}break;
					default:
						break;
				}
			}System.out.println();
			}
		}

}

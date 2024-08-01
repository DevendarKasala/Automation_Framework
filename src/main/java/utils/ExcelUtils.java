package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static Workbook workbook;
	private static Sheet sheet;
	
	public static Object [][] getExcelData(String filepath, String sheetName) {
		Object[][] data =null;
		try {
			
			FileInputStream file = new FileInputStream(new File(filepath));
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet(sheetName);
			
			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			
			data = new Object[rowCount-1][colCount];
			
			for(int i=1;i<rowCount;i++) {
				Row row = sheet.getRow(i);
				for (int j=0;j<colCount;j++) {
					Cell cell = row.getCell(j);
					data[i-1][j] = cell.toString();
					
				}
			}
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}

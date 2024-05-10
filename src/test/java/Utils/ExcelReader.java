package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	public static Object[][] getTestData(String excelFilePath, String sheetName) {
	    Object[][] testData = null;
	    try (FileInputStream fis = new FileInputStream(excelFilePath);
	         Workbook workbook = WorkbookFactory.create(fis)) {
	        Sheet sheet = workbook.getSheet(sheetName);
	        int rowCount = sheet.getLastRowNum();
	        int colCount = sheet.getRow(0).getLastCellNum();
	        testData = new Object[rowCount][colCount];
	        for (int i = 1; i <= rowCount; i++) {
	            Row row = sheet.getRow(i);
	            for (int j = 0; j < colCount; j++) {
	                Cell cell = row.getCell(j);
	                testData[i - 1][j] = getCellValueAsString(cell); // Use a helper method to handle cell values
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return testData;
	}

	private static String getCellValueAsString(Cell cell) {
	    if (cell == null) {
	        return ""; // Handle null cells as empty strings
	    }
	    switch (cell.getCellType()) {
	        case STRING:
	            return cell.getStringCellValue();
	        case NUMERIC:
	            return String.valueOf(cell.getNumericCellValue()); // Convert numeric cells to strings
	        case BOOLEAN:
	            return String.valueOf(cell.getBooleanCellValue());
	        case FORMULA:
	            return cell.getCellFormula(); // Handle formulas if needed
	        default:
	            return ""; // Handle other cell types as empty strings
	    }
	}
}

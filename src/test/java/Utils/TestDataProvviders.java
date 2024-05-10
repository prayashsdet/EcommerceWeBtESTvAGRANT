package Utils;

import org.testng.annotations.DataProvider;

public class TestDataProvviders {
	 @DataProvider(name = "cartData")
	    public static Object[][] cartData() {
	        String excelFilePath = System.getProperty("user.dir") + "/src/test/resources/TestData/Ecommerce.xlsx";
	        String sheetName = "Sheet1"; // Change to the actual sheet name in your Excel file
	        return ExcelReader.getTestData(excelFilePath, sheetName);
	    }
}

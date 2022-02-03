package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private XSSFWorkbook workBook;
	private XSSFSheet sheet;
	private HSSFWorkbook oldWorkBook;
	private HSSFSheet oldSheet;
	private InputStream input;

	public ExcelUtils(String excelPath, String sheetName) {
		try {
			input = new FileInputStream(excelPath);
			//oldWorkBook = new HSSFWorkbook(new POIFSFileSystem(input));
			//oldSheet = oldWorkBook.getSheet(sheetName);

			workBook = new XSSFWorkbook(excelPath);
			sheet = workBook.getSheet(sheetName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

	public void getRowCount() {
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("Row count: " + rowCount);
	}

	public void getCellData(int rowNum, int columnNum) {
		DataFormatter formatter = new DataFormatter();
		Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(columnNum));

		System.out.println("value: " + value);

	}

	public void getRowCount_XLS() {

		int rowCount = oldSheet.getPhysicalNumberOfRows();
		System.out.println("Row count: " + rowCount);

	}

	public void getCellData_XLS(int rowNum, int columnNum) {

		DataFormatter formatter = new DataFormatter();
		Object value = formatter.formatCellValue(oldSheet.getRow(rowNum).getCell(columnNum));

		System.out.println("value: " + value);

	}
}

package testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "userDetails")
	public String[][] getDataFromExcel() throws IOException
	{
		String path = "C:\\Users\\durgesh.kumar\\Documents\\Durgesh Kumar\\Neqqo BGO\\PHI\\TestDataCreds_PHI.xlsx";
		FileInputStream fis = new FileInputStream(path);
		
		try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator(); 
			
			Row firstRow = rows.next();
			
			int rowCount = sheet.getLastRowNum();
			
			String arr[][] = new String[rowCount][4];
			
			 int rowNum =0;
			
			while(rows.hasNext())
			{
				Row row = rows.next();
				
				Iterator<Cell> cells = row.cellIterator();
				int col=0;
				while(cells.hasNext())
				{
					Cell cell = cells.next();
					String cv = cell.getStringCellValue();
					arr[rowNum][col] = cv;
					col++;
				}
				rowNum++;
				
			}
			
			return arr;
		}
		
	}

}

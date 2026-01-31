package abstractComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetDataFromExcelUtility {
	
	public static String[] getData(String testCase) throws IOException
	{
		String path = "C:\\Users\\durgesh.kumar\\Documents\\Durgesh Kumar\\Neqqo India\\VM Business\\New Link Testing\\TestDataCreds_VmBusiness.xlsx";
		FileInputStream fis = new FileInputStream(path);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rows = sheet.iterator(); 
		
		Row firstRow = rows.next();
		Iterator<Cell> fCells = firstRow.cellIterator();
		
		int userNameCol = 0;
		int PasswordCol = 0;
		int testCaseCol = 0;
		while(fCells.hasNext())
		{
			Cell cl = fCells.next();
			if(cl.getStringCellValue().equals("UserName"))
			{
				userNameCol = cl.getColumnIndex();
			}
			if(cl.getStringCellValue().equals("Password"))
			{
				PasswordCol = cl.getColumnIndex();
			}
			if(cl.getStringCellValue().equals("TestCase"))
			{
				testCaseCol = cl.getColumnIndex();
			}
		}
		
		int rowCount = sheet.getLastRowNum();
		
		String arr[] = new String[2];
		
		 int rowNum = 0;
		
		while(rows.hasNext())
		{
			Row row = rows.next();
			Cell cellTestCase = row.getCell(testCaseCol);
			String cvTestCase = cellTestCase.getStringCellValue();
			
			if(cvTestCase.equals(testCase))
			{
				Cell cellUser = row.getCell(userNameCol);
				String cvUser = cellUser.getStringCellValue();
				arr[0] = cvUser;
			
				Cell cellPass = row.getCell(PasswordCol);
				String cvPass = cellPass.getStringCellValue();
				arr[1] = cvPass;
				rowNum++;
			}
		}
		
		return arr;
		
	}
	
	

}

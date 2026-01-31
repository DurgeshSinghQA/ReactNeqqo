package testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetDataFromExcel {
	
	public static String[][] getData() throws IOException
	{
		String path = "C:\\Users\\durgesh.kumar\\Documents\\Durgesh Kumar\\Learning\\TestDataCreds_ExlonPHI.xlsx";
		FileInputStream fis = new FileInputStream(path);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rows = sheet.iterator(); 
		
		Row firstRow = rows.next();
		Iterator<Cell> fCells = firstRow.cellIterator();
		
		int userNameCol = 0;
		int PasswordCol = 0;
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
		}
		System.out.println(userNameCol+ "     "+ PasswordCol);
		int rowCount = sheet.getLastRowNum();
		
		String arr[][] = new String[rowCount][2];
		
		 int rowNum = 0;
		
		while(rows.hasNext())
		{
			Row row = rows.next();
			
				Cell cellUser = row.getCell(userNameCol);
				String cvUser = cellUser.getStringCellValue();
				arr[rowNum][0] = cvUser;
			
				Cell cellPass = row.getCell(PasswordCol);
				String cvPass = cellPass.getStringCellValue();
				arr[rowNum][1] = cvPass;
				rowNum++;
			
		}
		
		return arr;
		
	}
	
	public static void main(String[] args) throws IOException {
		
		String arr[][] = GetDataFromExcel.getData();
		
		System.out.println(Arrays.deepToString(arr));
		
	}
	public void writeData()
	{
		
	}

}

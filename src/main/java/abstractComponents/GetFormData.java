package abstractComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetFormData {
	
	public static List<String> getData(String path, String testCase) throws IOException
	{
		FileInputStream fis = new FileInputStream(path);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rows = sheet.iterator(); 
		
		Row firstRow = rows.next();
		Iterator<Cell> fCells = firstRow.cellIterator();
		
		int colNum=0;;
		while(fCells.hasNext())
		{
			Cell cl = fCells.next();
			if(cl.getStringCellValue().equals(testCase))
			{
				colNum = cl.getColumnIndex();
			}
		}
		
		List<String> columnValues = new ArrayList<>();
		 
		for(Row row : sheet )
		{
				Cell cell = row.getCell(colNum);
				
				if(cell!=null && cell.getRowIndex()!=0 && !cell.getStringCellValue().isEmpty())
				{
					columnValues.add(cell.getStringCellValue());
				}
				
			
			
			// 
		}
		
		workbook.close();
		
		return columnValues;
	}

}

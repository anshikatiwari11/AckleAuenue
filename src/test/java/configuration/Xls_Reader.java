package configuration;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls_Reader {
	
	String path;
	
	public Xls_Reader(String path)
	{
		this.path=path;
	}
	
	public String getCellData(String sheetName, int rowNum, int colNum) throws IOException
	{
		
		FileInputStream file= new FileInputStream(path);
		
		XSSFWorkbook wb= new XSSFWorkbook(file); //Workbook		
		
		XSSFSheet sheet=wb.getSheet(sheetName); //Sheet
		
		XSSFRow row=sheet.getRow(rowNum);
		
		XSSFCell cell=row.getCell(colNum);
		
		String data=cell.getStringCellValue();
		
		wb.close();
		return data;
		
	}

}

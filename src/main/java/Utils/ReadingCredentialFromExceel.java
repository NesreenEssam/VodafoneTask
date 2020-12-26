package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingCredentialFromExceel {
	
WebDriver browserobject;
	
	public ReadingCredentialFromExceel(WebDriver browserobject)
	{
		this.browserobject= browserobject;
	}
	
	public String ReadingData(int row ,int col) throws IOException
	{
		
		 File src=new File("ValidCredentials.xlsx");
	     FileInputStream fis= new FileInputStream(src);

	   
	     XSSFWorkbook wb = new XSSFWorkbook(fis);
	     XSSFSheet sh1= wb.getSheetAt(0);
	     
	     DataFormatter formatter = new DataFormatter();
	     String val = formatter.formatCellValue(sh1.getRow(row).getCell(col));
	   
	     return val;
	     
	    
	     
	      
	}


}

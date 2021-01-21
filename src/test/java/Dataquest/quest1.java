package Dataquest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class quest1 {

	public static void main(String[] args) throws IOException {
		File file = new File(
				"E:\\Software\\eclipse-java-photon-R-win32-x86_64\\eclipse\\deva\\Datadriven\\XL sheets\\Class.xlsx");
		FileInputStream fin = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fin);
		Sheet sheet = w.getSheet("Sheet1");
		// no of rows& cells
int NumberOfRows = sheet.getPhysicalNumberOfRows();
System.out.println("no of Rows:"+NumberOfRows);
Row row1 = sheet.getRow(0);
int physicalNumberOfCells = row1.getPhysicalNumberOfCells();
System.out.println("no of cells:"+physicalNumberOfCells);

//printing all data on console

		for(int i=0;i<sheet.getPhysicalNumberOfRows();i++)
		{
			Row row = sheet.getRow(i);
			for(int j=0;j<row.getPhysicalNumberOfCells();j++)
			{
				Cell cell = row.getCell(j);
				System.out.println(cell);
			}
		}
		
		//writing a row
		Row newRow = sheet.createRow(10);
		Cell newCell = newRow.createCell(0);
		newCell.setCellValue("mary");
		Cell secCell = newRow.createCell(1);
		secCell.setCellValue("OS");
		
		FileOutputStream fos=new FileOutputStream(file);
		w.write(fos);
		System.out.println("done");
		
	}

}


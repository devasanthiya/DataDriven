package Dataquest;

//package adactinBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class quest6Basic {
	public static ChromeDriver driver;

	// 1.launching
	public static void launch() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	// 2.Maximizing
	public static void max() {
		driver.manage().window().maximize();

	}// 3.URL

	public static void url(String url1) {
		driver.get(url1);

	}

	// 4.Send value
	public static void filling(WebElement pass, String data) {
		pass.sendKeys(data);
	}

	// 5.click
	public static void pressing(WebElement press) {
		press.click();
	}

	// 6.data fetching from XL
	public static String data(String excel, String val, int rowNo, int cellNo) throws IOException {
		File file1 = new File(excel);
		FileInputStream fin = new FileInputStream(file1);
		Workbook w = new XSSFWorkbook(fin);
		// particular sheet
		Sheet sheet1 = w.getSheet(val);// login
		Row row = sheet1.getRow(rowNo);

		// particular cell from row
		Cell cell = row.getCell(cellNo);

		int cellType = cell.getCellType();
		String value = "";
		if (cellType == 1) {
			value = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date d = cell.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat("dd/mm/yyyy");
			value = s.format(d);
		} else {
			double dd = cell.getNumericCellValue();
			long l = (long) dd;
			value = String.valueOf(l);
		}
		return value;
	}

	// 7.implicitwait
	public static void waiting() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	// 8.Drop-down-value
	public static void dropvalue(WebElement val, String value) {
		Select s = new Select(val);
		s.selectByValue(value);

	}

	// 9.Drop-down-byvisible
	public static void dropvisible(WebElement val, String str) {
		Select s = new Select(val);
		s.selectByVisibleText("str");
	}

	// 10.dropdown-by index
	public static void dropindex(WebElement val, int index1) {
		Select s = new Select(val);
		s.selectByIndex(index1);

	}
	// 11.getattribute

	public static void get(WebElement e, String name) {

		String attribute = e.getAttribute(name);
		System.out.println(attribute);
		// 12.update in excel
	}
}




package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static WebDriver driver;

	public static void openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static void launchurl(String url) {
		driver.get(url);
	}

	public static void closeBrowser() {
		driver.quit();
	}

	public static void applyImplicitwait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void maxWindow() {
		driver.manage().window().maximize();
	}

	public static void fillTextbox(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void btnClick(WebElement element) {
		element.click();
	}

	public static void pageTitle() {
		String t = driver.getTitle();
		System.out.println("Title : "+t);
	}

	public static void takeSnap(String picname) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("./picture"+picname+".png");
		FileUtils.copyDirectory(src, des);
	}

//	public static String readFromExcel(String sheetName, int rowNo, int cellNo) {
//		File f = new File("./excelInput");
//		FileInputStream fin = new FileInputStream(f);
//		Workbook b = new XSSFWorkbook(fin);
//		Sheet sh = b.getSheet(sheetName);
//		Row r = sh.getRow(rowNo);
//		Cell c = r.getCell(cellNo);
//
//		int type = c.getCellType();
//		String data = "";
//		if(type == 1) {
//			data = c.getStringCellValue();
//		}
//		else if(DateUtil.isCellDateFormatted(c)) {
//			Date date = c.getDateCellValue();
//			SimpleDateFormat sim = new SimpleDateFormat();
//			data = sim.format(date);
//		}
//		else {
//			double d = c.getNumericCellValue();
//			long l = (long) d;
//			data = String.valueOf(l);
//		}
//		return data;
//	}
	
}

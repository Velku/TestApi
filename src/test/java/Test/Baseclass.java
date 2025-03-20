package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Baseclass {
	
	public static WebDriver driver;
	//public static ExtentTest test1;
	public static ExtentTest test;
	//public static ExtentTest test2;
	public static ExtentReports report;
	public static ExtentSparkReporter reporter;
	

	@BeforeSuite
	public static void setup() {
		driver = new ChromeDriver();
		
		reporter = new ExtentSparkReporter (new File(System.getProperty("user.dir")+"/Report/Rote.Html"));
		report = new ExtentReports();
		report.attachReporter(reporter);
		}
	
	
	
	
	public void max() {
		driver.manage().window().maximize();
	}
	
	public void frame() {
		driver.switchTo().frame(0);
	}
	
    public void waits() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("ui-datepicker-div")));
		}
    
    public void alert() {
    	Alert find = driver.switchTo().alert();
	    find.accept();
    }
   
    public void prombtalert1() throws InterruptedException {
    	Alert find1 = driver.switchTo().alert();
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    find1.sendKeys("Good");
	    find1.accept();
    }
    
    public void excelwrite(int sheetnum,int row,int cell,String cellvalue) throws IOException, InvalidFormatException {
		File data = new File("C:\\Users\\vpalanisamy2\\Downloads\\Untitled spreadsheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(data);
		XSSFSheet sheet = workbook.getSheetAt(sheetnum);
		sheet.getRow(row).createCell(cell).setCellValue(cellvalue);
		FileOutputStream write = new FileOutputStream(data);
		workbook.write(write);
		write.close();
		workbook.close();
    
    }
   public void excelread(int sheetnum,int row,int cell) throws IOException {
		
		File data = new File("C:\\Users\\vpalanisamy2\\Downloads\\Untitled spreadsheet.xlsx");
		FileInputStream read = new FileInputStream(data);
		XSSFWorkbook workbook = new XSSFWorkbook(read);
		XSSFSheet sheet = workbook.getSheetAt(sheetnum);
		String value = sheet.getRow(row).getCell(cell).getStringCellValue();
		System.out.print(value);
		workbook.close();

}
    
    
    
	
	public static String screen() {
		
		File sourcefile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
		File obj = new File(path);
		try {
			FileUtils.copyFile(sourcefile,obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
		}
	
	

	
	@AfterTest
	public void tearnew() {
		report.flush();
	
	}
	
	@AfterSuite
	public void tear() {
		
		
		driver.quit();
	}
	}

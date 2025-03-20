package Test;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


@Listeners(Listener.class)
public class Datepickernew extends Baseclass {
	
	@Test(groups= {"Datepicker"}) 
	public void Testcase2() {
		
		
		test = report.createTest("DatepickerTest2");
		String Year1 = "2025";
		String date ="20";
		String month="July";
		driver.get("https://jqueryui.com/datepicker/");
		max();
		frame();
		Assert.assertTrue(driver.findElement(By.id("datepicker")).isDisplayed());
		try {
			driver.findElement(By.id("datepicker")).click();
		} catch (NoSuchElementException e) {
			System.out.print("Unable to locate the element");
			e.printStackTrace();
		}
		waits();
		while(true) {
		String month1 = driver.findElement(By.className("ui-datepicker-month")).getText();
		String year = driver.findElement(By.className("ui-datepicker-year")).getText();
		
		if(month1.equals
				(month) && year.equals(Year1)) {
			break;
		}
        else if(Integer.parseInt(Year1)<2023){
        	WebElement obj = driver.findElement(By.xpath("//span[text()=\"Prev\"]"));
        	obj.click();
		}
		
		else {
			driver.findElement(By.xpath("//a[@title=\"Next\"]")).click();
		}
		
		}
		driver.findElement(By.xpath("//a[text()="+date+"]")).click();
		
		String value = driver.findElement(By.id("datepicker")).getAttribute("value");
        System.out.print(value);
        
       
	}
	
	
	@Test(groups= {"Datepicker"}) 
	public void Testcase3() {
		
		
		test = report.createTest("DatepickerTest3");
		Date obj1 = new Date();
		Calendar  jc = Calendar.getInstance();
		jc.setTime(obj1);
		
		jc.add(jc.YEAR,-1 );
		jc.add(jc.MONTH,-1);
		jc.add(jc.DAY_OF_MONTH,-1);
		Date expec = jc.getTime();
		
		DateFormat format = new SimpleDateFormat("dd/MM/YYYY");
		String target = format.format(expec);
		
		driver.get("https://jqueryui.com/datepicker/");
		frame();
		
		WebElement ele = driver.findElement(By.xpath("//input[@id=\"datepicker\"]"));
         ele.sendKeys(target);
         String value = driver.findElement(By.id("datepicker")).getAttribute("value");
         System.out.print(value);
         Assert.assertEquals(target, value);
         
        
       
         
         
		}
	
	
@Test(groups= {"Datepicker"}) 
public void testcase1() {
	
	    test = report.createTest("DatepickerTest1");
		driver.get("https://jqueryui.com/datepicker/");
		max();
		frame();
		
		Assert.assertTrue(driver.findElement(By.id("datepicker")).isDisplayed());
		try {
			driver.findElement(By.id("datepicker")).click();
		} catch (NoSuchElementException e) {
			System.out.print("Unable to locate the element");
			e.printStackTrace();
		}
		waits();
		Scanner js = new Scanner(System.in);
		String datemonthyear = js.next();
		String date1=datemonthyear.split("/")[0].trim();
		String month=datemonthyear.split("/")[1].trim();
		String Year2=datemonthyear.split("/")[2].trim();
		
		while (true) {
			String month1 = driver.findElement(By.className("ui-datepicker-month")).getText();
			String year = driver.findElement(By.className("ui-datepicker-year")).getText();

			if (month1.equals(month) && year.equals(Year2)) {
				break;
			} else if (Integer.parseInt(Year2) < 2023) {
				WebElement obj = driver.findElement(By.xpath("//span[text()=\"Prev\"]"));
				obj.click();
			}

			else {
				driver.findElement(By.xpath("//a[@title=\"Next\"]")).click();
			}
       }
		driver.findElement(By.xpath("//a[text()=" + date1 + "]")).click();
		String title = driver.findElement(By.className("ui-datepicker-month")).getText();
		String title2 = driver.findElement(By.className("ui-datepicker-year")).getText();
		String value = driver.findElement(By.id("datepicker")).getAttribute("value");
        System.out.print(value);
		Assert.assertTrue(title.contains(month) && title2.contains(Year2));
		
	}


}

package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class webtable extends Baseclass {
	
	@Test(groups= {"Webtable"}) 
	public void webtable() {
		
		test = report.createTest("WebtableTest1");
		//WebDriver driver = new ChromeDriver();
		driver.get("http://omayo.blogspot.com/");
		List<WebElement> ele =  driver.findElements(By.xpath("//table[@id=\"table1\"]//td[text()=\"Kishore\"]//parent::tr"));
		for(WebElement data : ele) {
			
			String all = data.getText();
			System.out.print("\t"+all+"\t");
		}
		
	}
	
	@Test(groups= {"Webtable"}) 
	public void webtable1() {
		
		test = report.createTest("WebtableTest1");
		//WebDriver driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/dynamic-table");
		List<WebElement> ele1 = driver.findElements(By.xpath("//div[@class=\"col-md-6\"]//tr"));
		List<WebElement> ele2 = driver.findElements(By.xpath("//div[@class=\"col-md-6\"]//td"));
		System.out.print("Row size is"+" "+ele1.size()+"\t");
		System.out.print("coloumn size is"+" "+ele2.size()+"\t");
		for(WebElement data1 : ele1) {
			String words = data1.getText();
			if(words.contains("Chrome")) {
				System.out.print(words);
				break;
			}
		}
		
	}

}

package Test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class alerts extends Baseclass {

	@Test
	public void alerts() {
		
		driver.get("http://omayo.blogspot.com/");
		max();
	    driver.findElement(By.id("alert1")).click();
	    alert();
	}
	
	@Test
	public void prombtalert() throws InterruptedException {
		
		driver.get("http://omayo.blogspot.com/");
		max();
	    driver.findElement(By.id("prompt")).click();
	    prombtalert1();
	}
	
  @Test	
  public void confirmalert() {
		
		driver.get("http://omayo.blogspot.com/");
		max();
	    driver.findElement(By.id("confirm")).click();
	    alert();
	}
	
	
}

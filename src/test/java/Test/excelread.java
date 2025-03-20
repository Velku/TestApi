package Test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

public class excelread extends Baseclass {
	
	@Test(groups= {"Excel"}) 
	public void Excelwrite1() throws InvalidFormatException, IOException {
		test = report.createTest("ExcelTest1");
		excelwrite(0, 3, 5, "GoodTime");
		
	}
	
	@Test(groups= {"Excel"}) 
	public void read1() throws IOException {
		test = report.createTest("ExcelTest1");
		excelread(0, 1, 1);
	}

}

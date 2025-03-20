package Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.annotations.Test;

public class pdfread extends Baseclass{
	
	@Test(groups= {"PDF"}) 
	public void PDFread1() throws IOException {
		
		test = report.createTest("PDFTest1");
		String pdfurl = "https://file-examples.com/storage/feaade38c1651bd01984236/2017/10/file-sample_150kB.pdf";
		
		URL conn = new URL(pdfurl);
		InputStream openStream = conn.openStream();
		BufferedInputStream buf = new BufferedInputStream(openStream);
		PDDocument data = PDDocument.load(buf);
		System.out.print(data.getNumberOfPages());
		String pdfContent=new PDFTextStripper().getText(data);
		if(pdfContent.contains("Lorem ipsum dolor sit amet,")) {
			System.out.print("Data is present");
		}else {
			System.out.print("Data is not present");
		
		}
		System.out.print(pdfContent);
		data.close();
	}
	
	@Test(groups= {"PDF"}) 
	public void PDFread2() throws IOException {
		
		test = report.createTest("PDFTest2");
		File source = new File("C:\\Users\\vpalanisamy2\\Downloads\\ISTQB-CTFL_Syllabus_2018.pdf");
		FileInputStream read = new FileInputStream(source);
		PDDocument data = PDDocument.load(read);
		
		PDFTextStripper text = new PDFTextStripper();
		text.setStartPage(1);
		text.setEndPage(3);
		String page = text.getText(data);
		System.out.print(page+data.getNumberOfPages()+"Pages"+"      ");
		data.close();
		
	}

}

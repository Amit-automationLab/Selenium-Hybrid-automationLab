package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICILTY_WAIT=10;
	static String TESTDATA_SHEET_PATH="/Users/AmSu/workspace/FreeCRMTest/src"
			+ "/main/java/com/crm/qa/testdata/FreeCRMTest.xlsx";

	static Workbook book;
	static Sheet sheet;
	//static FileUtils FileUtils;
	
	
	public static Object[][] getTestData(String sheetName){
		FileInputStream file=null;
		try 
		{
			file=new FileInputStream(TESTDATA_SHEET_PATH);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		try {
			book=WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		//R3*C2
		//System.out.println(sheet.getRow(0).getLastCellNum());
		for(int i=0;i<sheet.getLastRowNum();i++){
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++){
				//String ht=sheet.getRow(1).getCell(0).toString();
				//System.out.println(ht);
				data[i][k]=sheet.getRow(i + 1).getCell(k).toString();
				//System.out.println(data[i][k]);

			}
		}
		return data;
	}
	
	/*public static void main(String[] args){
		//TestUtil.getTestData("Contacts");
		System.out.println(TestUtil.getTestData("Contacts"));
	}*/
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir =System.getProperty("user.dir");//"/Users/AmSu/workspace/FreeCRMTest/";//
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}

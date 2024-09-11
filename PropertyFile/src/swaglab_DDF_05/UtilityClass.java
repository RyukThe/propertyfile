package swaglab_DDF_05;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass
{
	
	//used to fetch data from excel sheet
	//need two input : 1. rowIndex, 2. cellIndex
	//@Author: Saurav
	public static String getData(int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("F:\\Excel\\Book1.xlsx");
		String result = WorkbookFactory.create(file).getSheet("Sheet5").getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return result;
	}
	
	
	//used take screenshot of WebPage
	//need two input : WebDriver Obejct, TCID
	//@Author name: Saurav
	public static void captureScreenShot(WebDriver m,int TCID) throws IOException
	{
		File src = ((TakesScreenshot)m).getScreenshotAs(OutputType.FILE);
		File dec=new File("F:\\ScreenShotsel\\TCID"+TCID+".png");
		FileHandler.copy(src, dec);
		
	}
	
	//used to fetch data from property file 
	// need one input : String Key
	//@Author name: Saurav
	public static String getPropertyFileData(String Key) throws IOException
	{
		FileInputStream m = new FileInputStream("D:\\eclipse\\PropertyFile\\SwagLab5.properties");
		
		Properties p = new Properties();
		p.load(m);
		
		String value = p.getProperty(Key);
		return value;
		
	}

}

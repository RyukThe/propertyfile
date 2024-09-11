package swaglab_DDF_07;

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
	// need two inputs : 1. rowIndex, 2. cellIndex
	//@Author name:Saurav
	public static String getData(int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("F:\\Excel\\Book1.xlsx");
		String result = WorkbookFactory.create(file).getSheet("sheet5").getRow(rowIndex).getCell(cellIndex).getStringCellValue();
	
		return result;
	}
	
	//used to take ScreenShot of WebPage
	//need two input :1. WebDriver Obejct,2. TCID
	//@Author name:Saurav
	public static void captureSceenshot(WebDriver driver,int TCID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dec= new File("F:\\ScreenShotsel\\TCID"+TCID+".jpg");
		
		FileHandler.copy(src, dec);
	}
	
	
	//used to fetch data from Property File
	//need one input : String Key
	//@Author name:Saurav
	public static String getDataFromPropFile(String Key) throws IOException
	{
		FileInputStream file = new FileInputStream("D:\\eclipse\\PropertyFile\\SwagLab6.properties");
		
		Properties m= new Properties();
		m.load(file);
		String Value = m.getProperty(Key);
		return Value;
	}

}

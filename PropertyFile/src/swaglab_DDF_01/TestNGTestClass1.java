package swaglab_DDF_01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTestClass1 
{
	int a;// declare globally 
	
	Sheet sh;
	WebDriver m;
	swagLabLoginPage login; // datatype objectname
	swagLabHomePage home;
	SwagLabOpneMenuPage menu;
	@BeforeClass
	public void OpenBrowser() throws EncryptedDocumentException, IOException
	{
		 FileInputStream file= new FileInputStream("F:\\Excel\\Book1.xlsx");
		 sh = WorkbookFactory.create(file).getSheet("Sheet5");
		 System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
		 m= new ChromeDriver();
		 m.manage().window().maximize();
		 m.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 
		 m.get("https://www.saucedemo.com/");
		 
		 login= new swagLabLoginPage(m);
		 home= new swagLabHomePage(m);
		 menu= new SwagLabOpneMenuPage(m);
		 a=15;
		 
	}
	@BeforeMethod
	public void logininApp() throws InterruptedException
	{
		login.inpswagLabLoginPageUsername(sh.getRow(0).getCell(0).getStringCellValue());
		login.inpswagLabLoginPagepassword(sh.getRow(0).getCell(1).getStringCellValue());
		login.clickswagLabLoginPageLoginbutton();
		Thread.sleep(2000);
	}
	@Test
	public void verifylogo() throws InterruptedException
	{
		boolean actResult = home.getSwagLabHomePageLogo();
		Assert.assertTrue(actResult,"failed: get false test case is failed ");
		
	}
	
	@AfterMethod
	public void logoutfromApp() throws InterruptedException
	{
		home.clickswagLabHomePageOpenmenu();
		menu.clickswagLabMenuPageLogoutbutn();
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void closeBrowser()
	{
		m.close();
	}

}

package swaglab_DDF_02;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class SwagLabTest_02
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException 
	{
		FileInputStream file = new  FileInputStream("F:\\Excel\\Book1.xlsx");
		
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet5");
		
		WebDriver m= new ChromeDriver();
		m.get("https://www.saucedemo.com/");
		
		m.manage().window().maximize();
		m.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		SwagLabLoginPage lgn= new SwagLabLoginPage(m);
		lgn.inpSwagLabLoginPageUserName(sh.getRow(0).getCell(0).getStringCellValue());
		lgn.inpSwagLabLoginPagePassword(sh.getRow(0).getCell(1).getStringCellValue());
		lgn.clickSwagLabLoginPageLoginBtn();
		
		
		 Thread.sleep(2000);
		 
		 SwagLabHomePage hm= new SwagLabHomePage(m);
		 
		 //hm.verifySwagLabHomePageLogo();
		 hm.clickSwagLabHomePageADDtoCartButn();
		 Thread.sleep(200);
		// hm.verifySwagLabHomePageRemoveButn(sh.getRow(2).getCell(0).getStringCellValue());
		 Thread.sleep(2000);
		 hm.clickSwagLabHomePageOpenMenuopt();
		 
		 
		 Thread.sleep(2000);
		 
		 SwagLabOpenMenuPage Om= new SwagLabOpenMenuPage(m);
		 Om.clickSwagLabOpenMenuPageLogout();
		 Thread.sleep(2000);
		 
		 m.close();		 
		 
		
	}

}

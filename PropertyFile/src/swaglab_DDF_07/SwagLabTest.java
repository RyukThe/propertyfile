package swaglab_DDF_07;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabTest 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException
	{
		FileInputStream file = new FileInputStream("F:\\Excel\\Book1.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet5");
		
		WebDriver n= new  ChromeDriver();
		n.navigate().to("https://www.saucedemo.com/");
		n.manage().window().maximize();
		n.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		SwagLabLoginPage lon= new SwagLabLoginPage(n);
		lon.inpSwagLabLoginPageusername(sh.getRow(0).getCell(0).getStringCellValue());
		lon.inpSwagLabLoginPagepassword(sh.getRow(0).getCell(1).getStringCellValue());
		lon.ScreenshotSwagLabLoginPageLogo();
		lon.clickSwagLabLoginLoginbtn();
		
		 Thread.sleep(2000);
		 
		 SwagLabHomePage hm= new SwagLabHomePage(n);
		 hm.verifySwagLabHomePageLogo();
		 hm.clickSawgLabHomeAddToCART();
		// hm.verifySwagLabHomeRemove(sh.getRow(2).getCell(0).getStringCellValue());
		 hm.SelectSwagLabHomeA_z();
		 hm.clickSwagLabHomePagCart();
		 Thread.sleep(2000);
		
		 SawgLabCartPage cart= new SawgLabCartPage(n);
		 //cart.verifySwabLabCartPageTitle(sh.getRow(3).getCell(0).getStringCellValue());
		 Thread.sleep(2000);
		 cart.clickSwagLabCartPageCheckOUT();
		 
		 
		 Thread.sleep(2000);
		 
		 SwagLabCheckOutPage ch= new SwagLabCheckOutPage(n);
		// ch.VerifySwagLabCheKOutPageTitle(sh.getRow(4).getCell(0).getStringCellValue());
		 ch.clickSwagLabChekOutContinueButn();
		// ch.verifySwagLabCheKOutErrorOnSumbitButn(sh.getRow(5).getCell(0).getStringCellValue());
		 
		 ch.ScreenShootSwagLAbChekOutNOValueEnetr(sh.getRow(6).getCell(0).getStringCellValue());
		 n.navigate().back();
		 Thread.sleep(2000);
		 n.navigate().back();
		 Thread.sleep(2000);
		  
		  
		 hm.clickSwagLabHomPageOpenMenu();
		 
	
		
		 Thread.sleep(2000);
		 
		 SwagLabOpenMenuPage opn= new SwagLabOpenMenuPage(n);
		 opn.clickSawgLabOpenmenuLogout();
		 
		 Thread.sleep(2000);
		 
		 n.close();
		
		
	}

}

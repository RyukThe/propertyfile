package swaglab_DDF_01;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwagLAbTest_Base_And_Utility extends BaseClass
{
	swagLabLoginPage login; // datatype objectname
	swagLabHomePage home;
	SwagLabOpneMenuPage menu;
	int TCID;

	
	@BeforeClass
	public void OpenBrowser() throws EncryptedDocumentException, IOException
	{
		
			initializeBrowser();
		 login= new swagLabLoginPage(m);
		 home= new swagLabHomePage(m);
		 menu= new SwagLabOpneMenuPage(m);
		
		 
	}
	@BeforeMethod
	public void logininApp() throws InterruptedException, EncryptedDocumentException, IOException
	{
		login.inpswagLabLoginPageUsername(Utility_Class.getPropertyFileData("username"));
		login.inpswagLabLoginPagepassword(Utility_Class.getPropertyFileData("password"));
		login.clickswagLabLoginPageLoginbutton();
		Thread.sleep(2000);
	}
	@Test
	public void verifylogo() throws InterruptedException
	{
		TCID=101;
		home.clickswagLabHomePageAddtocart();
		boolean actResult = home.getSwagLabHomePageLogo();
		Assert.assertTrue(actResult,"failed: get false test case is failed ");
		
	}
	
	@AfterMethod
	public void logoutfromApp(ITestResult s1) throws InterruptedException, IOException
	{
		
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			Utility_Class.captureScreenShoot(m, TCID);
		}
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

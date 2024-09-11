package swaglab_DDF_02;

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



public class TestNG2 extends BaseClass
{
	
	SwagLabLoginPage login;
	SwagLabHomePage home;
	SwagLabOpenMenuPage menu;
	
	@BeforeClass
	public void OpenBroswer() throws EncryptedDocumentException, IOException
	{
		
		OpenBRowser();

		
		login= new SwagLabLoginPage(m);
		home= new SwagLabHomePage(m);
		menu= new SwagLabOpenMenuPage(m);
		
		
	}
	@BeforeMethod
	public void sawglablogin() throws InterruptedException, EncryptedDocumentException, IOException
	{
		login.inpSwagLabLoginPageUserName(UtilityClass.getPropertyFileData("username"));
		login.inpSwagLabLoginPagePassword(UtilityClass.getPropertyFileData("password"));
		login.clickSwagLabLoginPageLoginBtn();
		Thread.sleep(2000);
	}
	@Test
	public void verifylogo() throws InterruptedException
	{
		boolean result = home.getSwaglabHomelogo();
		Assert.assertTrue(result);
		Thread.sleep(2000);
		
	}
	
	@Test(priority = 1)
	public void verifyRemovebutton() throws InterruptedException, EncryptedDocumentException, IOException
	{
		home.clickSwagLabHomePageADDtoCartButn();
		String actREs = home.getswaglabhomepageremovebutton();
		Assert.assertEquals(actREs, UtilityClass.getData(2, 0),"Fail: both result is not mathcing ");
	
		Thread.sleep(2000);
	}
	@AfterMethod
	public void logoutFromApp() throws InterruptedException
	{
		home.clickSwagLabHomePageOpenMenuopt();
		menu.clickSwagLabOpenMenuPageLogout();
		Thread.sleep(2000);
		
	}
	
	@AfterClass()
	public void closeBrowser()
	{
		m.close();
	}
}

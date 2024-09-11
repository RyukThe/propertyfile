package swaglab_DDF_07;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage 
{
	@FindBy(xpath="//input[@id='user-name']") private WebElement un;
	@FindBy(xpath="//input[@id='password']") private WebElement pass;
	@FindBy (xpath="//input[@id='login-button']") private WebElement login;
	@FindBy(xpath="//div[@class='login_wrapper-inner']") private WebElement logosrc;
	
	public SwagLabLoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void inpSwagLabLoginPageusername(String user)
	{
		un.sendKeys(user);
	}
	
	public void inpSwagLabLoginPagepassword(String pass) 
	{
		this.pass.sendKeys(pass);
		
	}
	
	
	public void ScreenshotSwagLabLoginPageLogo() throws IOException
	{
		File src = logosrc.getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(src, new File("F:\\Excel\\scr.jpg"));
	}
	public void clickSwagLabLoginLoginbtn()
	{
		login.click();
	}

}

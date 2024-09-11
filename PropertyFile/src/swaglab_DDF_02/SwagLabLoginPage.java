package swaglab_DDF_02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage
{
	@FindBy(xpath= "//input[@id='user-name']") private WebElement UN;
	@FindBy(xpath="//input[@id='password']")private WebElement pas;
	@FindBy(xpath="//input[@id='login-button']")private WebElement login;
	
	
	public SwagLabLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void inpSwagLabLoginPageUserName(String user)
	{
		UN.sendKeys(user);
	}
	
	public void inpSwagLabLoginPagePassword(String Pass)
	{
		pas.sendKeys(Pass);
	}
	
	public void clickSwagLabLoginPageLoginBtn()
	{
		login.click();
	}

}

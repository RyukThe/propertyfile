package swaglab_DDF_02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabHomePage 
{
	@FindBy(xpath="//div[@class='app_logo']") private WebElement logo;
	@FindBy(xpath="(//button[text()='Add to cart'])[1]") private WebElement ADD2cart;
	@FindBy(xpath= "(//button[text()='Remove'])[1]") private WebElement Remove;
	@FindBy(xpath="//button[text()='Open Menu']") private WebElement menu;
	
	
	public SwagLabHomePage(WebDriver driver) 
	{
	
		PageFactory.initElements(driver, this);
	}
	
	public boolean getSwaglabHomelogo()
	{
		boolean result = logo.isDisplayed();
		return result;
	}
	
//	public void verifySwagLabHomePageLogo()
//	{
//		boolean log = logo.isDisplayed();
//		if(log==true)
//		{
//			System.out.println("logo is present: pass");
//		}
//		else
//		{
//			System.out.println("logo is not present :Fail");
//		}
//	}
	
	
	public void clickSwagLabHomePageADDtoCartButn()
	{
		ADD2cart.click();
	}
	
	public String getswaglabhomepageremovebutton()
	{
		String actText = Remove.getText();
		return actText;
	}

//	public void verifySwagLabHomePageRemoveButn(String expTxt)
//	{
//		String actTxt = Remove.getText();
//		
//		if(expTxt.equals(actTxt))
//		{
//			System.out.println("Test Pass");
//		}
//		else
//		{
//			System.out.println("Test Fail");
//		}
//	}

	public void clickSwagLabHomePageOpenMenuopt()
	{
		menu.click();
	}
	
}


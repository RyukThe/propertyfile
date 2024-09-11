package swaglab_DDF_03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabHomePage
{
	@FindBy (xpath="//div[@class='app_logo']") private WebElement logo;
	
	@FindBy(xpath="(//button[text()='Add to cart'])[1]") private WebElement addcart;
	@FindBy(xpath="(//button[text()='Remove'])[1]") private WebElement remove;
	@FindBy(xpath="//button[text()='Open Menu']") private WebElement openmenu;
	
	public SwagLabHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean  getSwagLabHomePageLogo()
	{
		boolean logo1 = logo.isDisplayed();
		return logo1;
	}
	
	
	public void clickSawgLabHomeAddToCART()
	{
		addcart.click();
	}
	
	public String verifySwagLabHomeRemove()
	
	{
		
		String actTxt = remove.getText();
		
		return actTxt;
	}
	
	public void clickSwagLabHomPageOpenMenu()
	{
		openmenu.click();
	}
}

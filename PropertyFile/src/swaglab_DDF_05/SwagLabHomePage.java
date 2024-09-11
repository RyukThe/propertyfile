package swaglab_DDF_05;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SwagLabHomePage
{
	@FindBy (xpath="//div[@class='app_logo']") private WebElement logo;
	
	@FindBy(xpath="(//button[text()='Add to cart'])[1]") private WebElement addcart;
	@FindBy(xpath="(//button[text()='Remove'])[1]") private WebElement remove;
	@FindBy(xpath="//button[text()='Open Menu']") private WebElement openmenu;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement A_z;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement Cart;
	
	public SwagLabHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean  verifySwagLabHomePageLogo()
	{
		boolean logoa = logo.isDisplayed();
		return logoa;
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
	
	public boolean SelectSwagLabHomeA_z() 
	{
		Select sd = new Select(A_z);
		sd.selectByIndex(2);
		boolean listbox = sd.isMultiple();
		
		return	listbox;
		
	}
	
	public void clickSwagLabHomePagCart()
	
	{
		Cart.click();
	}
}

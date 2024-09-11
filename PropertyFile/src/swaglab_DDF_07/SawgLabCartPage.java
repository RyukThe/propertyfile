package swaglab_DDF_07;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SawgLabCartPage
{
	@FindBy(xpath="//span[@class='title']") private WebElement title;
	@FindBy (xpath="//button[@id='checkout']") private WebElement checkout;
	public SawgLabCartPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifySwabLabCartPageTitle()
	{
		String act = title.getText();
		return act;
	}
	
	
	public void clickSwagLabCartPageCheckOUT()
	{
		checkout.click();
	}
	

}

package swaglab_DDF_05;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SawgLabCartPage
{
	@FindBy(xpath="//span[@class='title']") private WebElement title;
	
	
	public SawgLabCartPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifySwabLabCartPageTitle()
	{
		String act = title.getText();
		return act;
	}

}

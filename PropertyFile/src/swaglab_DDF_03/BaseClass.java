package swaglab_DDF_03;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass 
{
	
	WebDriver m;
	public void openBroswer(String BrowserName) throws IOException
	{
		if(BrowserName.equals("chrome"))
		{
			m= new ChromeDriver();
			
		}
		else if (BrowserName.equals("edge"))
		{
			m= new EdgeDriver();
			
		}
		else if(BrowserName.equals("firefox"))
		{
			m= new FirefoxDriver();
		}
		
		
		m.manage().window().maximize();
		m.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		m.get(UtilityClass.getPropertyFileData("URL"));
		
		
	}

}

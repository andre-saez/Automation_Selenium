package basicweb;

import java.*;
import java.util.List;
import static org.junit.Assert.*;
//import java.awt.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WorkingWithElementsList 
	{
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception 
	{
	//	System.setProperty("webdriver.gecko.driver", "/Users/DesktopW7/Documents/Libs/geckodriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);		
	}

	@Test
	public void testlistOfElements()  throws Exception
	{	
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[contains(@type, 'radio')and contains(@name,'cars')]"));
		//List<WebElement> radioButtons = driver.findElements(By.name("cars"));
		boolean isChecked = false;
		int size = radioButtons.size();
		System.out.println("Size of the list: " + size);
		
		for(int i=0; i<size; i++) 
		{
			isChecked = radioButtons.get(i).isSelected();
			
			if(!isChecked) 
			{
				radioButtons.get(i).click();
				Thread.sleep(3000);
			}
		}	
	}
	
	@After
	public void tearDown() throws Exception 
	{
		Thread.sleep(2000);
		driver.quit();	
	}
}










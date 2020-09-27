package basicweb;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextDemo 
{	
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception 
	{
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	}

	@Test
	public void test() 
	{
		driver.get(baseUrl);
		WebElement buttonElement = driver.findElement(By.id("opentab"));
		String elementText = buttonElement.getText();
		//buttonElement.click();
		System.out.println("Text on the element is: " + elementText);
	}
	
	
	@After
	public void tearDown() throws Exception 
	{
		//driver.wait(10);
		driver.quit();
	}
}

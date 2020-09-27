package basicweb;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import basicweb.GenericMethods;

public class ElementListDemo {
	
	private WebDriver driver;
	private String baseUrl;
	private GenericMethods gm;

	@Before
	public void setUp() throws Exception 
	{
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		gm = new GenericMethods(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() 
	{
		driver.get(baseUrl);
		List<WebElement> elementList = gm.getElementList("//input[@type='text']", "xpath"); 
		int size = elementList.size();
		System.out.println("Size of the element list is: " + size);
	}
	
	@After
	public void tearDown() throws Exception 
	{
		Thread.sleep(2000);
		//driver.close();
	}
}

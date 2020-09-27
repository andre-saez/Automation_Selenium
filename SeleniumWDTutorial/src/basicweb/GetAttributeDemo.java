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

public class GetAttributeDemo 
{	
	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() throws Exception 
	{
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() 
	{
		driver.get(baseUrl);
		WebElement element = driver.findElement(By.id("name"));
		String attributeValue0 =  element.getAttribute("class");
		String attributeValue1 =  element.getAttribute("type");
		String attributeValue2 =  element.getAttribute("id");
		String attributeValue3 =  element.getAttribute("placeholder");
		System.out.println("Value of attribute is: " + attributeValue0);
		System.out.println("Value of attribute is: " + attributeValue1);
		System.out.println("Value of attribute is: " + attributeValue2);
		System.out.println("Value of attribute is: " + attributeValue3);
	}
	
	@After
	public void tearDown() throws Exception 
	{
		Thread.sleep(2000);
		driver.close();
	}
}

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

public class ElementState 
{
	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() throws Exception 
	{
		driver = new ChromeDriver();
		baseUrl = "https://www.google.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@Test
	public void test() 
	{
		WebElement e1 = driver.findElement(By.xpath("//input[@name='q']"));
		e1.sendKeys("letskodeit");
		System.out.println("Is E1 enabled? " + e1.isEnabled());
		driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']")).click();
	}
	
	@After
	public void tearDown() throws Exception 
	{
		Thread.sleep(3000);
		driver.quit();
	}

}

package basicweb;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingElementIntoView {
	
	private WebDriver driver;
	private JavascriptExecutor js;
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws Exception{
		js.executeScript("window.location = 'https://letskodeit.teachable.com/pages/practice'");
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,1900);");
		Thread.sleep(2000);
		
		
		js.executeScript("window.scrollBy(0,-1900);");
		Thread.sleep(2000);		
		
		WebElement element = driver.findElement(By.id("mousehover"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,-190);");
	}
	
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	
	}

	
}

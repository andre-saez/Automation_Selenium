package basicweb;

import static org.junit.Assert.*;
import java.awt.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class isElementPresentDemo2 {

	private WebDriver driver;
	private String baseUrl;
	private GenericMethods gm; //Importing the java class
	
		@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		gm = new GenericMethods(driver); //it generates a new ChromeDriver by the running Java
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}

	@Test
	public void test() throws Exception{
		driver.get(baseUrl);
	
		boolean result1 = gm.isElementPresent("name","id");
		System.out.println("Is the element present: " + result1);
		
		boolean result2 = gm.isElementPresent("name-not-present","id");
		System.out.println("Is the element present: " + result2);
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		//driver.quit();
	}
}

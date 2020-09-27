package basicweb;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class SwitchFrame {
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.get(baseUrl);	
	}

	@Test
	void test() throws Exception {
		Thread.sleep(3000);
		
		//Switch to frame by id
		//driver.switchTo().frame("courses-iframe");
		
		//Switch to frame by name
		driver.switchTo().frame("iframe-name");
		
		//Switch to frame by number
		driver.switchTo().frame(0);
		
		WebElement searchBox = driver.findElement(By.id("search-courses"));
		searchBox.sendKeys("Python");
		
		driver.switchTo().defaultContent();
		Thread.sleep(6000);
		driver.findElement(By.id("name")).sendKeys("Test Successful");
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}

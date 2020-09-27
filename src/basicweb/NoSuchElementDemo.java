package basicweb;

import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class NoSuchElementDemo {
	private WebDriver driver;
	private String baseUrl;
	
	
	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/p/practice";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}

	@Test
	void test() throws Exception {
		driver.get(baseUrl);
		//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		
		// 1-Timing issues
		driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
		//WebElement emailField = driver.findElement(By.id("user_email"));
		
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
		emailField.sendKeys("testing");
		
		// 2-Incorrect locator or type of locator
		//driver.findElement(By.xpath("//a[@href='/sign_in']")).click(); -> must be complete path or
		driver.findElement(By.xpath("//a[contains(@href='/sign_in')]")).click();
				
		// 3-Element is in iFrame
		driver.get("https://letskodeit.teachable.com/p/practice");
		driver.switchTo().frame("courses-iframe");
		driver.findElement(By.id("search-courses")).sendKeys("java");
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.close();
	}
}

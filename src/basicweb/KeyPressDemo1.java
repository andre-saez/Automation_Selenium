package basicweb;

import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class KeyPressDemo1 {
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeEach
	void setUp() throws Exception {	
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		baseUrl = "https://letskodeit.teachable.com/p/practice";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		
	}
	
	@Test
	void test() throws InterruptedException {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[contains(@href,'sign_up')]")).click();
		driver.findElement(By.id("user_email")).sendKeys("test@email.com");
		Thread.sleep(2000);
		driver.findElement(By.id("user_email")).sendKeys(Keys.TAB);
		driver.findElement(By.id("user_password")).sendKeys("123123");
		//Thread.sleep(2000);
		//driver.findElement(By.name("commit")).sendKeys(Keys.ENTER);
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}
}
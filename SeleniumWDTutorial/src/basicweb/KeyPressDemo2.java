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

class KeyPressDemo2 {
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
		//driver.findElement(By.id("openwindow")).sendKeys(Keys.COMMAND + "a");
		Thread.sleep(2000);
		//driver.findElement(By.id("openwindow")).sendKeys(Keys.chord(Keys.COMMAND, "a"));
		//Thread.sleep(2000);
		String selectAll = Keys.chord(Keys.COMMAND, "a");
		driver.findElement(By.id("openwindow")).sendKeys(selectAll);
		Thread.sleep(2000);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
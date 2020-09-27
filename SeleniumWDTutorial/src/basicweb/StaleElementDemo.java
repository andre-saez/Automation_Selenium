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

class StaleElementDemo {
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://learn.letskodeit.com/p/practice";
		
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}

	@Test
	void test() throws Exception {
//		driver.getCurrentUrl();
		driver.get(driver.getCurrentUrl());
		WebElement checkboxElement = driver.findElement(By.id("bmwcheck"));
		checkboxElement.click();
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}
}
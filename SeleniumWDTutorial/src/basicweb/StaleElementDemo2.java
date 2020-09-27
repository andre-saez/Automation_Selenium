package basicweb;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class StaleElementDemo2 {
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "http://www.southwest.com/";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}

	@Test
	void test() throws Exception {
		String searchingText = "New York/Newark, NJ - EWR";
		String partialText = "New York";
		driver.get(baseUrl);
		
		WebElement text = driver.findElement(By.id("LandingAirBookingSearchForm_originationAirportCode"));
		text.sendKeys(partialText);
		
		WebElement element = driver.findElement(By.id("LandingAirBookingSearchForm_originationAirportCode"));
		List<WebElement> results = element.findElements(By.tagName("li"));
		int size = results.size();
		
		System.out.println("The size of the list is: " + size);
		
		for (int i = 0; i < size; i++) {
			System.out.println(results.get(i).getText());
		}
		
		Thread.sleep(2000);
		
		for(WebElement result: results) {
			if (result.getText().equals(searchingText)) {
				System.out.println("Selected: " + result.getText());
				result.click();
				break;
			}
			
		}
		
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.close();
	}
}
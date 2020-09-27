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
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.JavascriptExecutor;

class ElementNotClickableDemo {
	private WebDriver driver;
	private String baseUrl;
	
	
	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://www.freecrm.com/index.html";
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
	}

	@Test
	void test() throws Exception {
		driver.findElement(By.name("username")).sendKeys("testing");
		JavaScriptExecutor js = (JavaScriptExecutor) driver;
		
// 1st option
//		WebElement loginButton = driver.findElement(By.xpath("//input[@value='login']"));
//		loginButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 3);
		//WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='login']"))); 
//		loginButton.click();

// 2nd option		
//		boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
//		if (invisible) {
//			WebElement loginButton = driver.findElement(By.xpath("//input[@value='login']"));
//			loginButton.click();
//		}
		
// 3rd option
		WebElement loginButton = driver.findElement(By.xpath("//input[@value='login']"));
		js.executeScript("arguments[0].click();",loginButton);
		
	}
		
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.close();
	}
}

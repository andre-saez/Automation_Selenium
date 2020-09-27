package basicweb;

import static org.junit.Assert.*;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindow {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","/Users/DesktopW7/Documents/chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws Exception {

		// Get the handle
		String parentHandle = driver.getWindowHandle(); // it works on the current window
		System.out.println("Parent handle: " + parentHandle);

		// Finding open window button
		WebElement openWindow = driver.findElement(By.id("openwindow"));
		openWindow.click();

		// Getting all handles
		Set<String> handles = driver.getWindowHandles();

		// Switching between handles
		for (String handle : handles) {
			System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				Thread.sleep(2000);
				WebElement searchBox = driver.findElement(By.id("search-courses"));
				searchBox.sendKeys("python");
				driver.close();
				break;
			}
		}
		
		driver.switchTo().window(parentHandle);
		driver.findElement(By.name("name")).sendKeys("Test Successful");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.close();
	}
}
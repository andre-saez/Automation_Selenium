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
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptClick {

	private WebDriver driver;
	private JavascriptExecutor js;
	private String baseUrl;
	private String baseUrl1;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		baseUrl1 = "https://www.retailmenot.com/";
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}

	@Test
	public void testJSClick1() throws Exception {
		driver.manage().deleteAllCookies();
		driver.get(baseUrl);
		Thread.sleep(3000);

		WebElement checkBoxElement = driver.findElement(By.id("bmwcheck"));
		js.executeScript("arguments[0].click();", checkBoxElement);
	}

	@Test
	public void testJSClick2() throws Exception {
		driver.manage().deleteAllCookies();
		driver.get(baseUrl1);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Log in / Sign up']")).click();
		Thread.sleep(3000);

		WebElement checkBoxElement1 = driver.findElement(By.id("subscribe"));
		System.out.println("Displayed:" + checkBoxElement1.isDisplayed());
		System.out.println("Selected" + checkBoxElement1.isSelected());

		// checkBoxElement1.click();
		js.executeScript("arguments[0].click();", checkBoxElement1);
	}

	@Test
	public void testJSClick3() throws Exception {
		driver.get("https://www.retailmenot.com/");
		driver.findElement(By.xpath("//div[text()='Log In / Sign up']")).click();
		Thread.sleep(3000);

		WebElement checkBoxElement = driver.findElement(By.id("subscribe"));
		System.out.println("Displayed: " + checkBoxElement.isDisplayed());
		System.out.println("Selected: " + checkBoxElement.isSelected());

		// checkBoxElement.click();
		js.executeScript("arguments[0].click();", checkBoxElement);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.close();
	}
}

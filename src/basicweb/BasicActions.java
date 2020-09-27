package basicweb;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicActions {
	
	WebDriver driver;
	String baseUrl;
		
	@Before
	public void setUp() throws Exception {
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		baseUrl = "https://letskodeit.teachable.com";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//div[@id='navbar']//a[@href='/sign_in']")).click();
		System.out.println("Clicked on login");
		driver.findElement(By.id("user_email")).clear();
		System.out.println("Clearing cache for old usernames");
		driver.findElement(By.id("user_email")).sendKeys("test@email.com");
		System.out.println("Inserting email address");
		driver.findElement(By.id("user_password")).sendKeys("letskodeit");   /////////add the correct password here
		System.out.println("Inserting password");
		driver.findElement(By.xpath("//form[@id='new_user']//input[@name='commit']")).click();		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		System.out.println("Closing the browser");
	}
}
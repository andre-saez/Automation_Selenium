package basicweb;

import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javafx.scene.control.Alert;

public class SwitchAlert {
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
	void test1() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.id("name")).sendKeys("Andre");
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(3000);
		Alert alert = (Alert) driver.switchTo().alert();
		((org.openqa.selenium.Alert) alert).accept();
		//((org.openqa.selenium.Alert) alert).dismiss();
	}
	
	@Test
	void test2() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.id("name")).sendKeys("Andre");
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(3000);
		Alert alert = (Alert) driver.switchTo().alert();
		((org.openqa.selenium.Alert) alert).accept();
		//((org.openqa.selenium.Alert) alert).dismiss();
	}
	
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.close();
	}

}

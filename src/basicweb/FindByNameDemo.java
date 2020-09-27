package basicweb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByNameDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/DesktopW7/Documents/Libs/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseURL = "https://learn.letskodeit.com/p/practice";
		driver.manage().window().maximize();
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("enter-name")).sendKeys("Automation");
		driver.findElement(By.className("btn-style")).click();
		
		
	}

}

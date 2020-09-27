package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IdNameDemo {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "/Users/DesktopW7/Documents/Libs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String baseURL = "https://www.google.com";
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("lst-ib")).sendKeys("letskodeit");
		driver.findElement(By.name("btnG")).click();
		
	}

}

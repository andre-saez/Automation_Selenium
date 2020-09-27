package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IdXPATHDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "/Users/DesktopW7/Documents/Libs/geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", "/Users/DesktopW7/Documents/Libs/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		String baseURL = "https://learn.letskodeit.com/";
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
		driver.findElement(By.id("//input[@id='user_email']")).sendKeys("letskodeit@gmail.com");
		
		//driver.findElement(By.xpath("//*[@title='Search']")).sendKeys("Letskodeit");
		//driver.findElement(By.xpath("//*[@id='Search']/button")).click();
	
		
		}
}

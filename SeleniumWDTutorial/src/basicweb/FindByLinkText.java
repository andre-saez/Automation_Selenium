package basicweb;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindByLinkText {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver","/Users/DesktopW7/Documents/Libs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String baseURL = "https://letskodeit.teachable.com/";
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Login")).click();
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			
			e.printStackTrace();
		}
		driver.findElement(By.partialLinkText("Pract")).click();
		driver.quit();
	}
}

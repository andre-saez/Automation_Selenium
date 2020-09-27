package basicweb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/DesktopW7/Documents/Libs/chromedriver.exe");
		String baseURL = "http://www.letskodeit.com";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
		
	}

}

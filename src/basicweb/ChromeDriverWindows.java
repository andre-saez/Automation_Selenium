package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverWindows {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/DesktopW7/Documents/chromedriver.exe");
		String baseURL = "http://www.letskodeit.com";
		WebDriver driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
		
	}
}

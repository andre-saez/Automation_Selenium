package basicweb;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsDemo 
{
	public static void main(String[] args) 
	{
		String baseUrl = "http://www.google.com";
		WebDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("E:\\Users\\DesktopW7\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\gighmmpiobklfepjocnamgkkbiglidom\\4.5.0_0.crx"));
		driver = new ChromeDriver(options);
		driver.get(baseUrl);
	}
}
package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver","/Users/DesktopW7/Documents/Libs/InternetExplorerDriver.exe" );
		String baseURL = "http://www.google.com";
		WebDriver driver = new InternetExplorerDriver();
		driver.get(baseURL);
	}

}

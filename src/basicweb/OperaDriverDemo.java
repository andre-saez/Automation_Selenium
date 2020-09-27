package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class OperaDriverDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.opera.driver","/Users/DesktopW7/Documents/Libs/operadriver.exe");
		String baseURL="http://www.google.com";
		WebDriver driver = new OperaDriver();
		driver.get(baseURL);
		
	}

}
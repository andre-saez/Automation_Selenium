package basicweb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class browserProfile {

	public static void main(String[] args) {
		WebDriver driver;
		String baseUrl = "https://learn.letskodeit.com/";
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile fxprofile = profile.getProfile("automation");
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(fxprofile);
		
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.close();
	}
}
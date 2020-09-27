package basicweb;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigatingBetweenPages 
	{
		//System.setProperty("webdriver.chrome.driver","/Users/DesktopW7/Documents/Libs/chromedriver.exe");
	WebDriver driver;
	String baseUrl;
	

	@Before
	public void setUp() throws Exception 
	{
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}


	@Test
	public void test() throws InterruptedException 
	{
		driver.get(baseUrl);
		String title = driver.getTitle();
		System.out.println("The page's title is: " + title);
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is: "+ currentUrl);
		
		String urlToNavigate = "https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";
		driver.navigate().to(urlToNavigate);
		System.out.println("Navigating to login");
		
		currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentUrl );
		Thread.sleep(2000);
		
		driver.navigate().back(); //navigates to the previous page
		System.out.println("Navigate back.");
		currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentUrl);
		
		Thread.sleep(2000);
		
		driver.navigate().forward(); //navigate to the next page
		System.out.println("Navigate forward.");
		currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentUrl);
		
		
		driver.navigate().back(); //navigates to the previous page
		System.out.println("Navigate back.");
		currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentUrl);
		
		driver.navigate().refresh();
		System.out.println("Navigation refreshed.");
		driver.get(currentUrl);
		driver.navigate().refresh();
		System.out.println("Navigation refreshed.");
		
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
	}
	
	@After
	public void tearDown() throws Exception 
	{
		driver.quit();
		System.out.println("Browser is closed.");
	}

}

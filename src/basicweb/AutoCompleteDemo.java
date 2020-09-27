package basicweb;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoCompleteDemo {
	
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		
		driver = new ChromeDriver();
		baseUrl = "https://www.goibibo.com/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);	
	}

	@Test
	public void test() throws InterruptedException {
		String partialText = "Del";
		String textToSelect = "Delhi, India (DEL)";
		
		WebElement textField = driver.findElement(By.id("gosuggest_inputSrc"));
		textField.sendKeys(partialText);
		
		WebElement ulElement = driver.findElement(By.id("react-autosuggest-1"));
		String innerHTML = ulElement.getAttribute("innerHTML");
		System.out.println(innerHTML);
		
		List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
		Thread.sleep(3000);
		
		for(WebElement element : liElements) {
			
			System.out.println(element.getText());
			
			if(element.getText().contains(textToSelect)) {
				System.out.println("Selected: " + element.getTagName());				
				element.click();
				break;
			}				
		}
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.close();
	}
}
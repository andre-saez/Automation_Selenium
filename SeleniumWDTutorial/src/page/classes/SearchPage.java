package page.classes;

import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class SearchPage {
	public static WebElement element = null;
	
	//To navigate to flights tab
	public static void clickFlightPage(WebDriver driver) {
		element = driver.findElement(By.id("tab-flight-tab-hp"));
		element.click();
	}
	
	//Returns the flight origin text box element
	public static WebElement originTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-origin-hp-flight"));
		return element;		
	}
	
	public static void fillOriginTextBox(WebDriver driver, String origin) {
		element = originTextBox(driver);
		element.sendKeys(origin);
	}
	
	//Returns the flight destination text box element
	public static WebElement destinationTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-destination-hp-flight"));
		return element;		
	}
		
	//Returns the departure date text box element
	public static WebElement departureDateTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-departing-hp-flight"));
		return element;		
	}
	
	//Returns the return date text box element
	public static WebElement returnDateTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-returning-hp-flight"));
		return element;		
	}
	
	//Returns the search button box element
	public static WebElement searchButton(WebDriver driver) {
		//element = driver.findElement(By.id("search-button"));
		element = driver.findElement(By.xpath("//form[@id='gcw-hotel-form-hp-hotel']//button[contains(@class,'gcw-submit')]"));
		return element;		
	}
	
	//Click on search button
	public static void clickOnSearchButton(WebDriver driver) {
		element = searchButton(driver);
		element.click();
	}
	
	//Navigate to flights tab
	public static void navigateToFlightsTab(WebDriver driver) {
		driver.findElement(By.id("header-history")).click();
		element = driver.findElement(By.id("tab-flight-tab"));
		element.click();
	}
	
}

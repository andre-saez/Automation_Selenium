package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageFactory1 {
	WebDriver driver;
	
	@FindBy(id="tab-flight-tab")
	WebElement flightTab;
	
	@FindBy(id="flight-type-roundtrip-label")
	WebElement roundTrip;
	
	@FindBy(id="flight-type-multi-dest-label")
	WebElement multipleDestination;
	
	//click on flight tab
	public void clickFlightTab() {
		flightTab.click();
	}

	//click on
	public void clickroundTrip() {
		roundTrip.click();
	}
	
	public void clickMultipleDestination() {
		multipleDestination.click();
	}
	
	
}

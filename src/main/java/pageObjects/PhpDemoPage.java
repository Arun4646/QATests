package pageObjects;

import org.openqa.selenium.WebDriver;

public class PhpDemoPage {

	WebDriver _driver;
	
	public PhpDemoPage (WebDriver driver) {
		
		_driver = driver;
		//PageFactory.initElements(_driver, this);
	}
}

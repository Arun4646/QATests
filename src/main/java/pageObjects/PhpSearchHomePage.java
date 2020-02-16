package pageObjects;

import org.openqa.selenium.WebDriver;

public class PhpSearchHomePage {

	WebDriver _driver;
	
	public PhpSearchHomePage (WebDriver driver) {
		
		_driver = driver;
		//PageFactory.initElements(_driver, this);
	}
}

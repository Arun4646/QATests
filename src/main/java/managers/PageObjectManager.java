package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.PhpDemoPage;
import pageObjects.PhpSearchHomePage;

public class PageObjectManager {

	private WebDriver driver;
	private PhpSearchHomePage phpSearchHomePage;
	private PhpDemoPage phpDemoPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public PhpSearchHomePage getPhpSearchHomePage() {
		
		return (phpSearchHomePage ==null) ? phpSearchHomePage = new PhpSearchHomePage(driver) : phpSearchHomePage;
	}
	
	public PhpDemoPage getPhpDemoPage() {
		
		return (phpDemoPage ==null) ? phpDemoPage = new PhpDemoPage(driver) : phpDemoPage;
	}
}

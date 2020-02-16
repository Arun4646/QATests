package helper;

import org.openqa.selenium.WebDriver;

import managers.PageObjectManager;
import managers.WebDriverManager;

public class ContextHelper {

	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	private WebDriver driver;
	
	public ContextHelper() {
		System.out.println("Inside context helper constructor");
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		pageObjectManager = new PageObjectManager(driver);
	}
	
	public WebDriverManager getWebDriverManager () {
		return webDriverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
}

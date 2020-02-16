package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

import dataProviders.ConfigFileReader;
import enums.DriverType;
import enums.ScreenType;

public class WebDriverManager {

	private WebDriver driver;
	private DriverType driverType;
	private ScreenType screenType;
	private ConfigFileReader configFileReader;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	
	public WebDriverManager() {
		
		configFileReader = new ConfigFileReader();
		driverType = configFileReader.getBrowser();
		screenType = configFileReader.getScreenType();
	}
	
	public WebDriver getDriver() {

		if(driver == null) driver = createDriver();
		selectScreenSize(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	private WebDriver createDriver() {
		//can implement other browser types also
		switch(driverType) {
		
		case CHROME : 
			System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getChromeDriverPath());
			driver = new ChromeDriver();
		break;
		
		case HEADLESS_CHROME :
			System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getChromeDriverPath());
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("window-size=1920,1080");
			driver = new ChromeDriver(chromeOptions);
		}
		
			return driver;
	}
	
	private void selectScreenSize(WebDriver driver) {
		//Can add more screensizes
		switch(screenType) {
			case DESKTOP : driver.manage().window().maximize();
			break;
			default : driver.manage().window().maximize();
		}
	}
	
	public void closeDriver() {
		//driver.close();
		driver.quit();
	}
	
	public String getDriverConfigName() {

		return driverType.toString() + "_" +screenType.toString();
	}
}

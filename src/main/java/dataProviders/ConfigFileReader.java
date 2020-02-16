package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.ScreenType;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath="configs//Configuration.properties";
	
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration file not found at " + propertyFilePath);
		}
	}
	
	public String getChromeDriverPath() {
		String driverPath = properties.getProperty("chromedriverPath");
		if(driverPath!=null) return driverPath;
		else
			throw new RuntimeException("Chrome driverPath is not specified in the Configuration properties file");
	}
	
	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if (browserName == null || browserName.equalsIgnoreCase("chrome")) return DriverType.CHROME;
		else if(browserName.equalsIgnoreCase("HeadlessChrome")) return DriverType.HEADLESS_CHROME;
		else
			throw new RuntimeException("Unsupported browser name is mentioned in the configuration file");
	}
	
	public ScreenType getScreenType() {
		String screenTypeName = properties.getProperty("screentype");
		if(screenTypeName == null || screenTypeName.equalsIgnoreCase("desktop")) return ScreenType.DESKTOP;
		else
				throw new RuntimeException("Unsupported Screen type mentioned in the configuration file");
	
	}
}

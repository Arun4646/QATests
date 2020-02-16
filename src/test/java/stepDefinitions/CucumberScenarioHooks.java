package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helper.ContextHelper;

public class CucumberScenarioHooks {

	ContextHelper contextHelper;
	
	public CucumberScenarioHooks (ContextHelper context) {
		contextHelper = context;
	}
	
	
	@After
	public void CloseBrowser() {
		
		contextHelper.getWebDriverManager().closeDriver();
	}
}

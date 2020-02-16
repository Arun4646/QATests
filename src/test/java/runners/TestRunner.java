package runners;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/featureTests",
		glue = {"stepDefinitions"},
		plugin = { "pretty", "html:target/cucumber-reports" },
		monochrome = true,
		tags = {"@RunTest"}
		)

public class TestRunner {

	@AfterClass
	 public static void CompletionStatus() throws InterruptedException {
	 
		System.out.println("Execution complted");
	 }
}

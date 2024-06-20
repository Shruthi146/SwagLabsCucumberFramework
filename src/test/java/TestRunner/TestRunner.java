package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/java/Features"},
		glue = {"StepDefinitions","Hooks"},
		tags = "@Login1",
		monochrome=true,
		dryRun=false,
		plugin = {"pretty","html:test-output/Reports/cucumber.html",
				"json:test-output/Reports/cucumber.json,",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		)

public class TestRunner extends AbstractTestNGCucumberTests {

	
}

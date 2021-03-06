package cucumber_test;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "Features",
	    glue = {"stepDefinitions"},
	    tags = "@CreateMultipleVacancies",
	    dryRun = false,
	    monochrome = true,
	    stepNotifications = true,
	    plugin = {"pretty","html:target/cucumber-reports/report-3.html"}
	    		
	 )	

public class Testrunner {

}

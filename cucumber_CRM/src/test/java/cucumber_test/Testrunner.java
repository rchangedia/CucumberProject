package cucumber_test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "Features",
	    glue = {"stepDefinitions"},
	    tags = "@CreateProduct",
	    dryRun = false,
	    monochrome = true,
	    stepNotifications = true,
	    plugin = {"pretty","html:target/cucumber-reports/report-1.html"}
	    		
	 )	

public class Testrunner {

}

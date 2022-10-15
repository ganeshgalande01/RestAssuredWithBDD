package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(

		
		features = ".//Features/PostRequests.feature", glue = "StepDefinition", dryRun =false, 
		plugin = {   "pretty","html:target/HtmlReports.html",
				   //  "pretty","io.qmeta.allure.cucumber7jvm.AllureCucumber7Jvm"
		         }, monochrome = true,
				    publish = true

)
public class TestRun  {

}

/*
features = ".//Features/Customer.feature", glue = "StepDefinition", dryRun = false, plugin = { "pretty",
"html:target/HtmlReports.html" }, monochrome = true,
publish = true
*/

// plugin = { "pretty","html:target/HtmlReports.html" }
//plugin = {"pretty","io.qmeta.allure.cucumber7jvm.AllureCucumber7Jvm"}
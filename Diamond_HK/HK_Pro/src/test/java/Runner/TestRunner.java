package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
	             features = "demo.feature"	,
		         glue = "Steps"   ,
		      dryRun = false,
		         monochrome = true,
		         publish = true,
		        plugin= { "json:target/cucumber.json","html:target/cucumber-reports/report.html","pretty"}
		
		
		         )


public class TestRunner {
	
	
}
	
	
	



package Testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src//test//java//feature//sampletest.feature"
		,glue={"stepDefinition"},
		tags= "@testnew1"
		)

public class testrunner {

}

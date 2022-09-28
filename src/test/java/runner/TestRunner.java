package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"}, glue = {"spec"}, tags = "  @ValidOrder or @InValidLogin or @ErrorMessageValidation",plugin = { "pretty", "json:target/cucumber/report.json", "html:target/cucumber/report.html" } , monochrome = true)

public class TestRunner {


}

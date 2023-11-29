package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumberjsonreport.json"},
        features = {"C:\\Shruti\\DemoProject\\UiAutomation_Shruti\\sauce-demo-automation\\shruti_uiAutomation\\src\\test\\resources\\features"},
        glue = {"src\\test\\java\\stepDef"}
)

public class CucumberTestSuite {

}
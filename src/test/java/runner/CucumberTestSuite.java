package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumberjsonreport.json"},
        features = {"/Users/shrutilad/Desktop/Shruti/Shruti-Demo/src/test/resources/features"},
        glue = {"/Users/shrutilad/Desktop/Shruti/Shruti-Demo/src/test/java/stepDef"}
)

public class CucumberTestSuite {

}
package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/TestResult.html"},
        features = "src/test/java/TestCases",
        glue = "StepDef",
        tags = "@saving",
        dryRun = false
)




public class CukeRunner {
}

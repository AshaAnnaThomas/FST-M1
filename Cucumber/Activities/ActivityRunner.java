package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = { "stepDefinitions" },
        tags = "@activity1 or @activity2 or @activity3 or @activity4 or @activity5",
        //plugin = { "html: test-reports" },
        //plugin = { "pretty" },
        plugin = { "json: json-report.json" },
        monochrome = true
)

public class ActivityRunner {
}

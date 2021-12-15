package Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue ="APISteps",
        dryRun = false,
        monochrome = true,
        tags = " @APIWorkFlow",
        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json"}
)








public class APiRunner {
}

package Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "Steps",
        dryRun = false,
        //monochrome = true
        //tags = "@Smoke or @Sprint",
       // tags = "@Regression and @Sprint"
     // tags = "@hab",
        //strict=true, it check all the steps definition
  plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json", "rerun:target/failed.txt"}
//plugin - we use it to generate report for the execution
//pretty - it takes care of printing the steps in console
//strict=true, it check all the steps definition
)

public class Smoke {

    /**
     * mvn clean verify -Dcucumber.filter.tags="@Smoke"                     --------(mvn test -Dcucumber.options="--tags @test"
     */
}

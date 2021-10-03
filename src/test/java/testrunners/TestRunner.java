package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/java/features"},
    plugin = {
        "json:target/cucumber.json",
        "junit:target/cucumber-results.xml",
        "pretty:target/cucumber-pretty.txt",
        "html:target/cucumber",
        "pretty",},
    glue = {"steps", "steps/config"}
)
public class TestRunner {
    @BeforeClass
    public static void setUp() {
    }
}

package steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.RestAssuredExtension;

public class TestInitialize {
    private static Scenario scenario;

    @Before
    public void TestSetup(Scenario scenario){
        RestAssuredExtension restAssuredExtension = new RestAssuredExtension();
        this.scenario = scenario;
    }

    public static Scenario getScenario(){
        return scenario;
    }
}

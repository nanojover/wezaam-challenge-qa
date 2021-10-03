package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserControllerSteps {
    private static ResponseOptions<Response> response;

    @When("I perform the GET user request for {string}")
    public void iPerformTheGETRequest(String endpoint) {
        response = RestAssuredExtension.Get(endpoint);
        TestInitialize.getScenario().log("Status Code - " + String.valueOf(response.getStatusCode()));
        TestInitialize.getScenario().log(response.getBody().prettyPrint());
    }

    @Then("the user list is successfully retrieved")
    public void theListIsSuccessfullyRetrieved() {
        assertThat(response.getStatusCode(),equalTo(200));
    }
}

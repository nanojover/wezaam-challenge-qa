package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WithdrawalControllerSteps {
    private static ResponseOptions<Response> response;

    @When("I perform the GET withdrawal request for {string}")
    public void iPerformTheGETRequest(String endpoint) {
        response = RestAssuredExtension.Get(endpoint);
        TestInitialize.getScenario().log("Status Code - " + String.valueOf(response.getStatusCode()));
        TestInitialize.getScenario().log(response.getBody().prettyPrint());
    }

    @When("I perform the POST withdrawal request for {string}")
    public void iPerformThePOSTRequest(String endpoint) {
        response = RestAssuredExtension.Post(endpoint);
        TestInitialize.getScenario().log("Status Code - " + String.valueOf(response.getStatusCode()));
        TestInitialize.getScenario().log(response.getBody().prettyPrint());
    }

    @Then("the withdrawal list is successfully retrieved")
    public void theListIsSuccessfullyRetrieved() {
        assertThat(response.getStatusCode(),equalTo(200));
    }

    @When("I perform the POST withdrawal request for {word}{string}{word} with body")
    public void iPerformThePOSTWithdrawalRequestForWithBody(String pathParamValue, String userId, String pathParamValue2, DataTable table) {
        //TODO
//        var data = table.raw();
//
//        HashMap<String, String> body = new HashMap<>();
//        body.put("amount", data.get(1).get(0));


    }
}

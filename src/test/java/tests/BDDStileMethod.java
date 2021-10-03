package tests;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BDDStileMethod {
    private static final String BASE_URI = "https://reqres.in/api";
    private static String endpoint;

    public static void GetUsers(String endpointValue) {
        baseURI = BASE_URI;
        endpoint = endpointValue;

        given()
                .contentType(ContentType.JSON)
        .when()
                .get(endpoint)
        .then()
                .statusCode(200)
        .log().all();
    }

    public static void GetUsersResponse(String pageValue, String id, String email) {
        given()
                .contentType(ContentType.JSON)
                .queryParam("page", pageValue)
        .when()
                .get(endpoint)
        .then()
                .body("data[" + id + "].email", equalTo(email))
        .log().all();
    }
}

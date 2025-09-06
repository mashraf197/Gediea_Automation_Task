package base;

import io.restassured.RestAssured;

public class BaseAPI {

    static {
        // Base URL for all API requests
        RestAssured.baseURI = "https://automationexercise.com/api/";
    }
}

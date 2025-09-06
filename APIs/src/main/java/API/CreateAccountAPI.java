package API;

import base.BaseAPI;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreateAccountAPI extends BaseAPI {

    private final String endpoint = "createAccount"; // API extension

    public Response createAccount(
            String name,
            String email,
            String password,
            String title,
            String birth_date,
            String birth_month,
            String birth_year,
            String firstname,
            String lastname,
            String company,
            String address1,
            String address2,
            String country,
            String zipcode,
            String state,
            String city,
            String mobile_number
    ) {

        // Send POST request using form parameters
        Response response = given()
                .formParam("name", name)
                .formParam("email", email)
                .formParam("password", password)
                .formParam("title", title)
                .formParam("birth_date", birth_date)
                .formParam("birth_month", birth_month)
                .formParam("birth_year", birth_year)
                .formParam("firstname", firstname)
                .formParam("lastname", lastname)
                .formParam("company", company)
                .formParam("address1", address1)
                .formParam("address2", address2)
                .formParam("country", country)
                .formParam("zipcode", zipcode)
                .formParam("state", state)
                .formParam("city", city)
                .formParam("mobile_number", mobile_number)
                .when()
                .post(endpoint)
                .then()
                .extract().response();

        return response;
    }
}

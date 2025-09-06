package tests;

import API.CreateAccountAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utils.TestDataUtil;

public class CreateAccountTests {

    @Test
    public void createAccountFormDataTest() {
        CreateAccountAPI api = new CreateAccountAPI();

        // Generate unique email
        String email = TestDataUtil.generateUniqueEmail();

        // Call API with form-data
        Response response = api.createAccount(
                "John Doe",
                email,
                "Test@123",
                "Mr",
                "01",
                "01",
                "1990",
                "John",
                "Doe",
                "Example Company",
                "123 Main St",
                "Apt 4",
                "Egypt",
                "12345",
                "Cairo",
                "Cairo",
                "0123456789"
        );

        // Print response
        System.out.println("Response: " + response.asString());

        // Assert HTTP status code
        Assert.assertEquals(response.getStatusCode(), 200, "HTTP status should be 200");

        // Assert responseCode in JSON
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 201, "API responseCode should be 201");

        // Assert success message
        String message = response.jsonPath().getString("message");
        Assert.assertTrue(message.toLowerCase().contains("user created"), "Success message not found");
    }
}

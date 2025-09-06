package com.ae.tests;

import com.ae.pages.HomePage;
import com.ae.pages.LoginPage;
import com.ae.pages.SignUpFormPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignupTest extends BaseTest {

    @Test(description = "Valid user signup", groups = {"smoke", "regression"})
    public void testValidSignup() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SignUpFormPage signupFormPage = new SignUpFormPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to Signup page
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignupLoginButton()));
        homePage.clickSignupLogin();

        // Fill signup (name + unique email)
        String email = "muhamed.auto" + System.currentTimeMillis() + "@test.com";
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginEmailField())); // waiting form
        loginPage.enterSignupName("Muhamed");
        loginPage.enterSignupEmail(email);
        loginPage.clickSignupButton();

        // Wait form page to load
        wait.until(ExpectedConditions.elementToBeClickable(signupFormPage.getPasswordField()));

        // Fill extended form
        signupFormPage.selectGenderMr();
        signupFormPage.enterPassword("password123");
        signupFormPage.enterFirstName("Muhamed");
        signupFormPage.enterLastName("Ashraf");
        signupFormPage.enterAddress("Cairo, Egypt");
        signupFormPage.enterState("Maadi");
        signupFormPage.enterCity("Cairo");
        signupFormPage.enterZipCode("12345");
        signupFormPage.enterMobile("01012345678");
        signupFormPage.clickCreateAccount();

        // Assertion
        Assert.assertTrue(signupFormPage.getAccountCreatedMessage().isDisplayed(),
                "Signup failed – success message not found!");
    }

    @Test(description = "Signup with existing email should show error", groups = {"regression"})
    public void testSignupWithExistingEmail() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignupLoginButton()));
        homePage.clickSignupLogin();

        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginEmailField()));
        loginPage.enterSignupName("Muhamed");
        loginPage.enterSignupEmail("muhamed@gmail.com");
        loginPage.clickSignupButton();
        // Assertion
        Assert.assertTrue(loginPage.isSignupErrorVisible(),
                "Expected error message for existing email not found!");
    }
}

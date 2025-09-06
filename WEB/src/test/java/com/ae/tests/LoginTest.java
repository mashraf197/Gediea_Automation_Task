package com.ae.tests;

import com.ae.pages.HomePage;
import com.ae.pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test(description = "Valid login with correct credentials", groups = {"smoke", "regression"})
    public void testValidLogin() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignupLoginButton()));
        homePage.clickSignupLogin();

        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginEmailField()));

        loginPage.enterLoginEmail("muhamed@gmail.com");
        loginPage.enterLoginPassword("mohamed123456");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.isLogoutVisible(),
                "Login failed – Logout link not visible!");
    }

    @Test(description = "Invalid login with wrong password", groups = {"regression"})
    public void testInvalidPasswordLogin() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignupLoginButton()));
        homePage.clickSignupLogin();

        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginEmailField()));
        loginPage.enterLoginEmail("muhamed@gmail.com");
        loginPage.enterLoginPassword("wrongPassword");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.isLoginErrorVisible(),
                "Expected error message not shown for wrong password!");
    }

    @Test(description = "Invalid login with non-existing email", groups = {"regression"})
    public void testNonExistingEmailLogin() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignupLoginButton()));
        homePage.clickSignupLogin();

        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginEmailField()));
        loginPage.enterLoginEmail("fake" + System.currentTimeMillis() + "@test.com");
        loginPage.enterLoginPassword("password123");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.isLoginErrorVisible(),
                "Expected login error not shown for non-existing email!");
    }


    @Test(dataProvider = "loginData", dataProviderClass = com.ae.utils.DDT.class)
    public void testLoginDDT(String email, String password, String expectedResult) {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickSignupLogin();
        loginPage.enterLoginEmail(email);
        loginPage.enterLoginPassword(password);
        loginPage.clickLoginButton();

        if (expectedResult.equals("success")) {
            Assert.assertTrue(LoginPage.isLogoutVisible(),
                    "Login failed – Logout link not visible");
        } else {
            Assert.assertTrue(loginPage.isLoginErrorVisible(),
                    "Login error not displayed as expected");
        }
    }
}

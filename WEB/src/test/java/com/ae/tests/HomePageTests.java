package com.ae.tests;

import com.ae.pages.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTests extends BaseTest {

    @Test(description = "Verify that homepage opens and main elements are displayed",groups = {"smoke"})
    public void homepageOpens() {
        HomePage homePage = new HomePage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignupLoginButton()));

        // Assertion
        Assert.assertTrue(homePage.isLoaded(),
                "Homepage did not load correctly (Signup/Login button not visible)");
    }
}

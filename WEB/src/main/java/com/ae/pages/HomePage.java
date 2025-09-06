package com.ae.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    // Locators
    private final By signupLoginLink = By.cssSelector("a[href='/login']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void clickSignupLogin() {
        driver.findElement(signupLoginLink).click();
    }

    public WebElement getSignupLoginButton() {
        return driver.findElement(signupLoginLink);
    }

    // Check homepage is loaded (e.g., signup/login button is displayed)
    public boolean isLoaded() {
        return driver.findElement(signupLoginLink).isDisplayed();
    }
}

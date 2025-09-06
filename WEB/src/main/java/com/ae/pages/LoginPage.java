package com.ae.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private static WebDriver driver;

    // Signup form locators
    private final By signupNameField = By.cssSelector("input[data-qa='signup-name']");
    private final By signupEmailField = By.cssSelector("input[data-qa='signup-email']");
    private final By signupButton = By.cssSelector("button[data-qa='signup-button']");

    // Login form locators
    private final By loginEmailField = By.cssSelector("input[data-qa='login-email']");
    private final By loginPasswordField = By.cssSelector("input[data-qa='login-password']");
    private final By loginButton = By.cssSelector("button[data-qa='login-button']");

    // Messages & links
    private final By signupErrorMsg = By.xpath("//p[contains(text(),'Email Address already exist!')]");
    private final By loginErrorMsg = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");
    private static final By logoutLink = By.cssSelector("a[href='/logout']");
    private final By loggedInAsText = By.xpath("//li[contains(text(),'Logged in as')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Signup Actions
    public void enterSignupName(String name) {
        driver.findElement(signupNameField).sendKeys(name);
    }

    public void enterSignupEmail(String email) {
        driver.findElement(signupEmailField).sendKeys(email);
    }

    public void clickSignupButton() {
        driver.findElement(signupButton).click();
    }

    public boolean isSignupErrorVisible() {
        return driver.findElement(signupErrorMsg).isDisplayed();
    }

    // Login Actions
    public void enterLoginEmail(String email) {
        driver.findElement(loginEmailField).sendKeys(email);
    }

    public void enterLoginPassword(String password) {
        driver.findElement(loginPasswordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginErrorVisible() {
        return driver.findElement(loginErrorMsg).isDisplayed();
    }

    public static boolean isLogoutVisible() {
        return driver.findElement(logoutLink).isDisplayed();
    }

    public WebElement getLoginEmailField() {
        return driver.findElement(loginEmailField);
    }
}

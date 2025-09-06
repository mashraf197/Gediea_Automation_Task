package com.ae.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpFormPage {
    private WebDriver driver;

    // Form locators
    private final By genderMrRadio = By.id("id_gender1");
    private final By genderMrsRadio = By.id("id_gender2");
    private final By passwordField = By.id("password");
    private final By firstNameField = By.id("first_name");
    private final By lastNameField = By.id("last_name");
    private final By addressField = By.id("address1");
    private final By stateField = By.id("state");
    private final By cityField = By.id("city");
    private final By zipCodeField = By.id("zipcode");
    private final By mobileField = By.id("mobile_number");

    private final By createAccountButton = By.cssSelector("button[data-qa='create-account']");
    private final By accountCreatedMsg = By.cssSelector("h2[data-qa='account-created']");

    public SignUpFormPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void selectGenderMr() {
        driver.findElement(genderMrRadio).click();
    }

    public void selectGenderMrs() {
        driver.findElement(genderMrsRadio).click();
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void enterState(String state) {
        driver.findElement(stateField).sendKeys(state);
    }

    public void enterCity(String city) {
        driver.findElement(cityField).sendKeys(city);
    }

    public void enterZipCode(String zip) {
        driver.findElement(zipCodeField).sendKeys(zip);
    }

    public void enterMobile(String mobile) {
        driver.findElement(mobileField).sendKeys(mobile);
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountButton).click();
    }

    // Getters for waits/assertions
    public WebElement getPasswordField() {
        return driver.findElement(passwordField);
    }

    public WebElement getAccountCreatedMessage() {
        return driver.findElement(accountCreatedMsg);
    }
}

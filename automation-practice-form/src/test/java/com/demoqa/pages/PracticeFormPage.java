package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticeFormPage {
    private WebDriver driver;
    private JavascriptExecutor jsExecutor;

    // Locators
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("userEmail");
    private By mobileField = By.id("userNumber");
    private String genderRadioButtonXpath = "//label[contains(text(), '%s')]"; // Corrected
    private By submitButton = By.id("submit");
    private By modalContent = By.className("modal-content");

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterMobileNumber(String mobile) {
        driver.findElement(mobileField).sendKeys(mobile);
    }

    public void selectGender(String gender) {
        WebElement genderElement = driver.findElement(By.xpath(String.format(genderRadioButtonXpath, gender)));
        scrollToElement(genderElement);
        jsExecutor.executeScript("arguments[0].click();", genderElement);
    }

    public void clickSubmitButton() {
        WebElement submitBtn = driver.findElement(submitButton);
        scrollToElement(submitBtn);
        submitBtn.click();
    }

    public boolean isModalDisplayed() {
        return driver.findElements(modalContent).size() > 0;
    }

    public String getModalText() {
        return driver.findElement(modalContent).getText();
    }

    private void scrollToElement(WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}

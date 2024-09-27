package com.demoqa.tests;

import com.demoqa.pages.PracticeFormPage;
import com.demoqa.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeFormTest extends BaseTest {

    @Test(priority = 1)
    public void happyFlowTest() {
        PracticeFormPage formPage = new PracticeFormPage(driver);
        formPage.enterFirstName("John");
        formPage.enterLastName("Doe");
        formPage.enterEmail("john.doe@example.com");
        formPage.selectGender("Male");
        formPage.enterMobileNumber("1234567890");
        
        formPage.clickSubmitButton();

        Assert.assertTrue(formPage.isModalDisplayed(), "Success modal not displayed.");
        Assert.assertTrue(formPage.getModalText().contains("Thanks for submitting the form"), 
                          "Success message not displayed as expected.");
    }

    @Test(priority = 2)
    public void unhappyFlowTest() {
        PracticeFormPage formPage = new PracticeFormPage(driver);
        formPage.enterFirstName("Jane");
        formPage.enterLastName("Doe");
        formPage.enterEmail("jane.doe@example.com");
        formPage.selectGender("Female");
        formPage.enterMobileNumber("");  // No mobile number
        
        formPage.clickSubmitButton();

        Assert.assertFalse(formPage.isModalDisplayed(), "Form modal is displayed even though mobile number is missing.");
    }
}

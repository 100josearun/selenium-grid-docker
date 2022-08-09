package com.tmb.pages;


import org.openqa.selenium.By;
import static com.tmb.utils.SeleniumUtils.isElementDisplayed;

public class ConfirmationPage{

    private static final By HEADER_TEXT = By.xpath("//h1[text()='Check your email']");
    private static final By CONFIRMATION_TEXT= By.cssSelector(".signup__subtitle-form");
    private static final By CONFIRMATION_CODE = By.xpath("//input[@id='code']");

    public boolean verifyConfirmationPage(){
        boolean isDisplayed = false;
        if (isElementDisplayed(HEADER_TEXT) &&
                isElementDisplayed(CONFIRMATION_TEXT) &&
                isElementDisplayed(CONFIRMATION_CODE)){
            isDisplayed = true;
        }
        return isDisplayed;
    }


}

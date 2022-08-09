package com.tmb.pages;

import com.tmb.config.ConfigFactory;
import com.tmb.driver.DriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import static com.tmb.constants.TestConstants.*;
import static com.tmb.utils.SeleniumUtils.*;

public class SignupPage{

    private static final By TXTBOX_NAME = By.id("name");
    private static final By TXTBOX_WORK_EMAIL = By.id("email");
    private static final By TXTBOX_PASSWORD = By.id("password");
    private static final By BTN_SIGNUP = By.xpath("//button[@type='submit']");
    private static final By TERMS_AND_PRIVACY_CHECKBOX = By.id("signup-terms");
    private static final By EMAIL_ERROR_TEXT = By.id("emailError");
    private static final By PASSWORD_ERROR_TEXT = By.id("signup-form-password");

    private SignupPage setName(String username){
        sendKeys(TXTBOX_NAME,username,USERNAME);
        return this;
    }

    private SignupPage setWorkEmail(String email){
        sendKeys(TXTBOX_WORK_EMAIL,email,EMAIL);
        return this;
    }

    private SignupPage setPassword(String password){
        sendKeys(TXTBOX_PASSWORD,password,PASSWORD);
        return this;
    }

    private SignupPage acceptTermsAndConditions(){
        clickUsingActions(TERMS_AND_PRIVACY_CHECKBOX, TERMS_AND_PRIVACY);
        return this;
    }
    public SignupPage setSignUP(){
        click(BTN_SIGNUP, SIGN_UP_BUTTON);
        return this;
    }

    public SignupPage createNewAccount(String name, String email, String password){
        setName(name).setWorkEmail(email).acceptTermsAndConditions().setPassword(password);
        return this;
    }

    public void validateErrorLabel(){
        if(isElementDisplayed(EMAIL_ERROR_TEXT)){
            Assert.assertEquals(getElementText(EMAIL_ERROR_TEXT), ConfigFactory.getConfig().emailtext(),ASSERTION_FAILURE_MESSAGE);
        }else if(isElementDisplayed(PASSWORD_ERROR_TEXT)){
            Assert.assertEquals(getElementText(PASSWORD_ERROR_TEXT), ConfigFactory.getConfig().passwordtext(), ASSERTION_FAILURE_MESSAGE);
        }
    }

    public String getHomePageTitle(){
        return DriverManager.getDriver().getTitle();
    }
}

package com.tmb.tests;

import com.github.javafaker.Faker;
import com.tmb.pages.ConfirmationPage;
import com.tmb.pages.SignupPage;
import com.tmb.utils.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(com.tmb.listeners.TestListener.class)
public class ConfirmationPageTest extends BaseTest{

    @Test(description = "Signup with invalid data", dataProvider = "signupTestDataProvider", dataProviderClass = DataProviderUtils.class)
    public void signUpTestWithInvalidCredentials(String fullName, String workEmail, String password){
        SignupPage signupPage = new SignupPage();
        signupPage.createNewAccount(fullName, workEmail, password).setSignUP().validateErrorLabel();
    }

    @Test(description = "Signup with invalid data", dataProvider = "signupTestDataProvider",  dataProviderClass = DataProviderUtils.class)
    public void signUpTestWithValidCredentials(String fullName, String workEmail, String password){
        SignupPage signupPage = new SignupPage();
        signupPage.createNewAccount(fullName, workEmail, password).setSignUP();
        Assert.assertTrue(new ConfirmationPage().verifyConfirmationPage());
    }

}

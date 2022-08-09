package com.tmb.tests;

import com.tmb.pages.SignupPage;
import com.tmb.testdata.TestData;
import com.tmb.utils.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.tmb.listeners.TestListener.class)
public class SignupPageTest extends BaseTest {

    @Test(description = "Validate Sign-Up Options in LoginPage", dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void signUpPageTest(TestData testdata){
        SignupPage signupPage = new SignupPage();
        String actualTitle = signupPage.getHomePageTitle();
        Assert.assertEquals(actualTitle, testdata.expectedTitle);
        signupPage.createNewAccount(testdata.username, testdata.workemail, testdata.password);
    }

}

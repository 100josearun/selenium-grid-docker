package com.amazon.tests;

import com.amazon.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class BaseTest {

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional String browser) throws MalformedURLException {
        Driver.initDriver(browser);
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

}

package com.tmb.tests;

import com.tmb.driver.Driver;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        Driver.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

}

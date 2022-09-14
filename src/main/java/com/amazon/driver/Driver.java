package com.amazon.driver;

import com.amazon.config.ConfigFactory;
import com.amazon.enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public final class Driver {

    private static BrowserType browser;
    private Driver(){}

    public static void initDriver(String browserType) throws MalformedURLException {

        if(browserType == null){
            browser = ConfigFactory.getConfig().browser();
        }else{
            browser = BrowserType.valueOf(browserType);
        }

        if(DriverManager.getDriver() == null) {
            WebDriver driver = DriverFactory.getDriver(browser);
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().timeouts().implicitlyWait(ConfigFactory.getConfig().timeout(), TimeUnit.SECONDS);
            DriverManager.getDriver().get(ConfigFactory.getConfig().url());
        }
    }

    public static void quitDriver(){
        if(DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.setDriver(null);
        }
    }
}

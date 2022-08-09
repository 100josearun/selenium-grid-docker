package com.tmb.driver;

import com.tmb.enums.PageLoadStrategy;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.tmb.enums.PageLoadStrategy.EAGER;
import static com.tmb.enums.PageLoadStrategy.NORMAL;
import static org.openqa.selenium.remote.CapabilityType.PAGE_LOAD_STRATEGY;

public final class DriverFactory {

    private DriverFactory(){}

    public static WebDriver getDriver(String browserName){
        WebDriver driver;

        if(browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(PAGE_LOAD_STRATEGY, NORMAL.getLoadStrategy());
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("disable-infobars");
            chromeOptions.merge(desiredCapabilities);
            driver = new ChromeDriver(chromeOptions);
        }
        else if(browserName.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }
}

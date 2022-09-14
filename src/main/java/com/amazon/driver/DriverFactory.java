package com.amazon.driver;

import com.amazon.enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.amazon.capabilities.CapabilityManager.getCapabilities;
import static com.amazon.driver.DriverSetup.*;
import static com.amazon.enums.BrowserType.*;
import static com.amazon.enums.PageLoadStrategy.NORMAL;
import static org.openqa.selenium.remote.CapabilityType.PAGE_LOAD_STRATEGY;

public final class DriverFactory {

    private DriverFactory(){}

    public static WebDriver getDriver(BrowserType browserName) throws MalformedURLException {
        WebDriver driver;
        if(browserName.name().equalsIgnoreCase(CHROME.name())) {
            WebDriverManager.chromedriver().setup();
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(PAGE_LOAD_STRATEGY, NORMAL.getLoadStrategy());
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("disable-infobars");
            chromeOptions.merge(desiredCapabilities);
            driver = new ChromeDriver(chromeOptions);
        }
        else if(browserName.name().equalsIgnoreCase(EDGE.name())){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else if (browserName.name().equalsIgnoreCase(FIREFOX.name())){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if (browserName.name().equalsIgnoreCase(CHROME_GRID.name())){
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getCapabilities(CHROME));
        }else if (browserName.name().equalsIgnoreCase(FIREFOX_GRID.name())){
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getCapabilities(FIREFOX));
        }else{
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }

        return driver;
    }
}

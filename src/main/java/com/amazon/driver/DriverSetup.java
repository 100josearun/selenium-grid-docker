package com.amazon.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import static com.amazon.capabilities.CapabilityManager.getCapabilities;
import static com.amazon.enums.BrowserType.CHROME;
import static com.amazon.enums.BrowserType.FIREFOX;
import static com.amazon.enums.PageLoadStrategy.NORMAL;
import static org.openqa.selenium.remote.CapabilityType.PAGE_LOAD_STRATEGY;

public final class DriverSetup {

    private DriverSetup(){}

    public static WebDriver setUpChromeDriver(){
        WebDriverManager.chromedriver().setup();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(PAGE_LOAD_STRATEGY, NORMAL.getLoadStrategy());
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.merge(desiredCapabilities);
        return new ChromeDriver(chromeOptions);
    }

    public static WebDriver setUpFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    public static WebDriver setUpOperaDriver(){
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
    }

    public static WebDriver setUpEdgeDriver(){
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    public static WebDriver setUpChromeGrid() throws MalformedURLException {
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getCapabilities(CHROME));
    }

    public static WebDriver setUpFirefoxGrid() throws MalformedURLException {
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getCapabilities(FIREFOX));
    }

}

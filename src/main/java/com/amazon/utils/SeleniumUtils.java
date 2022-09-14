package com.amazon.utils;

import com.amazon.config.ConfigFactory;
import com.amazon.driver.DriverManager;
import com.amazon.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public final class SeleniumUtils {

    private SeleniumUtils(){}

    public static void waitAndClickElement(By by, String elementName){
        WebElement element = waitUntilElementPresent(by);
        element.click();
        ExtentLogger.pass(elementName + " is clicked successfully");
    }

    public static void click(WebElement element, String elementName){
        element.click();
        ExtentLogger.pass(elementName + " is clicked successfully");
    }

    public static void click(WebElement element){
        element.click();
    }

    public static void click(By element){
        DriverManager.getDriver().findElement(element).click();
    }

    public static void clickUsingActions(By by, String elementName){
        WebElement element = waitUntilElementPresent(by);
        Actions actions = new Actions(DriverManager.getDriver());
        try{
            actions.moveToElement(element).click().perform();
        }catch (Exception e){
            ExtentLogger.info(elementName+ " not clicked and retrying..");
            actions.moveToElement(element).click().perform();
        }

        ExtentLogger.pass(elementName + " is clicked successfully");
    }

    public static void scrollDownToElement(By by, String elementName){
        WebElement element = DriverManager.getDriver().findElement(by);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ExtentLogger.pass(elementName + " is clicked successfully");
    }


    public static WebElement waitUntilElementToBeVisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), ConfigFactory.getConfig().timeout());
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private static WebElement waitUntilElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), ConfigFactory.getConfig().timeout());
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static boolean isElementDisplayed(By by){
        return DriverManager.getDriver().findElement(by).isDisplayed();
    }

    public static List<WebElement> elementList(By by){
        return DriverManager.getDriver().findElements(by);
    }

    public static void switchControlToTab(int index){
        DriverManager.getDriver().switchTo().window(DriverManager.getDriver().getWindowHandles().toArray()[index].toString());
    }

    public static String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }

    public static String getDynamincXpath(String xpath, String text){
        return String.format(xpath, text);
    }

    public static String getDynamincXpath(String xpath, int digit){
        return String.format(xpath, digit);
    }
}

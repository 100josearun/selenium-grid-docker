package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.amazon.utils.SeleniumUtils.*;

public class ProductDetailPage {

    private static final By PRODUCT_TITLE = By.xpath("//span[@id='productTitle']");
    private static final String ABOUT_THIS_ITEM_SECTION = "//h1[contains(.,'%s')]";
    private static final By ITEM_SECTION_DETAILS = By.xpath("//div[@id='feature-bullets']/ul/li");
    private static final By MORE_SECTION_DETAILS = By.xpath("//div[@id='feature-bullets']//div/ul/li");
    private static final By SHOW_MORE_LINK = By.xpath("//span[contains(.,'Show More')] | //a[@id='seeMoreDetailsLink']");
    private StringBuffer stringBuffer;
    private static String str = "";

    private ProductDetailPage verifyProduct(String sectionName){
        waitUntilElementToBeVisible(PRODUCT_TITLE);
        str = getDynamincXpath(ABOUT_THIS_ITEM_SECTION, sectionName);
        scrollDownToElement(By.xpath(str), "Scrolling to "+sectionName+" section.");
        return this;
    }

    private ProductDetailPage displayItemDetails(){
        List<WebElement> elementList = null;
        if(isElementDisplayed(By.xpath(str))){
            elementList = elementList(ITEM_SECTION_DETAILS);
            stringBuffer = new StringBuffer();
            for(WebElement webElement:elementList){
                stringBuffer.append(webElement.findElement(By.tagName("span")).getText()+"\n");
            }
        }
        if(isElementDisplayed(SHOW_MORE_LINK)){
            click(SHOW_MORE_LINK);
            elementList = elementList(MORE_SECTION_DETAILS);
            for(WebElement webElement:elementList){
                stringBuffer.append(webElement.findElement(By.tagName("span")).getText()+"\n");
            }
        }
        System.out.println(stringBuffer);
        return this;
    }

    public void displayElementDetails(String sectionName){
        verifyProduct(sectionName);
        displayItemDetails();
    }

}

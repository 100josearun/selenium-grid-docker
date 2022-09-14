package com.amazon.pages;

import org.openqa.selenium.By;

import static com.amazon.constants.TestConstants.HOME_PAGE_BREAD_CRUMP;
import static com.amazon.utils.SeleniumUtils.*;

public class HomePage {

    private static final By BREAD_CRUMP_MENU = By.id("nav-hamburger-menu");
    private static final String MENU_ITEM = "//div[@id='hmenu-content']//li/a[contains(., '%s')]";
    private static final String MENU_ITEM_CONTENT = "//div[@id='hmenu-content']/ul//li/a[contains(., '%s')]";
    private String str = "";

    public SearchResultsPage selectCategory(String section, String subsection){
        waitUntilElementToBeVisible(BREAD_CRUMP_MENU);
        waitAndClickElement(BREAD_CRUMP_MENU, HOME_PAGE_BREAD_CRUMP);
        str = getDynamincXpath(MENU_ITEM, section);
        waitUntilElementToBeVisible(By.xpath(str));
        waitAndClickElement(By.xpath(str), section);
        str = getDynamincXpath(MENU_ITEM_CONTENT, subsection);
        waitUntilElementToBeVisible(By.xpath(str));
        waitAndClickElement(By.xpath(str), subsection);
        return new SearchResultsPage();
    }

}

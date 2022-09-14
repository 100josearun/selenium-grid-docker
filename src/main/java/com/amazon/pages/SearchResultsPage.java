package com.amazon.pages;

import org.openqa.selenium.By;

import static com.amazon.utils.SeleniumUtils.*;

public class SearchResultsPage {

    private static final String BRANDS_FILTER = "//div[@id='s-refinements']/div//span[contains(., '%s')]";
    private static final String CHECKBOX_FILTER = "//div[@id='s-refinements']/div//a[contains(., '%s')]/div";
    private static final String SORT_BY_FILTER_OPTIONS = "//a[contains(@id,'s-result-sort-select') and contains(., '%s')]";
    private static final By SORT_BY_FILTER = By.id("a-autoid-0");
    private static final By SORT_BY_FILTER_DROPDOWN = By.xpath("//*[@class='a-popover-wrapper']//ul[@role='listbox']");
    private static final By SEARCH_RESULTS_CONTAINER = By.xpath("//*[contains(@class,'s-main-slot')]");
    private static final String SELECT_ELEMENT_AT_INDEX = "//div[@data-index='%d']";
    private String str = "";

    private SearchResultsPage filterResultsBy(String name, String option){
        str = getDynamincXpath(BRANDS_FILTER, name);
        scrollDownToElement(By.xpath(str), "Scrolling to "+name);
        str = getDynamincXpath(CHECKBOX_FILTER, option);
        waitAndClickElement(By.xpath(str), "Clicking Brands Checkbox :: "+option);
        return this;
    }

    private SearchResultsPage sortSearchResultsBy(String sortByOption){
        waitAndClickElement(SORT_BY_FILTER, "Clicking sort by filter");
        waitUntilElementToBeVisible(SORT_BY_FILTER_DROPDOWN);
        str = getDynamincXpath(SORT_BY_FILTER_OPTIONS, sortByOption);
        waitAndClickElement(By.xpath(str), "Sorting results by "+ sortByOption);
        waitUntilElementToBeVisible(SEARCH_RESULTS_CONTAINER);
        return this;
    }

    public ProductDetailPage filterAndSortResults(String filterBy, String filterByOption, String sortBy, int elementIndex){
        filterResultsBy(filterBy, filterByOption);
        sortSearchResultsBy(sortBy);
        str = getDynamincXpath(SELECT_ELEMENT_AT_INDEX, elementIndex);
//        clickUsingActions(By.xpath(str), "Selecting "+elementIndex+" element");
        click(By.xpath(str));
        switchControlToTab(1);
        return new ProductDetailPage();
    }

}

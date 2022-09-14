package com.amazon.tests;

import com.amazon.pages.HomePage;
import com.amazon.pages.SearchResultsPage;
import com.amazon.testdata.JsonData;
import com.amazon.utils.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.amazon.constants.TestConstants.*;
import static com.amazon.utils.SeleniumUtils.getPageTitle;

@Listeners(com.amazon.listeners.TestListener.class)
public class SearchResultsPageTest extends BaseTest{

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

    @Test(description = "Search Category - TV", dataProvider = "getTVData", dataProviderClass = DataProviderUtils.class)
    public void productSearchTV(JsonData data) throws InterruptedException {
        System.out.println(data.toString());
        homePage = new HomePage();
        Assert.assertEquals(getPageTitle(), HOME_PAGE_TITLE);
        searchResultsPage = homePage.selectCategory(data.getMenu(), data.getSubMenu());
        Assert.assertEquals(getPageTitle(), SEARCH_PAGE_TITLE_TV);
        searchResultsPage.filterAndSortResults(data.getCheckbox(), data.getBrandName(),data.getFilter(), data.getElementAt())
                .displayElementDetails(data.getSection());

        Thread.sleep(5000);
    }

    @Test(description = "Search Category - Mobile", dataProvider = "getMobilesData", dataProviderClass = DataProviderUtils.class)
    public void productSearchMobile(JsonData data) throws InterruptedException {
        System.out.println(data.toString());
        homePage = new HomePage();
        Assert.assertEquals(getPageTitle(), HOME_PAGE_TITLE);
        searchResultsPage = homePage.selectCategory(data.getMenu(), data.getSubMenu());
        Assert.assertEquals(getPageTitle(), SEARCH_PAGE_TITLE_MOBILE);
        searchResultsPage.filterAndSortResults(data.getCheckbox(), data.getBrandName(),data.getFilter(), data.getElementAt())
                .displayElementDetails(data.getSection());

        Thread.sleep(5000);
    }

}

package com.tvmaze.ui.test;

import com.tvmaze.ui.data.Data;
import com.tvmaze.ui.steps.SearchResultStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TVShowSearchResultTest extends AbstractTest {

    @Test(description = "UI ShowSearch test with valid data ",
            dataProvider = "partOfName", dataProviderClass = Data.class)
    public void testSearchResultContainsTVShow(String tvShowPartOfName) {
        SearchResultStep searchResultStep = new SearchResultStep().openSearchResultByRequest(tvShowPartOfName);
        Assert.assertTrue(searchResultStep.isSearchResultListContainsTVShow(tvShowPartOfName));
    }

    @Test(description = "UI ShowSearch test with invalid data ",
            dataProvider = "invalidRequest", dataProviderClass = Data.class)
    public void testSearchResultMessageWithInvalidRequest(String request) {
        SearchResultStep searchResultStep = new SearchResultStep().openSearchResultByRequest(request);
        Assert.assertTrue(searchResultStep.isSearchResultContainsExpectedMessage());
    }
}

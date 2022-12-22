package com.tvmaze.api.test;

import com.tvmaze.api.data.RequestedData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TVShowSearchTest extends AbstractTest {
    @Test(description = "API Search test ",dataProvider = "partOfName",dataProviderClass = RequestedData.class)
    public void testGetSearchResponseContainsTVShow(String tvShowPartOfName) {
        String url = "https://api.tvmaze.com/search/shows?q=" + tvShowPartOfName;
        client.sendGet(url);
        Assert.assertTrue(client.isResponseContainsTVShow(tvShowPartOfName));
    }
}

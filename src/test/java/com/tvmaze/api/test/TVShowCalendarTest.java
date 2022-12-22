package com.tvmaze.api.test;

import com.tvmaze.api.data.RequestedData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TVShowCalendarTest extends AbstractTest {
    @Test(description = "API Calendar test ",
            dataProvider = "calendarDateAndTVShowName", dataProviderClass = RequestedData.class)
    public void testGetResponseContainsShowOnDate(String date, String tvShowName) {
        String url = "https://api.tvmaze.com/schedule?country=US&date=" + date;
        client.sendGet(url);
        Assert.assertTrue(client.isResponseContainsTVShow(tvShowName));
    }
}


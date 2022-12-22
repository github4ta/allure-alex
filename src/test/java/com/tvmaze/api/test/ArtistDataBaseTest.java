package com.tvmaze.api.test;

import com.tvmaze.api.data.RequestedData;
import com.tvmaze.api.entity.Artist;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArtistDataBaseTest extends AbstractTest {
    @Test(description = "API artists database test ", dataProvider = "artist", dataProviderClass = RequestedData.class)
    public void testGetDatabaseResponseContainsArtist(Artist artist) {
        String url = "https://api.tvmaze.com/people?page=0";
        client.sendGet(url);
        Assert.assertTrue(client.isResponseContainsArtist(artist));
    }
}

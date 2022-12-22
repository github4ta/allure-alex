package com.tvmaze.api.data;

import com.tvmaze.api.entity.Artist;
import org.testng.annotations.DataProvider;

public class RequestedData {
    @DataProvider(name = "calendarDateAndTVShowName")
    public static Object[][] provideDateAndName() {
        return new Object[][]{{"2022-05-25", "The Flash"}, {"2022-04-07", "Walker"}, {"2022-06-12", "Barry"}};
    }

    @DataProvider(name = "partOfName")
    public static Object[] providePartOfTVShowName() {
        return new Object[]{"Law", "Family", "Girls"};
    }

    @DataProvider(name = "tvShowName")
    public static Object[] provideTVShowName() {
        return new Object[]{"Flash", "Walker", "Barry"};
    }

    @DataProvider(name = "artist")
    public static Object[] provideArtist() {
        return new Object[]{new Artist("Dean Norris", "1963-04-08","Male","United States"),
        new Artist("Mike Vogel","1979-07-17","Male","United States"),
        new Artist("Rachelle Lefevre","1979-02-01","Female","Canada")};
    }
}

package com.tvmaze.ui.data;

import org.testng.annotations.DataProvider;

public class Data {
    @DataProvider(name = "calendarDateAndTVShowName")
    public static Object[][] provideDateAndName() {
        return new Object[][]{{"25 May", "The Flash"}, {"07 April", "Walker"}, {"12 June", "Barry"}};
    }

    @DataProvider(name = "partOfName")
    public static Object[] providePartOfTVShowName() {
        return new Object[]{"Law", "Family", "Girls"};
    }

    @DataProvider(name = "invalidRequest")
    public static Object[] provideInvalidRequest() {
        return new Object[]{"rgregrgr", "%%", "llnb"};
    }
}

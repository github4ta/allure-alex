package com.tvmaze.ui.test;

import com.tvmaze.ui.data.Data;
import com.tvmaze.ui.steps.TVShowCalendarStep;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TVShowCalendarTest extends AbstractTest {

    @Ignore
    @Test(description = "UI ShowCalendar test",
            dataProvider = "calendarDateAndTVShowName", dataProviderClass = Data.class)
    public void testCalendarContainsShowOnDate(String date, String tvShowName) {
        TVShowCalendarStep tvShowCalendarStep = new TVShowCalendarStep().openTVSHowCalendarOnDate(date);
        Assert.assertTrue(tvShowCalendarStep.isCalendarOnDateContainsTVShow(tvShowName));
    }
}

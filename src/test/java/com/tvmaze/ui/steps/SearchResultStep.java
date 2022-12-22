package com.tvmaze.ui.steps;

import com.tvmaze.ui.entity.TVShow;
import com.tvmaze.ui.pages.AuthorizedHomePage;
import com.tvmaze.ui.pages.SearchResultPage;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultStep extends SearchResultPage {
    List<TVShow> tvShowList;
    String expectedSearchResultMassage = "Pardon us, but no shows or people matching your query were found";

    @Step("Search request:  {0}")
    public SearchResultStep openSearchResultByRequest(String searchRequest) {
        new AuthorizedHomePage()
                .typeSearchRequestAndSend(searchRequest);
        logger.info("Part of TVShow name: " + searchRequest);
        return this;
    }

    @Step(" Create search ShowList ")
    @Attachment
    public List<TVShow> createSearchResultList() {
        String episodeName;
        tvShowList = new ArrayList<>();
        for (WebElement tvShowCard : tvShowCardList) {
            String tvShowName = tvShowCard.findElement(By.xpath(".//*[@class='showname']//a")).getText();
            try {
                episodeName = tvShowCard.findElement(By.xpath(".//*[@class='auto cell episode-info']//a")).getText();
            } catch (Exception e) {
                episodeName = "no name";
            }
            tvShowList.add(new TVShow(tvShowName, episodeName));
        }
        logger.info(tvShowList);
        return tvShowList;
    }

    @Step("is Search result contains TVShow: {0}")
    @Attachment
    public boolean isSearchResultListContainsTVShow(String tvShow) {
        if (tvShowList == null) {
            tvShowList = createSearchResultList();
        }
        return tvShowList.stream().anyMatch(s -> s.getShowName().contains(tvShow));
    }

    public boolean isSearchResultContainsExpectedMessage() {
        String message=searchResultMessageField.getText();
        logger.info("Message: " + message);
        Allure.addAttachment("Search result message ",message);
        return message.contains(expectedSearchResultMassage);
    }
}


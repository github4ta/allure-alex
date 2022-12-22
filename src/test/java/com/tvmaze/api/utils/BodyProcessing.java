package com.tvmaze.api.utils;

import com.tvmaze.api.client.CustomClient;
import com.tvmaze.api.entity.Artist;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BodyProcessing {
    @Step("Create TvShowList")
    @Attachment
    private static List<String> createTVShowNameList(String body) {
        List<String> tvShowList = new ArrayList<>();
        if (body.startsWith("[")) {
            JSONArray jsonArray = new JSONArray(body);
            List<JSONObject> jsonObjectList = new ArrayList<>();
            for (Object jsonObject : jsonArray) {
                jsonObjectList.add(((JSONObject) jsonObject).getJSONObject("show"));
            }
            for (JSONObject jsonObject : jsonObjectList) {
                tvShowList.add(jsonObject.getString("name"));
            }
        } else {
            JSONObject jsonObject = new JSONObject(body);
            tvShowList.add(jsonObject.getString("name"));
        }
        CustomClient.logger.info("TVShow names: " + tvShowList);
        return tvShowList;
    }
    @Step("Create ArtistList")
    @Attachment
    private static List<Artist> createArtistList(String body) {
        List<Artist> artistList = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(body);
        for (Object jsonObject : jsonArray) {
            String name = (((JSONObject) jsonObject).getString("name"));
            String birthday = (((JSONObject) jsonObject).get("birthday")).toString();
            String gender = (((JSONObject) jsonObject).get("gender")).toString();
            String birthPlace;
           try {
                birthPlace = (((JSONObject) jsonObject).getJSONObject("country").getString("name"));
           }catch (Exception e){
                birthPlace =(((JSONObject) jsonObject).get("country")).toString();
           }
           artistList.add(new Artist(name, birthday, gender, birthPlace));
        }
        CustomClient.logger.info(artistList);
        return artistList;
    }

    @Step("is response contains TVShow: {0}")
    @Attachment
    public static boolean isResponseContainsTVShow(String tvShow, String body) {
        return createTVShowNameList(body).stream().anyMatch(s -> s.contains(tvShow));
    }
    @Step("is response contains : {0}")
    @Attachment
    public static boolean isResponseContainsArtist(Artist artist, String body) {
        CustomClient.logger.info("Search : "+artist);
        return createArtistList(body).stream().anyMatch(s -> s.equals(artist));
    }
}

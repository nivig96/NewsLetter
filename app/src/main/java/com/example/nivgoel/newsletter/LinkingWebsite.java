package com.example.nivgoel.newsletter;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by nivgoel on 07-03-2018.
 */

public interface LinkingWebsite {
//    String BASE_URL="https://newsapi.org/";

//    @GET("v2/top-headlines?sources=usa-today&apiKey=d63a0f48d3564a02b866c7b7c1058e2d")

    String BASE_URL="https://newsapi.org/";
    String TYPE = "v2/top-headlines?sources=";
    String NEWSFROM = "usa-today";
    String APIKEY = "d63a0f48d3564a02b866c7b7c1058e2d";

    Call<NewsList> getNewsList();
}

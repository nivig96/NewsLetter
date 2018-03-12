package com.example.nivgoel.newsletter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by nivgoel on 07-03-2018.
 */

public class NewsList {
    private String status;
    private int totalResults;
    @SerializedName("articles")
    @Expose
    private ArrayList<Articles> articles;

    public NewsList(String status, int totalResults, ArrayList<Articles> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public ArrayList<Articles> getArticles() {
        return articles;
    }
}

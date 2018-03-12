package com.example.nivgoel.newsletter;

/**
 * Created by nivgoel on 07-03-2018.
 */

public class Articles {
//    @SerializedName("source")
//    private Source source;
    private String title;
    private String description;
    private String url;
    private String URLtoImage;

    public Articles(String title, String description, String url, String URLtoImage) {
//        this.source = source;
        this.title = title;
        this.description = description;
        this.url = url;
        this.URLtoImage = URLtoImage;
    }

//    public Source getSource() {
//        return source;
//    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getURLtoImage() {
        return URLtoImage;
    }
}

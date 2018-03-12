package com.example.nivgoel.newsletter;

/**
 * Created by nivgoel on 07-03-2018.
 */

public class Source {
    private String id;
    private String name;

    public Source(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String   getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

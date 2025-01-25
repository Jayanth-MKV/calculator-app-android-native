package com.jay.mynotes;

public class Model {
    String title;
    String description;
    String url;

    public Model(String title, String description, String url) {
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public Model() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }
}

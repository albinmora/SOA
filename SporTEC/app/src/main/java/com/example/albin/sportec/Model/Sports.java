package com.example.albin.sportec.Model;

public class Sports{

    private String sport;
    private String image;

    public Sports(String content, String imageResource) {
        this.sport = content;
        this.image = imageResource;
    }

    public Sports(){

    }

    public String getContent() {
        return sport;
    }

    public void setContent(String content) {
        this.sport = content;
    }

    public String getImageResource() {
        return image;
    }

    public void setImageResource(String imageResource) {
        this.image = imageResource;
    }
}

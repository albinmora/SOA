package com.example.albin.sportec.Model;

public class News{

    // Members variables
    private String mId;
    private String mTitle;
    private String mDate;
    private String mNewsDody;

    //Getters
    public String getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDate() {
        return mDate;
    }

    public String getNewsDody() {
        return mNewsDody;
    }

    //Constructor
    public News(String pId,String pTitle, String pDate, String pNewsDody){
        this.mId = pId;
        this.mTitle = pTitle;
        this.mDate = pDate;
        this.mNewsDody = pNewsDody;
    }

}

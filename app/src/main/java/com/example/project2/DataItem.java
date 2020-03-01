package com.example.project2;


public class DataItem {
    private int imageID;
    private String titles;
    private String years;

    public DataItem(int imageID, String titles, String years){
        this.imageID = imageID;
        this.titles = titles;
        this.years = years;
    }

    public int getImageID(){
        return imageID;
    }
    public String getTitles(){
        return titles;
    }
    public String getYears(){
        return years;
    }

    @Override
    public String toString() { return titles + "\n" + years;}
}
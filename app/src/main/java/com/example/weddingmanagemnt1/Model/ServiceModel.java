package com.example.weddingmanagemnt1.Model;

public class ServiceModel {
    private String TvName;
    private String Forekans;
    private String BistoHaft;
    private String Horizental;
    private int ImageSrc;


    // constructor
    public ServiceModel(String tvName, int imageSrc) {
        TvName = tvName;

        ImageSrc = imageSrc;
    }

    //getter
    public String getTvName() {
        return TvName;
    }
    //getter

    public String getForekans() {
        return Forekans;
    }

    public String getBistoHaft() {
        return BistoHaft;
    }
    //getter

    public int getImageSrc() {
        return ImageSrc;
    }

    public String getHorizental() {
        return Horizental;
    }
}


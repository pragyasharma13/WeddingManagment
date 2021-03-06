package com.example.weddingmanagemnt1.Model;


import com.example.weddingmanagemnt1.R;

public class VideoDatabase {

    // I am going to define here the projectdatabase, public static and constant,
    // so that every class in the project will be able to read it.
    // In a sense, we just mimic the standard behaviour of a database.
    public static final VideoDatabase[] VIDEO = new VideoDatabase[]{
            new VideoDatabase("GOOD NIGHT", R.drawable.banner3),
            new VideoDatabase("GOOD MORNING", R.drawable.banner4),

        };

    // The fields associated to the person
    private final String mVideoName;
    private final int mImage;

    VideoDatabase(String name, int image) {
        mVideoName = name;
        mImage = image;

    }

    // This method allows to get the item associated to a particular id,
    // uniquely generated by the method getId defined below
    public static VideoDatabase getItem(int id) {
        for (VideoDatabase item : VIDEO) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    // since mName and mPhone combined are surely unique,
    // we don't need to add another id field
    public int getId() {
        return mVideoName.hashCode();
    }

    public static enum Field {
        NAME, IMAGE
    }

    public String get(Field f) {
        switch (f) {
            case NAME:
            default:
                return mVideoName;
        }
    }

    public int geti(Field f) {
        switch (f) {
            case IMAGE:

        }
        return mImage;
    }
}

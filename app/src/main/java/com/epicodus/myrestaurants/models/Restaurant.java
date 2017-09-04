package com.epicodus.myrestaurants.models;

import org.parceler.Parcel;

import java.util.ArrayList;

@Parcel
public class Restaurant {
    private String myName;
    private String myPhone;
    private String myWebsite;
    private double myRating;
    private String myImageUrl;
    private ArrayList<String> myAddress = new ArrayList<>();
    private double mylatitude;
    private double myLongitude;
    private ArrayList<String> myCategories = new ArrayList<>();

    public Restaurant(){}

    public Restaurant(String name, String phone, String website, double rating, String imageurl, ArrayList<String> address,
                      double latitude, double longitude, ArrayList<String> categories){
        this.myName = name;
        this.myPhone = phone;
        this.myWebsite = website;
        this.myRating = rating;
        this.myImageUrl = imageurl;
        this.myAddress = address;
        this.mylatitude = latitude;
        this.myLongitude = longitude;
        this.myCategories = categories;

    }
    public String getName(){
        return myName;
    }
    public String getPhone(){
        return myPhone;
    }
    public String getWebsite() {
        return  myWebsite;
    }

    public double getRating() {
        return myRating;
    }

    public String getImageUrl(){
        return myImageUrl;
    }

    public ArrayList<String> getAddress() {
        return myAddress;
    }

    public double getLatitude() {
        return mylatitude;
    }

    public double getLongitude() {
        return myLongitude;
    }

    public ArrayList<String> getCategories() {
        return myCategories;
    }
}

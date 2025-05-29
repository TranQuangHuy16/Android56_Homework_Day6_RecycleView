package com.example.android56_homework_day6_recyclerview.models;

import java.io.Serializable;

public class Product implements Serializable {
    private String title;
    private String description;
    private int price;
    private float rating;
    private int reviews;
    private String imageResId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageResId() {
        return imageResId;
    }

    public void setImageResId(String imageResId) {
        this.imageResId = imageResId;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product(String title, String imageResId, int reviews, float rating, int price, String description) {
        this.title = title;
        this.imageResId = imageResId;
        this.reviews = reviews;
        this.rating = rating;
        this.price = price;
        this.description = description;
    }

    public Product() {
    }
}

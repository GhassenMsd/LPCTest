package com.example.lpctest.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pot {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("creationDate")
    @Expose
    private String creationDate;

    @SerializedName("category")
    @Expose
    private int category;

    @SerializedName("contributorsCount")
    @Expose
    private int contributorsCount;

    @SerializedName("amount")
    @Expose
    private float amount;

    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    public Pot(String id,String name, String creationDate, int category, int contributorsCount, float amount, String imageUrl) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.category = category;
        this.contributorsCount = contributorsCount;
        this.amount = amount;
        this.imageUrl = imageUrl;
    }
    public Pot(String id,String name, String creationDate, int category, int contributorsCount, float amount) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.category = category;
        this.contributorsCount = contributorsCount;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getContributorsCount() {
        return contributorsCount;
    }

    public void setContributorsCount(int contributorsCount) {
        this.contributorsCount = contributorsCount;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Pot{" +
                "name='" + name + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", category=" + category +
                ", contributorsCount=" + contributorsCount +
                ", amount=" + amount +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}

package com.uit.finalproject.model;

public class UserAssetLink {
    private UALId id;
    private String createdOn;
    private String assetName;
    private String parentAssetName;
    private String userFullName;

    public UALId getId() {
        return id;
    }

    public void setId(UALId id) {
        this.id = id;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getParentAssetName() {
        return parentAssetName;
    }

    public void setParentAssetName(String parentAssetName) {
        this.parentAssetName = parentAssetName;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    @Override
    public String toString() {
        return "UserAssetLink{" +
                "id=" + id +
                ", createdOn='" + createdOn + '\'' +
                ", assetName='" + assetName + '\'' +
                ", parentAssetName='" + parentAssetName + '\'' +
                ", userFullName='" + userFullName + '\'' +
                '}';
    }
}

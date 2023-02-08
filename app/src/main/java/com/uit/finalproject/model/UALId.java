package com.uit.finalproject.model;

public class UALId {
    private String realm;
    private String userId;
    private String assetId;

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    @Override
    public String toString() {
        return "UALId{" +
                "realm='" + realm + '\'' +
                ", userId='" + userId + '\'' +
                ", assetId='" + assetId + '\'' +
                '}';
    }
}

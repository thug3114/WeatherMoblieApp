package com.uit.finalproject;

import com.uit.finalproject.model.Asset;
import com.uit.finalproject.model.UserAssetLink;

import java.util.List;


import java.util.List;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface APIInterface {
    @GET("api/master/asset/user/link")
    Call<List<UserAssetLink>> getAllAssetLink();

    @GET("api/master/asset/{assetID}")
    Call<Asset> getAsset(@Path("assetID") String assetID);
}

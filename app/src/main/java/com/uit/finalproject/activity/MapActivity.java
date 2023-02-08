package com.uit.finalproject.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.uit.finalproject.APIClient;
import com.uit.finalproject.APIInterface;
import com.uit.finalproject.R;
import com.uit.finalproject.model.Asset;
import com.uit.finalproject.model.UserAssetLink;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private ArrayList myAssetIDs= new ArrayList();;
    LatLng latLngAsset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.myMap);
        mapFragment.getMapAsync(this);



    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        setMarker(googleMap);
    }



    public void setMarker(GoogleMap googleMap) {
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<Asset> call = apiInterface.getAsset("6H4PeKLRMea1L0WsRXXWp9");
        call.enqueue(new Callback<Asset>() {
            @Override
            public void onResponse(Call<Asset> call, Response<Asset> response) {
                Asset asset = response.body();
                //Log.d ("API CALL", asset.toString());

                Double latAsset = asset.getAttributes().getWeatherData().getValue().getCoord().getLat();
                Double lonAsset = asset.getAttributes().getWeatherData().getValue().getCoord().getLon();
                latLngAsset = new LatLng(latAsset,lonAsset);
                        googleMap.addMarker(new MarkerOptions()
                        .position(latLngAsset)
                        .title("Weather Asset"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLngAsset));
                googleMap.animateCamera(CameraUpdateFactory.zoomTo(16), 3000, null);

            }

            @Override
            public void onFailure(Call<Asset> call, Throwable t) {
                Log.d("API CALL", t.getMessage().toString());
            }
        });

        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                //show dialog confirm
                DialogAsset();
                return false;
            }
        });

    }

    private void DialogAsset() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.custom_dialog_marker,null);

        Button detailBtn = (Button) view.findViewById(R.id.btn_dialog_detail);
        Button cancellBtn = (Button) view.findViewById(R.id.btn_dialog_cancel);

        detailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MapActivity.this,AssetInfo.class);
                startActivity(i);
            }
        });

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setView(view)
                .create();
        alertDialog.show();

        cancellBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });


    }
//    public void getAllAssetLink(){
//        APIInterface apiInterface;
//        apiInterface = APIClient.getClient().create(APIInterface.class);
//        Call<List<UserAssetLink>> callUAL = apiInterface.getAllAssetLink();
//        callUAL.enqueue(new Callback<List<UserAssetLink>>() {
//            @Override
//            public void onResponse(Call<List<UserAssetLink>> call, Response<List<UserAssetLink>> response) {
//                if (response.isSuccessful()){
//                    List<UserAssetLink> userAssetLinks = response.body();
//                    getAssetIds(userAssetLinks);
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<UserAssetLink>> call, Throwable t) {
//                Log.d("API CALL", "(GET):UserAssetLink "+t.getMessage().toString());
//            }
//        });
//    }
//
//
//
//    public void getAssetIds(List<UserAssetLink> userAssetLinks){
//        for (int i = 0; i< userAssetLinks.size();i++) {
//            String assetName = userAssetLinks.get(i).getAssetName();
//            if (assetName=="WeatherAsset") {
//                String x = userAssetLinks.get(i).getId().getAssetId();
//                myAssetIDs.add(x);
//            }
//        }
//        Log.d("API CALL", myAssetIDs.toString());
//        getCoords(myAssetIDs);
//    }
//
//    public void getCoords(ArrayList myAssetIDs){
//
//    }

}
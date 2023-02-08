package com.uit.finalproject.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.uit.finalproject.APIClient;
import com.uit.finalproject.APIInterface;
import com.uit.finalproject.R;
import com.uit.finalproject.fragment.FragmentValue;
import com.uit.finalproject.fragment.ValueFragment;
import com.uit.finalproject.model.Asset;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AssetInfo extends AppCompatActivity {

    Asset asset;
    String[] strValue;
    String[] attribute_item = {"temperature","humidity", "windDirection","windSpeed"};

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;

    Button btn;
    FragmentManager fragmentManager;

    TextView tvName, tvValue, tvUnit, tvTime, tvType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_info);

        autoCompleteTextView = findViewById(R.id.dropdown_menu);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_attribute_item,attribute_item);
        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                getAsset(item);
            }
        });
    }

    public void getAsset(String item){
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<Asset> call = apiInterface.getAsset("6H4PeKLRMea1L0WsRXXWp9");
        call.enqueue(new Callback<Asset>() {
            @Override
            public void onResponse(Call<Asset> call, Response<Asset> response) {
                asset = response.body();
                strValue = getStringValue(item, asset);
                //Log.d("api call1",strValue[0]+" "+strValue[1]+" "+strValue[2]+" "+strValue[3]+" "+strValue[4]);
                Log.d("API CALL", "c");
                pushtoActivity(strValue);

            }
            @Override
            public void onFailure(Call<Asset> call, Throwable t) {
                Log.d("API CALL", t.getMessage().toString());
            }
        });
    }

    private void pushtoActivity(String[] strValue) {
        String time = convertTStamp(strValue[3]);
        initFindbyId();
        tvName.setText(strValue[0]);
        tvValue.setText(strValue[1]);
        tvUnit.setText(strValue[2]);
        tvTime.setText(time);
        tvType.setText(strValue[4]);
    }

    private String convertTStamp(String s) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(Long.parseLong(s));
        Date d = cal.getTime();
        return d.toString();
    }

    private void initFindbyId() {
        tvName = findViewById(R.id.tv_attr_name);
        tvValue = findViewById(R.id.tv_attr_value);
        tvUnit = findViewById(R.id.tv_attr_unit);
        tvTime = findViewById(R.id.tv_attr_time);
        tvType = findViewById(R.id.tv_attr_type);
    }


    private String[] getStringValue(String item, Asset asset) {
        String[] strV = {};
        if (item == "temperature") {
            strV = new String[]{"Temperature",asset.getAttributes().getTemperature().getValue().toString(),"°C",asset.getAttributes().getTemperature().getTimestamp().toString(),asset.getAttributes().getTemperature().getType()};
        }else if (item == "humidity") {
            strV = new String[]{"Humidity",asset.getAttributes().getHumidity().getValue().toString(),"%",asset.getAttributes().getHumidity().getTimestamp().toString(),asset.getAttributes().getHumidity().getType()};
        }else if (item == "weatherData") {
            strV = new String[]{"WeatherData"};
        }else if (item == "windDirection") {
            strV = new String[]{"Wind Direction",asset.getAttributes().getWindDirection().getValue().toString(),"degree",asset.getAttributes().getWindDirection().getTimestamp().toString(),asset.getAttributes().getWindDirection().getType()};
        }else if (item == "windSpeed") {
            strV = new String[]{"Wind Speed",asset.getAttributes().getWindSpeed().getValue().toString(),"mph",asset.getAttributes().getWindSpeed().getTimestamp().toString(),asset.getAttributes().getWindSpeed().getType()};
        }
        return strV;
    }

}



package com.uit.finalproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.google.gson.internal.LinkedTreeMap;
import com.uit.finalproject.APIClient;
import com.uit.finalproject.APIInterface;
import com.uit.finalproject.R;
import com.uit.finalproject.model.Asset;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AndroidChart extends AppCompatActivity {

    APIInterface apiInterface;
    static ArrayList<Entry> labelswindSpeed = new ArrayList<>();
    static ArrayList<Entry> labelsTemperature = new ArrayList<>();
    static ArrayList<Entry> labelsHumidity = new ArrayList<>();
    static ArrayList<Entry> labelswindDirection = new ArrayList<>();

    static  ArrayList<Float> lwindSpeed = new ArrayList<Float>();
    static  ArrayList<Float> lTemperature = new ArrayList<Float>();
    static  ArrayList<Float> lHumidity = new ArrayList<Float>();
    static  ArrayList<Float> lwindDirection = new ArrayList<Float>();

    static LineChart lineChartwindSpeed;
    static LineChart lineChartTemperature;
    static LineChart lineChartHumidity;
    static LineChart lineChartwindDirection;

    static LineData lineDatawindSpeed;
    static LineData lineDataTemperature;
    static LineData lineDataHumidity;
    static LineData lineDatawindDirection;

    Asset asset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_chart);
        apiInterface = APIClient.getClient().create(APIInterface.class);

        lineChartwindSpeed = findViewById(R.id.windSpeed);
        lineChartTemperature = findViewById(R.id.temperature);
        lineChartHumidity = findViewById(R.id.humidity);
        lineChartwindDirection = findViewById(R.id.windDirection);

        createbieudowindSpeed(labelswindSpeed);
        createbieudoTemperature(labelsTemperature);
        createbieudoHumidity(labelsHumidity);
        createbieudowindDirection(labelswindDirection);

//        Log.d("API CALL", "lables windspeed"+labelswindSpeed);

        final Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                getAsset();
                h.postDelayed(this, 10000);
            }
        }, 1000);
    }

    public void getAsset(){
        Call<Asset> call = apiInterface.getAsset("6H4PeKLRMea1L0WsRXXWp9");
        call.enqueue(new Callback<Asset>() {
            @Override
            public void onResponse(Call<Asset> call, Response<Asset> response) {
                asset = response.body();
                Log.d("API CALL", "c"+asset.getAttributes().getWindSpeed().getValue());
                Float windSpeed = Float.parseFloat(asset.getAttributes().getWindSpeed().getValue().toString());
                Float Temperature = Float.parseFloat(asset.getAttributes().getTemperature().getValue().toString());
                Float Humidity = Float.parseFloat(asset.getAttributes().getHumidity().getValue().toString());
                Float windDirection = Float.parseFloat(asset.getAttributes().getWindDirection().getValue().toString());
                addlableswindSpeed(labelswindSpeed, windSpeed);
                addlablesTemperature(labelsTemperature, Temperature);
                addlablesHumidity(labelsHumidity, Humidity);
                addlableswindDirection(labelswindDirection, windDirection);
                Log.d("API CALL", labelswindSpeed.toString());
            }
            @Override
            public void onFailure(Call<Asset> call, Throwable t) {
                Log.d("API CALL", t.getMessage().toString());
            }
        });
    }

    public void createbieudowindSpeed(List<Entry> labels2) {

        AndroidChart.lwindSpeed.add((float) 0);
        AndroidChart.lwindSpeed.add((float) 0);
        AndroidChart.lwindSpeed.add((float) 0);
        AndroidChart.lwindSpeed.add((float) 0);
        labels2.add(new Entry(0, lwindSpeed.get(0)));
        labels2.add(new Entry(1, lwindSpeed.get(1)));
        labels2.add(new Entry(2, lwindSpeed.get(2)));
        labels2.add(new Entry(3, lwindSpeed.get(3)));
        Log.d("API CALL", "lableswindSpeed"+labels2);

        LineDataSet lineDataSet = new LineDataSet(labels2, "Wind speed");

        lineDataSet.setColor(Color.CYAN);
        lineDataSet.setValueTextSize(10f);
        lineDataSet.setLineWidth(2);
        lineDataSet.setCircleRadius(6);
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setDrawHorizontalHighlightIndicator(false);
        lineDataSet.setDrawHighlightIndicators(false);
        lineDataSet.setValueFormatter(new DefaultAxisValueFormatter(3));

        lineDatawindSpeed = new LineData(lineDataSet);
        lineChartwindSpeed.getDescription().setTextSize(12);
        lineChartwindSpeed.getDescription().setEnabled(false);
        lineChartwindSpeed.setData(lineDatawindSpeed);
        lineChartwindSpeed.setDrawGridBackground(false);

        XAxis xAxis = lineChartwindSpeed.getXAxis();
        xAxis.setLabelCount(4);
        xAxis.setAxisMaximum(4);
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        YAxis yAxis = lineChartwindSpeed.getAxisLeft();
        yAxis.setAxisMaximum(5);
        yAxis.setDrawGridLines(false);
    }

    public void createbieudoTemperature(List<Entry> labels2) {

        AndroidChart.lTemperature.add((float) 0);
        AndroidChart.lTemperature.add((float) 0);
        AndroidChart.lTemperature.add((float) 0);
        AndroidChart.lTemperature.add((float) 0);
        labels2.add(new Entry(0, lTemperature.get(0)));
        labels2.add(new Entry(1, lTemperature.get(1)));
        labels2.add(new Entry(2, lTemperature.get(2)));
        labels2.add(new Entry(3, lTemperature.get(3)));
        Log.d("API CALL", "lablesTemperature"+labels2);

        LineDataSet lineDataSet = new LineDataSet(labels2, "Temperature");

        lineDataSet.setColor(Color.CYAN);
        lineDataSet.setValueTextSize(10f);
        lineDataSet.setLineWidth(2);
        lineDataSet.setCircleRadius(6);
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setDrawHorizontalHighlightIndicator(false);
        lineDataSet.setDrawHighlightIndicators(false);
        lineDataSet.setValueFormatter(new DefaultAxisValueFormatter(3));

        lineDataTemperature = new LineData(lineDataSet);
        lineChartTemperature.getDescription().setTextSize(12);
        lineChartTemperature.getDescription().setEnabled(false);
        lineChartTemperature.setData(lineDataTemperature);
        lineChartTemperature.setDrawGridBackground(false);

        XAxis xAxis = lineChartTemperature.getXAxis();
        xAxis.setLabelCount(4);
        xAxis.setAxisMaximum(4);
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        YAxis yAxis = lineChartTemperature.getAxisLeft();
        yAxis.setAxisMaximum(100);
        yAxis.setDrawGridLines(false);
    }

    public void createbieudoHumidity(List<Entry> labels2) {

        AndroidChart.lHumidity.add((float) 0);
        AndroidChart.lHumidity.add((float) 0);
        AndroidChart.lHumidity.add((float) 0);
        AndroidChart.lHumidity.add((float) 0);
        labels2.add(new Entry(0, lHumidity.get(0)));
        labels2.add(new Entry(1, lHumidity.get(1)));
        labels2.add(new Entry(2, lHumidity.get(2)));
        labels2.add(new Entry(3, lHumidity.get(3)));
        Log.d("API CALL", "lableswindSpeed"+labels2);

        LineDataSet lineDataSet = new LineDataSet(labels2, "Humidity");

        lineDataSet.setColor(Color.CYAN);
        lineDataSet.setValueTextSize(10f);
        lineDataSet.setLineWidth(2);
        lineDataSet.setCircleRadius(6);
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setDrawHorizontalHighlightIndicator(false);
        lineDataSet.setDrawHighlightIndicators(false);
        lineDataSet.setValueFormatter(new DefaultAxisValueFormatter(3));

        lineDataHumidity = new LineData(lineDataSet);
        lineChartHumidity.getDescription().setTextSize(12);
        lineChartHumidity.getDescription().setEnabled(false);
        lineChartHumidity.setData(lineDataHumidity);
        lineChartHumidity.setDrawGridBackground(false);

        XAxis xAxis = lineChartHumidity.getXAxis();
        xAxis.setLabelCount(4);
        xAxis.setAxisMaximum(4);
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        YAxis yAxis = lineChartHumidity.getAxisLeft();
        yAxis.setAxisMaximum(100);
        yAxis.setDrawGridLines(false);
    }

    public void createbieudowindDirection(List<Entry> labels2) {

        AndroidChart.lwindDirection.add((float) 0);
        AndroidChart.lwindDirection.add((float) 0);
        AndroidChart.lwindDirection.add((float) 0);
        AndroidChart.lwindDirection.add((float) 0);
        labels2.add(new Entry(0, lwindDirection.get(0)));
        labels2.add(new Entry(1, lwindDirection.get(1)));
        labels2.add(new Entry(2, lwindDirection.get(2)));
        labels2.add(new Entry(3, lwindDirection.get(3)));
        Log.d("API CALL", "lableswindSpeed"+labels2);

        LineDataSet lineDataSet = new LineDataSet(labels2, "Wind Direction");

        lineDataSet.setColor(Color.CYAN);
        lineDataSet.setValueTextSize(10f);
        lineDataSet.setLineWidth(2);
        lineDataSet.setCircleRadius(6);
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setDrawHorizontalHighlightIndicator(false);
        lineDataSet.setDrawHighlightIndicators(false);
        lineDataSet.setValueFormatter(new DefaultAxisValueFormatter(3));

        lineDatawindDirection = new LineData(lineDataSet);
        lineChartwindDirection.getDescription().setTextSize(12);
        lineChartwindDirection.getDescription().setEnabled(false);
        lineChartwindDirection.setData(lineDatawindDirection);
        lineChartwindDirection.setDrawGridBackground(false);

        XAxis xAxis = lineChartwindDirection.getXAxis();
        xAxis.setLabelCount(4);
        xAxis.setAxisMaximum(4);
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        YAxis yAxis = lineChartwindDirection.getAxisLeft();
        yAxis.setAxisMaximum(360);
        yAxis.setDrawGridLines(false);
    }

    public static void addlableswindSpeed(List<Entry> labels2, float y) {
        AndroidChart.lwindSpeed.remove(0);
        AndroidChart.lwindSpeed.add(y);
        for (int j=0; j<=3; j++) {
            labels2.set(j, new Entry(j, lwindSpeed.get(j)));
            lineDatawindSpeed.notifyDataChanged();
        }
//        Log.d("API CALL", "add data"+labels2.toString());
        lineChartwindSpeed.invalidate();
    }

    public static void addlablesTemperature(List<Entry> labels2, float y) {
        AndroidChart.lTemperature.remove(0);
        AndroidChart.lTemperature.add(y);
        for (int j=0; j<=3; j++) {
            labels2.set(j, new Entry(j, lTemperature.get(j)));
            lineDataTemperature.notifyDataChanged();
        }
//        Log.d("API CALL", "add data"+labels2.toString());
        lineChartTemperature.invalidate();
    }

    public static void addlablesHumidity(List<Entry> labels2, float y) {
        AndroidChart.lHumidity.remove(0);
        AndroidChart.lHumidity.add(y);
        for (int j=0; j<=3; j++) {
            labels2.set(j, new Entry(j, lHumidity.get(j)));
            lineDataHumidity.notifyDataChanged();
        }
//        Log.d("API CALL", "add data"+labels2.toString());
        lineChartHumidity.invalidate();
    }

    public static void addlableswindDirection(List<Entry> labels2, float y) {
        AndroidChart.lwindDirection.remove(0);
        AndroidChart.lwindDirection.add(y);
        for (int j=0; j<=3; j++) {
            labels2.set(j, new Entry(j, lwindDirection.get(j)));
            lineDatawindDirection.notifyDataChanged();
        }
//        Log.d("API CALL", "add data"+labels2.toString());
        lineChartwindDirection.invalidate();
    }
}
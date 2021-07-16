package com.example.weather2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private StationAdapter stations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.stations_list);
        spinner.setOnItemSelectedListener(this);
        new StationsProvider(this, getResources().getString(R.string.weather_api_url)).execute();
    }

    public void updateSpin(ArrayList<Station> stationsList) {
        Spinner spinner = findViewById(R.id.stations_list);
        stations = new StationAdapter(this, spinner, stationsList);
        stations.updateView();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Log.d("papi", text);
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

        Station station = stations.getItemByName(text);
        new WeatherLogProvider(this, getResources().getString(R.string.weather_api_url), station).execute();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void updateWeatherLog(WeatherLog weatherLog) {
        TableLayout tableLayout = findViewById(R.id.weatherLog);
        WeatherLogAdapter weatherLogAdapter = new WeatherLogAdapter(this, tableLayout, weatherLog);
        weatherLogAdapter.updateView();
    }
}
package com.example.weather2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WeatherLogAdapter extends BaseAdapter {
    private TableLayout tableLayout;
    private MainActivity mainActivity;
    private WeatherLog weatherLog;

    public WeatherLogAdapter(MainActivity mainActivity, TableLayout tableLayout, WeatherLog weatherLog) {
        this.mainActivity = mainActivity;
        this.tableLayout = tableLayout;
        this.weatherLog = weatherLog;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return weatherLog;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    public void updateView () {
        ((TextView)tableLayout.findViewById(R.id.place)).setText(weatherLog.getPlace());
        ((TextView)tableLayout.findViewById(R.id.datetime)).setText(weatherLog.getDateTime());
        ((TextView)tableLayout.findViewById(R.id.pressure)).setText(weatherLog.getPressure().toString());
        ((TextView)tableLayout.findViewById(R.id.humidity)).setText(weatherLog.getHumidity().toString());
        ((TextView)tableLayout.findViewById(R.id.minTemp)).setText(weatherLog.getMinTemp().toString());
        ((TextView)tableLayout.findViewById(R.id.maxTemp)).setText(weatherLog.getMaxTemp().toString());
        ((TextView)tableLayout.findViewById(R.id.rain)).setText(weatherLog.getRain().toString());
        ((TextView)tableLayout.findViewById(R.id.windSpeed)).setText(weatherLog.getWindSpeed().toString());
    }
}

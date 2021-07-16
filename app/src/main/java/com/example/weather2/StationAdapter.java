package com.example.weather2;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class StationAdapter  extends BaseAdapter {
    private Spinner spinner;
    private MainActivity mainActivity;
    private ArrayList<Station> stations;

    public StationAdapter(MainActivity mainActivity, Spinner spinner, ArrayList<Station> stations) {
        this.mainActivity = mainActivity;
        this.spinner = spinner;
        this.stations = stations;
    }

    @Override
    public int getCount() {
        return stations.size();
    }

    @Override
    public Object getItem(int position) {
        return stations.get(position).getName();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Station getItemByName(String name) {
        return stations.stream().filter(station -> station.getName() == name).findFirst().get();
    }

    @Override
    public long getItemId(int position) {
        return position;
        //return stations.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    public void updateView () {
        ArrayAdapter<Station> adapter =
                new ArrayAdapter<Station>(mainActivity,  android.R.layout.simple_spinner_dropdown_item, stations);
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}

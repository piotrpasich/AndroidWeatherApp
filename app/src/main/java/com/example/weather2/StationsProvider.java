package com.example.weather2;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class StationsProvider extends AsyncTask<String, Void, ArrayList<Station>> {

    protected MainActivity mainActivity;
    protected String baseUrl;

    public StationsProvider(MainActivity mainActivityRef, String baseUrl) {
        mainActivity = mainActivityRef;
        this.baseUrl = baseUrl;
    }

    @Override
    protected ArrayList<Station> doInBackground(String... strings) {
        ArrayList<Station> stationsList = new ArrayList<Station>();
        String data = "";
        try {
            URL url = new URL(baseUrl + "stations.php");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                data = data + line;
            }

            if (!data.isEmpty()) {
                JSONArray stations = new JSONArray(data);
                for (int i =0; i< stations.length(); i++) {
                    JSONObject station = stations.getJSONObject(i);
                    stationsList.add(new Station(
                            station.getString("ID"),
                            station.getString("Station")
                    ));
                    Log.d("ID", station.getString("ID"));
                    Log.d("Station", station.getString("Station"));
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return stationsList;
    }

    protected void onPostExecute(ArrayList<Station> stationsList) {
        this.mainActivity.updateSpin(stationsList);
    }
}

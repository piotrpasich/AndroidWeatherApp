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

public class WeatherLogProvider extends AsyncTask<String, Void, WeatherLog> {
    protected MainActivity mainActivity;
    protected String baseUrl;
    protected Station station;

    public WeatherLogProvider(MainActivity mainActivityRef, String baseUrl, Station station) {
        mainActivity = mainActivityRef;
        this.baseUrl = baseUrl;
        this.station = station;
    }

    @Override
    protected WeatherLog doInBackground(String... strings) {
        String data = "";
        try {
            URL url = new URL(baseUrl + "values.php?stationid=" + station.getId());
            Log.d("papi", url.toString());
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                data = data + line;
            }

            if (!data.isEmpty()) {
                Log.d("papi", "weatherInfo");
                JSONObject weatherInfo = new JSONObject(data);
                Log.d("papi", "weatherInfo: " + weatherInfo.toString());
                return new WeatherLog(
                        weatherInfo.getString("Place"),
                        weatherInfo.getString("dt"),
                        weatherInfo.getDouble("HiTemp"),
                        weatherInfo.getDouble("LowTemp"),
                        weatherInfo.getDouble("OutHum"),
                        weatherInfo.getDouble("WindSpeed"),
                        weatherInfo.getInt("Bar"),
                        weatherInfo.getDouble("Rain")
                );
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new WeatherLog("", "", 0.0,0.0,0.0,0.0,0,0.0);
    }

    protected void onPostExecute(WeatherLog weatherLog) {
        this.mainActivity.updateWeatherLog(weatherLog);
    }
}

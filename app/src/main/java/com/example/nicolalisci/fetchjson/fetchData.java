package com.example.nicolalisci.fetchjson;

import  android.os.AsyncTask;
import android.util.Log;

import com.github.mikephil.charting.data.LineData;

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


/**
 * Created by nicolalisci on 09/02/18.
 */


public class fetchData extends AsyncTask<Void, Void, JSONArray> {
    String data ="";
    String dataParsed = "";
    String singleParsed ="";
    public static LineData dataLD;
    public static JSONArray JA;


    @Override
    protected JSONArray doInBackground(Void... voids) {
        try {
            //https://api.myjson.com/bins/13158x
            //http://172.22.178.222/blackbox/api/data.php

            Log.d("Background", "background");
            URL url = new URL("http://172.22.178.222/blackbox/api/lettura_filtrata.php");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }

            JA = new JSONArray(data);
            for (int i = 0; i < JA.length(); i++)
            {
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed = "id:" + JO.get("id") + "\n" +
                        "wb_name:" + JO.get("wb_name") + "\n" +
                        "wb_data:" + JO.get("wb_data") + "\n" +
                        "wb_ora:" + JO.get("wb_ora") + "\n" +
                        "temperatura:" + JO.get("temperatura") + "\n" +
                        "umidita:" + JO.get("umidita") + "\n" +
                        "HOUR(ir1.wb_ora):" + JO.get("HOUR(ir1.wb_ora)") + "\n";


                dataParsed = dataParsed + singleParsed + "\n";


            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return JA;
    }


    //_______________________________________________________________________________________________












    //_______________________________________________________________________________________________
    @Override
    protected void onPostExecute(JSONArray aVoid) {
        super.onPostExecute(aVoid);
        //MainActivity.chart.setData(this.dataLD);
        MainActivity.dataTV.setText(this.dataParsed);


    }
}


//____________________________________________________________________________________________________


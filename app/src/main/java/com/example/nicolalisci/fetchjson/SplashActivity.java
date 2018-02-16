package com.example.nicolalisci.fetchjson;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Created by nicolalisci on 12/02/18.
 */


public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 5000;
    private static ArrayList <Whitebox> whiteboxList = new ArrayList<Whitebox>();
    Whitebox whitebox =new Whitebox();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.splash_theme);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        ProgressBar spinner;
        spinner = (ProgressBar)findViewById(R.id.progressBar1);


        RequestQueue queue = Volley.newRequestQueue(this);
        final String url = "http://172.22.178.222/blackbox/api/whitebox.php";




     /*   try {
            JSONObject jsonObject = new JSONObject("");
            JSONArray jsonArray = jsonObject.getJSONArray("elementi");
            for (int i = 0; i < jsonArray.length() ; i++)
            {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                int id = jsonObject1.getInt("id");


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        */




        final JsonArrayRequest getRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray response) {
                        // display response
                        Log.d("Response", String.valueOf(response));

                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject object = (JSONObject) response.get(i);
                                Whitebox whitebox= new Whitebox();
                                whitebox.setWb_id(object.getString("wb_id"));
                                whitebox.setWb_nome(object.getString("wb_nome"));
                                whitebox.setWb_descrizione(object.getString("wb_descrizione"));
                                whitebox.setWb_ip(object.getString("wb_ip"));
                                whitebox.setWb_temp(object.getString("wb_temp"));
                                whitebox.setWb_umid(object.getString("wb_umid"));
                                whitebox.setWb_data(object.getString("wb_data"));
                                whitebox.setWb_ora(object.getString("wb_ora"));


                                whiteboxList.add(whitebox);


                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }



                    }




                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());
                    }
                }
        );

        // add it to the RequestQueue
        queue.add(getRequest);


/*
                                wb_id = object.getString("wb_id");
                                wb_nome = object.getString("wb_nome");
                                wb_descrizione = object.getString("wb_descrizione");
                                wb_ip = object.getString("wb_ip");
                                wb_temp = object.getString("wb_temp");
                                wb_umid = object.getString("wb_umid");
                                wb_data = object.getString("wb_data");
                                wb_ora = object.getString("wb_ora");
                                Log.d("wb_id", wb_id);
                                Log.d("wb_nome", wb_nome);
                                Log.d("wb_descrizione", wb_descrizione);
                                Log.d("wb_temp", wb_temp);
                                Log.d("wb_ora", wb_ora);
                                Log.d("wb_data", wb_data);
                                Log.d("wb_ora", wb_ora);

                                   whitebox.add(new Whitebox(
                                wb_id,
                                wb_nome,
                                wb_descrizione,
                                wb_ip,
                                wb_temp,
                                wb_umid,
                                wb_data,
                                wb_ora
                        ));


                        String wb_ora = null;
                        String wb_data = null;
                        String wb_umid = null;
                        String wb_temp = null;
                        String wb_descrizione = null;
                        String wb_nome = null;
                        String wb_id = null;
                        String wb_ip = null;

                         Log.d("wb_id", wb_id);
                                Log.d("wb_nome", wb_nome);
                                Log.d("wb_descrizione", wb_descrizione);
                                Log.d("wb_temp", wb_temp);
                                Log.d("wb_ora", wb_ora);
                                Log.d("wb_data", wb_data);
                                Log.d("wb_ora", wb_ora);

 */






        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, Cards.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("whiteboxList", (Serializable) whiteboxList);
                i.putExtras(bundle);

                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }








}
package com.example.nicolalisci.fetchjson;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.Serializable;
import java.util.ArrayList;

import Models.Bisettimanale;
import Models.Stats;
import Models.Whitebox;


/**
 * Created by nicolalisci on 12/02/18.
 */


public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 8000;
    private static ArrayList <Whitebox> whiteboxList = new ArrayList<Whitebox>();
    protected static ArrayList <Stats> statsArrayList = new ArrayList<Stats>();
    protected static ArrayList <Bisettimanale> bisettimanaleArrayList1 = new ArrayList<Bisettimanale>();
    protected static ArrayList <Bisettimanale> bisettimanaleArrayList2 = new ArrayList<Bisettimanale>();
    protected static ArrayList<ArrayList<Bisettimanale>> rilevazioni = new ArrayList<ArrayList<Bisettimanale>>();

    Whitebox whitebox = new Whitebox();
    Stats stats = new Stats();
    Bisettimanale bisettimanale = new Bisettimanale();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_theme);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        ProgressBar spinner;
        spinner = (ProgressBar)findViewById(R.id.progressBar1);


        RequestQueue queue = Volley.newRequestQueue(this);
        final String url = "http://172.22.178.222/blackbox/api/whitebox.php";
        final String url1 = "http://172.22.178.222/blackbox/api/lettura_bisettimanale.php";
        final String url2 = "http://172.22.178.222/blackbox/api/stats.php";


        final JsonArrayRequest getRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray response) {
                        // display response
                       // Log.d("Response", String.valueOf(response.length()));

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
                        Toast.makeText(SplashActivity.this, "Whitebox non caricate!", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        getRequest.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });
        queue.add(getRequest);



        //__________________________________________________________________________________________________________

        final JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response1) {
                      //  Log.d("Response", String.valueOf(response1));
                       // Log.d("Length", String.valueOf(response1.length()));


                        JSONArray resultArray1 = null;
                        JSONArray resultArray2 = null;
                        try {
                            resultArray1 = response1.getJSONArray("1");
                            resultArray2 = response1.getJSONArray("2");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        JSONObject object1 = null;
                        JSONObject object2 = null;

                        //Log.d("array2", String.valueOf(resultArray2));




                        for (int i = 0; i < resultArray1.length(); i++) {

                            try {
                                 object1 = (JSONObject) resultArray1.getJSONObject(i);

                            Bisettimanale bisettimanale = new Bisettimanale();

                                bisettimanale.setWb_name(object1.getString("wb_name"));
                                bisettimanale.setWb_data(object1.getString("wb_data"));
                                bisettimanale.setWb_ora(object1.getString("wb_ora"));
                                bisettimanale.setWb_temp(object1.getString("temperatura"));
                                bisettimanale.setWb_umid(object1.getString("umidita"));
                                bisettimanale.setWb_id(object1.getString("id"));
                                bisettimanaleArrayList1.add(bisettimanale);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        for (int i = 0; i < resultArray2.length(); i++) {

                            try {
                                object2 = (JSONObject) resultArray2.getJSONObject(i);

                                Bisettimanale bisettimanale = new Bisettimanale();

                                bisettimanale.setWb_name(object2.getString("wb_name"));
                                bisettimanale.setWb_data(object2.getString("wb_data"));
                                bisettimanale.setWb_ora(object2.getString("wb_ora"));
                                bisettimanale.setWb_temp(object2.getString("temperatura"));
                                bisettimanale.setWb_umid(object2.getString("umidita"));
                                bisettimanale.setWb_id(object2.getString("id"));
                                bisettimanaleArrayList2.add(bisettimanale);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        rilevazioni.add(0,bisettimanaleArrayList1);
                        rilevazioni.add(1,bisettimanaleArrayList2);

                    }



                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());
                        Toast.makeText(SplashActivity.this, "Rilevazioni non caricate!", Toast.LENGTH_SHORT).show();

                    }
                }
        );
        jsObjRequest.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });


        queue.add(jsObjRequest);

        //__________________________________________________________________________________________________________
        // stats
        final JsonArrayRequest getRequest2 = new JsonArrayRequest(Request.Method.GET, url2, null,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray response2) {
                        // display response
                       // Log.d("Response", String.valueOf(response2));

                        try {
                            for (int i = 0; i < response2.length(); i++) {
                                JSONObject object = (JSONObject) response2.get(i);
                                Stats stats= new Stats();

                                stats.setWb_name(object.getString("wb_name"));
                                stats.settMAX((float) object.getDouble("tMAX"));
                                stats.settMIN((float) object.getDouble("tMIN"));
                                stats.settAVG((float) object.getDouble("tAVG"));
                                stats.setuMAX((float) object.getDouble("uMAX"));
                                stats.setuMIN((float) object.getDouble("uMIN"));
                                stats.setuAVG((float) object.getDouble("uAVG"));

                                statsArrayList.add(stats);

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
                        Toast.makeText(SplashActivity.this, "Medie non caricate!", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        getRequest2.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });
        queue.add(getRequest2);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, Cards.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("whiteboxList", (Serializable) whiteboxList);
                i.putExtras(bundle);

                Bundle bundle1 = new Bundle();
                bundle1.putSerializable("statsArrayList", (Serializable) statsArrayList);
                i.putExtras(bundle1);

                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("rilevazioni", (Serializable) rilevazioni);
                i.putExtras(bundle2);



                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }








}
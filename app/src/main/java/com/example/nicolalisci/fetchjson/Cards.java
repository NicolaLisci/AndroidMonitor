package com.example.nicolalisci.fetchjson;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import Models.Bisettimanale;
import Models.Stats;
import Models.Whitebox;


/**
 * Created by nicolalisci on 15/02/18.
 */

public class Cards extends Activity {

    public static ArrayList<Whitebox> whiteboxList = new ArrayList<Whitebox>();
    private static ArrayList <Stats> statsArrayList = new ArrayList<Stats>();
    private static ArrayList <Bisettimanale> bisettimanaleArrayList = new ArrayList<Bisettimanale>();

    Whitebox whitebox = new Whitebox();
    Stats stats = new Stats();
    Bisettimanale bisettimanale = new Bisettimanale();
    private ActionBar supportActionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_card);
        


        whitebox = (Whitebox) getIntent().getSerializableExtra("whitebox");
        whiteboxList = (ArrayList<Whitebox>) getIntent().getSerializableExtra("whiteboxList");

        stats = (Stats) getIntent().getSerializableExtra("stats");
        statsArrayList = (ArrayList<Stats>) getIntent().getSerializableExtra("statsArrayList");

        bisettimanale = (Bisettimanale) getIntent().getSerializableExtra("bisettimanale");
        bisettimanaleArrayList = (ArrayList<Bisettimanale>) getIntent().getSerializableExtra("bisettimanaleArrayList");



       /* for (int i=0;i<statsArrayList.size();i++)
        {
            Log.d("wb_name", String.valueOf(statsArrayList.get(i).getWb_name()));
            Log.d("tMAX", String.valueOf(statsArrayList.get(i).gettMAX()));
            Log.d("tMIN", String.valueOf(statsArrayList.get(i).gettMIN()));
            Log.d("tAVG", String.valueOf(statsArrayList.get(i).gettAVG()));
            Log.d("uMAX", String.valueOf(statsArrayList.get(i).getuMAX()));
            Log.d("uMIN", String.valueOf(statsArrayList.get(i).getuMIN()));
            Log.d("uAVG", String.valueOf(statsArrayList.get(i).getuAVG()));
        }
            Log.d("size", String.valueOf(bisettimanaleArrayList.size()));
        Log.d("arraylist", String.valueOf(bisettimanaleArrayList));

        for (int i=0;i<bisettimanaleArrayList.size();i++)
        {


            Log.d("name", String.valueOf(bisettimanaleArrayList.get(i).getWb_name()));
            Log.d("data", String.valueOf(bisettimanaleArrayList.get(i).getWb_data()));
            Log.d("ora", String.valueOf(bisettimanaleArrayList.get(i).getWb_ora()));
            Log.d("temp", String.valueOf(bisettimanaleArrayList.get(i).getWb_temp()));
            Log.d("umid", String.valueOf(bisettimanaleArrayList.get(i).getWb_umid()));
            Log.d("id", String.valueOf(bisettimanaleArrayList.get(i).getWb_id()));

        }
*/


        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        RVAdapter adapter = new RVAdapter(this, whiteboxList);
        rv.setAdapter(adapter);


    }


}









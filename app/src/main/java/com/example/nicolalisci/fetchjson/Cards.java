package com.example.nicolalisci.fetchjson;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.Serializable;
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
    protected static ArrayList<ArrayList<Bisettimanale>> rilevazioni = new ArrayList<ArrayList<Bisettimanale>>();


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
        rilevazioni = (ArrayList<ArrayList<Bisettimanale>>) getIntent().getSerializableExtra("rilevazioni");

        Log.d("rilevazioni", String.valueOf(rilevazioni.get(0)));

        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        RVAdapter adapter = new RVAdapter(this, whiteboxList, new RVAdapter.DetailsAdapterListener() {
            @Override
            public void OnCardClicked(int position) {
                //cvID=getAdapterPosition();
                //Log.d("cvID1", String.valueOf(cvID));
                Bundle bundle = new Bundle();
                bundle.putSerializable("whiteboxList",whiteboxList);
                bundle.putSerializable("statsArrayList", (Serializable) statsArrayList);
                bundle.putSerializable("rilevazioni", (Serializable) rilevazioni);
                bundle.putInt("currentPosition",position);
                Intent intent = new Intent(Cards.this, Dettaglio.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        rv.setAdapter(adapter);


    }


}









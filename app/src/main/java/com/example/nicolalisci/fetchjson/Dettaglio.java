package com.example.nicolalisci.fetchjson;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import Models.Bisettimanale;
import Models.Stats;
import Models.Whitebox;
import android.support.v4.app.Fragment;




/**
 * Created by nicolalisci on 21/02/18.
 */

public class Dettaglio extends AppCompatActivity implements TabLayout.OnTabSelectedListener{
    public static ArrayList <Whitebox> whiteboxList = new ArrayList<Whitebox>();
    public Whitebox whitebox = new Whitebox();
    public static ArrayList<Stats> statsArrayList = new ArrayList<Stats>();
    public Bisettimanale bisettimanale = new Bisettimanale();
    private static ViewPager vp;
    private TabLayout tab;
    private Context context;
    private int position;
    protected static ArrayList<ArrayList<Bisettimanale>> rilevazioni = new ArrayList<ArrayList<Bisettimanale>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dettaglio);

        vp = (ViewPager) findViewById(R.id.viewpager);


        tab = (TabLayout) findViewById(R.id.tabs);
        tab.setTabGravity(TabLayout.GRAVITY_FILL);
        tab.setupWithViewPager(vp);
        tab.addOnTabSelectedListener(this);

        //cvID=getIntent().getIntExtra("cvID",cvID);
        //Log.d("cvID", String.valueOf(cvID));
        whitebox  = (Whitebox) getIntent().getSerializableExtra("whitebox");
        whiteboxList = (ArrayList<Whitebox>) getIntent().getSerializableExtra("whiteboxList");
        //stats = (Stats) getIntent().getSerializableExtra("stats");
        statsArrayList = (ArrayList<Stats>) getIntent().getSerializableExtra("statsArrayList");
        //bisettimanale = (Bisettimanale) getIntent().getSerializableExtra("bisettimanale");
        rilevazioni = (ArrayList<ArrayList<Bisettimanale>>) getIntent().getSerializableExtra("rilevazioni");
        position = getIntent().getIntExtra("currentPosition",0);




        PageAdapter pm = new PageAdapter(getSupportFragmentManager(),whiteboxList, statsArrayList,rilevazioni,position);
        vp.setAdapter(pm);
        vp.setCurrentItem(position);


    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        switch(tab.getPosition()) {
            case 0:
                vp.setCurrentItem(0);
                tab.setText(whiteboxList.get(0).getWb_nome());
                break;
            case 1:
                vp.setCurrentItem(1);
                tab.setText(whiteboxList.get(1).getWb_nome());
                break;

            default:

                vp.setCurrentItem(tab.getPosition());
                tab.setText("WhiteBox");
                break;
        }

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
    private Context getActivity() {
        return context;
    }


}
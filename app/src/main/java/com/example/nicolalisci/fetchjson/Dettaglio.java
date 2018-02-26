package com.example.nicolalisci.fetchjson;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.io.Serializable;
import java.util.ArrayList;
import Models.Bisettimanale;
import Models.Stats;
import Models.Whitebox;
import android.support.v4.app.Fragment;

import static com.example.nicolalisci.fetchjson.SplashActivity.bisettimanaleArrayList;
import static com.example.nicolalisci.fetchjson.SplashActivity.statsArrayList;


/**
 * Created by nicolalisci on 21/02/18.
 */

public class Dettaglio extends AppCompatActivity implements TabLayout.OnTabSelectedListener{
    public  static LineChart chart;
    public static LineData dataLD;
    public static TextView Nome, Descrizione,temp,umid,MaxT,MinT,AvgT,MaxU,MinU,AvgU;
    public static ArrayList <Whitebox> whiteboxList = new ArrayList<Whitebox>();
    public Whitebox whitebox = new Whitebox();
    public static ArrayList<Stats> statsArrayList = new ArrayList<Stats>();
    public Stats stats = new Stats();
    private static ArrayList <Bisettimanale> bisettimanaleArrayList = new ArrayList<Bisettimanale>();
    public Bisettimanale bisettimanale = new Bisettimanale();
    public int cvID, cont1 = 0, cont2 = 0, contBisettArray=0, i=0,ini=0;
    private static ViewPager vp;
    private TabLayout tab;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dettaglio);

        vp = (ViewPager) findViewById(R.id.viewpager);


        tab = (TabLayout) findViewById(R.id.tabs);
        tab.setTabGravity(TabLayout.GRAVITY_FILL);
        tab.setupWithViewPager(vp);
        tab.addOnTabSelectedListener(this);

        cvID=getIntent().getIntExtra("cvID",cvID);
        //Log.d("cvID", String.valueOf(cvID));
        whitebox  = (Whitebox) getIntent().getSerializableExtra("whitebox");
        whiteboxList = (ArrayList<Whitebox>) getIntent().getSerializableExtra("whiteboxList");
        stats = (Stats) getIntent().getSerializableExtra("stats");
        statsArrayList = (ArrayList<Stats>) getIntent().getSerializableExtra("statsArrayList");
        bisettimanale = (Bisettimanale) getIntent().getSerializableExtra("bisettimanale");
        bisettimanaleArrayList = (ArrayList<Bisettimanale>) getIntent().getSerializableExtra("bisettimanaleArrayList");




       // Intent intent = new Intent(getActivity(), );

        Bundle bundle1 = new Bundle();
        bundle1.putSerializable("statsArrayList", statsArrayList);
        bundle1.putSerializable("bisettimanaleArrayList", bisettimanaleArrayList);
        bundle1.putSerializable("whiteboxList", whiteboxList);
        bundle1.putInt("cvID",cvID);

        PageAdapter pm = new PageAdapter(getSupportFragmentManager(),whiteboxList,statsArrayList,bisettimanaleArrayList,cvID);
        vp.setAdapter(pm);


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
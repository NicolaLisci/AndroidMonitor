package com.example.nicolalisci.fetchjson;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.mikephil.charting.charts.LineChart;
import java.util.ArrayList;

import Models.Bisettimanale;
import Models.Stats;

/**
 * Created by nicolalisci on 20/02/18.
 */

public class Fragment2 extends Fragment {
    private static ArrayList<Stats> statsArrayList = new ArrayList<Stats>();
    private static ArrayList<Bisettimanale> bisettimanaleArrayList = new ArrayList<Bisettimanale>();
    Stats stats = new Stats();
    Bisettimanale bisettimanale = new Bisettimanale();
    public static LineChart chart;
    private String title;
    private int page;

    public static Fragment2 newInstance()
    {
        return new Fragment2();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.frag, parent, false);


    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }
    @Override
    public String toString() {
        return "Fragment2";
    }


}


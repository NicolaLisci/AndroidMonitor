package com.example.nicolalisci.fetchjson;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;


import java.util.ArrayList;

import Models.Bisettimanale;
import Models.Stats;
import Models.Whitebox;

/**
 * Created by nicolalisci on 22/02/18.
 */

public class PageAdapter extends FragmentStatePagerAdapter {

    private static ArrayList<Whitebox> whiteboxList = new ArrayList<Whitebox>();
    private static ArrayList <Stats> statsArrayList = new ArrayList<Stats>();
    protected static ArrayList<ArrayList<Bisettimanale>> rilevazioni = new ArrayList<ArrayList<Bisettimanale>>();

    public int position;

    public PageAdapter(FragmentManager fm,ArrayList<Whitebox> whiteboxList,ArrayList <Stats> statsArrayList, ArrayList<ArrayList<Bisettimanale>> rilevazioni, int position)
    {
        super(fm);
        this.whiteboxList = whiteboxList;
        this.statsArrayList = statsArrayList;
        this.rilevazioni = rilevazioni;
        this.position = position;

    }

    @Override
    public Fragment getItem(int position)
    {
        //Log.d("qua","qua");
        //Log.d("pos", String.valueOf(position));
        Bundle bundle = getBundleDettaglio(position);
        Fragment1 fDettaglio = new Fragment1();
        fDettaglio.setArguments(bundle);


        return fDettaglio;
    }

    @Override
    public int getCount()
    {
        return whiteboxList.size();
    }

    private Bundle getBundleDettaglio(int position)
    {
        Whitebox wb = whiteboxList.get(position);
        Stats st = statsArrayList.get(position);
        Bundle bundle1 = new Bundle();
        bundle1.putSerializable("statsArrayList", statsArrayList);
        bundle1.putSerializable("rilevazioni", rilevazioni);
        bundle1.putSerializable("whitebox", wb);
        bundle1.putSerializable("st", st);
        bundle1.putInt("currentPosition",position);
        return bundle1;
    }


}
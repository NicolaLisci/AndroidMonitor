package com.example.nicolalisci.fetchjson;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.security.acl.LastOwnerException;
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
    private static ArrayList <Bisettimanale> bisettimanaleArrayList = new ArrayList<Bisettimanale>();
    public int cvID;

    public PageAdapter(FragmentManager fm,ArrayList<Whitebox> whiteboxList,ArrayList <Stats> statsArrayList, ArrayList<Bisettimanale> bisettimanaleArrayList, int cvID)
    {
        super(fm);
        this.whiteboxList = whiteboxList;
        this.statsArrayList = statsArrayList;
        this.bisettimanaleArrayList = bisettimanaleArrayList;
        this.cvID = cvID;
        Log.d("cvID qui", String.valueOf(cvID));
    }

    @Override
    public Fragment getItem(int position)
    {
        Log.d("cvID3", String.valueOf(cvID));
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

    private Bundle getBundleDettaglio(int cvID)
    {
        Whitebox wb = whiteboxList.get(cvID);
        Stats st = statsArrayList.get(cvID);
        //Bisettimanale bs = statsArrayList.get(cvID);
        Bundle bundle1 = new Bundle();
        bundle1.putSerializable("statsArrayList", statsArrayList);
        bundle1.putSerializable("bisettimanaleArrayList", bisettimanaleArrayList);
        bundle1.putSerializable("wb", wb);
        bundle1.putSerializable("st", st);
        //bundle1.putSerializable("bs", wb);
        bundle1.putInt("cvID",cvID);
        return bundle1;
    }


}
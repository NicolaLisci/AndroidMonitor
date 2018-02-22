package com.example.nicolalisci.fetchjson;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by nicolalisci on 22/02/18.
 */

public class PageAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> pages=new ArrayList<>();

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return pages.get(position);
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    //FRAGMENT TITLE
    @Override
    public CharSequence getPageTitle(int position) {
        return pages.get(position).toString();
    }




    public void addPage(Fragment fragment) {pages.add(fragment);
    }
}
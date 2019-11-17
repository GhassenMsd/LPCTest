package com.example.lpctest.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.lpctest.Fragments.Anniversaire;
import com.example.lpctest.Fragments.Depart;
import com.example.lpctest.Fragments.Solidaire;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;
    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Anniversaire anniversaire = new Anniversaire();
                return anniversaire;
            case 1:
                Depart depart = new Depart();
                return depart;
            case 2:
                Solidaire solidaire = new Solidaire();
                return solidaire;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

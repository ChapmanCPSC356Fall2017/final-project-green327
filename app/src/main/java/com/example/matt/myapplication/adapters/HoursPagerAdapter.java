package com.example.matt.myapplication.adapters;

/**
 * Created by Matt on 12/16/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.matt.myapplication.HoursCollection;
import com.example.matt.myapplication.fragments.HoursFragment;
import com.example.matt.myapplication.models.HoursModel;


public class HoursPagerAdapter extends FragmentStatePagerAdapter
{
    public HoursPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        HoursModel hours = HoursCollection.GetInstance().getHours().get(position);

        HoursFragment frag = new HoursFragment();

        Bundle args = new Bundle();
        args.putString(HoursFragment.ARG_HOURS_ID, hours.getID());

        frag.setArguments(args);

        return frag;
    }

    @Override
    public int getCount()
    {
        return HoursCollection.GetInstance().getHours().size();
    }
}

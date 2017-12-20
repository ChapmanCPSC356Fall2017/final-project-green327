package com.example.matt.myapplication.adapters;

/**
 * Created by Matt on 12/16/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.matt.myapplication.HoursCollection;
import com.example.matt.myapplication.fragments.ProfileViewFragment;
import com.example.matt.myapplication.models.HoursModel;


public class ProfilePagerAdapter extends FragmentStatePagerAdapter
{
    public ProfilePagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        HoursModel hours = HoursCollection.GetInstance().getHours().get(position);

        ProfileViewFragment frag = new ProfileViewFragment();

        Bundle args = new Bundle();
        args.putString(ProfileViewFragment.ARG_HOURS_ID, hours.getID());

        frag.setArguments(args);

        return frag;
    }

    @Override
    public int getCount()
    {
        System.out.println();
        return HoursCollection.GetInstance().getHours().size();
    }
}

package com.example.matt.myapplication.activities;

/**
 * Created by Matt on 12/16/2017.
 */

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.matt.myapplication.HoursCollection;
import com.example.matt.myapplication.adapters.ProfilePagerAdapter;
import com.example.matt.myapplication.R;

//changing view from list to individual items
public class ProfilePager extends AppCompatActivity
{
    public static final String EXTRA_HOURS_ID = "hours_id";

    private ViewPager hoursPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hours_pager);

        this.hoursPager = findViewById(R.id.vp_hours);

        ProfilePagerAdapter adapter = new ProfilePagerAdapter(getSupportFragmentManager());
        this.hoursPager.setAdapter(adapter);

        String hoursId = getIntent().getStringExtra(ProfilePager.EXTRA_HOURS_ID);
        int hoursIndex = HoursCollection.GetInstance().indexOf(hoursId);

        System.out.println(hoursIndex);

        this.hoursPager.setCurrentItem(hoursIndex);
    }
}

package com.example.matt.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.example.matt.myapplication.R;
import com.example.matt.myapplication.fragments.HoursListFragment;
import com.example.matt.myapplication.models.selectedDate;

/**
 * Created by Matt on 12/13/2017.
 */
//opens HoursListFragment and sends selected dat info
public class CalendarActivity extends AppCompatActivity
{
    private String d;
    CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal_list_frags);

        this.calendar = findViewById(R.id.calendarView);
        // perform setOnDateChangeListener event on CalendarView
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth)
            {
                selectedDate.GetInstance().setDate(Integer.toString(dayOfMonth));
                HoursListFragment fragment = new HoursListFragment();
                showFragment(fragment);
            }
        });
    }
    private void showFragment(Fragment frag)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.list_fragment, frag)
                .commit();
    }
}

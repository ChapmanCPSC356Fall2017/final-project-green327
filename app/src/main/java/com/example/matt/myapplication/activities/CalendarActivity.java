package com.example.matt.myapplication.activities;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import com.example.matt.myapplication.R;
import com.example.matt.myapplication.fragments.HoursListFragment;
import com.example.matt.myapplication.CalendarLoginInformation;

/**
 * Created by Matt on 12/13/2017.
 */
//opens HoursListFragment and sends selected dat info
public class CalendarActivity extends AppCompatActivity
{
    private String d;
    CalendarView calendar;
    Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal_list_frags);

        this.calendar = findViewById(R.id.calendarView);
        this.but = findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CalendarLoginInformation.GetInstance().setHasLogin(false);
                onBackPressed();
            }
        });
        // perform setOnDateChangeListener event on CalendarView
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth)
            {
                CalendarLoginInformation.GetInstance().setDate(Integer.toString(dayOfMonth));
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

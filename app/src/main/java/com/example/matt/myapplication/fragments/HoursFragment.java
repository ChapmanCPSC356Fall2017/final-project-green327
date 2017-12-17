package com.example.matt.myapplication.fragments;

/**
 * Created by Matt on 12/16/2017.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.matt.myapplication.HoursCollection;
import com.example.matt.myapplication.R;
import com.example.matt.myapplication.models.HoursModel;

//on click fragment that appears when list is selected
public class HoursFragment extends Fragment
{
    private TextView name;
    private TextView number;
    private TextView time;

    public final static String ARG_HOURS_ID = "hours_id";

    private HoursModel hours;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        String hoursID = getArguments().getString(HoursFragment.ARG_HOURS_ID);
        this.hours = HoursCollection.GetInstance().getHours(hoursID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_hours, container, false);

        this.name = v.findViewById(R.id.tv_name);
        this.number = v.findViewById(R.id.tv_number);
        this.time = v.findViewById(R.id.tv_hours);

        name.setText(hours.getEmployee());
        number.setText(hours.getNumber());
        time.setText(hours.getHours());

        return v;
    }
}

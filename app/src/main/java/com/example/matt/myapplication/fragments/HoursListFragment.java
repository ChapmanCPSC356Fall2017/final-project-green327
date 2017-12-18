package com.example.matt.myapplication.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.matt.myapplication.R;
import com.example.matt.myapplication.adapters.HoursListAdapter;

/**
 * Created by Matt on 12/16/2017.
 */

public class HoursListFragment extends Fragment
{
    private HoursListAdapter adapter;

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.hours_recycle, container, false);

        RecyclerView hoursListView = v.findViewById(R.id.rv_hours);

        this.adapter = new HoursListAdapter();
        hoursListView.setAdapter(adapter);


        hoursListView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }

}

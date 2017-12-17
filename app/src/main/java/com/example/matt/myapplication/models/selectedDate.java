package com.example.matt.myapplication.models;

import com.example.matt.myapplication.HoursCollection;

/**
 * Created by Matt on 12/16/2017.
 */

public class selectedDate {
    private static selectedDate collection;
    private String date;

    public static selectedDate GetInstance() {
        if (collection == null) {
            collection = new selectedDate();
        }

        return collection;
    }

    public selectedDate()
    {

    }

    public void setDate(String d)
    {
        this.date = d;
    }

    public String getDate()
    {
        return date;
    }
}


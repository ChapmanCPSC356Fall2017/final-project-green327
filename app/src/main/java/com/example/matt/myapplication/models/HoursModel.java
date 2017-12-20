package com.example.matt.myapplication.models;

/**
 * Created by Matt on 12/16/2017.
 */

import android.net.Uri;

import java.util.UUID;

public class HoursModel
{
    private String id;
    private String day;
    private String hours;
    private String employee;
    private String number;
    private Uri profile;
    private String password;

    public HoursModel()
    {
        this.id = UUID.randomUUID().toString();
    }

    public String getID()
    {
        return id;
    }

    public String getDate()
    {
        return day;
    }

    public int getDateInt()
    {
        return Integer.parseInt(day);
    }

    public void setDate(String day)
    {
        this.day = day;
    }

    public String getEmployee()
    {
        return employee;
    }
    public void setEmployee(String employee)
    {
        this.employee = employee;
    }

    public String getHours()
    {
        return hours;
    }

    public void setHours(String hours)
    {
        this.hours = hours;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getNumber()
    {
        return number;
    }

    public void setProfile(Uri p)
    {
        this.profile = p;
    }

    public Uri getProfile()
    {
        return this.profile;
    }

    public void setPassword(String pass)
    {
        this.password = pass;
    }

    public String getPassword()
    {
        return password;
    }
}

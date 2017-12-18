package com.example.matt.myapplication;

import java.lang.reflect.Array;

/**
 * Created by Matt on 12/16/2017.
 */

public class CalendarLoginInformation {
    private static CalendarLoginInformation collection;
    private String date;
    private String[] login;
    private String username;
    private String password;
    private boolean haslog;

    public static CalendarLoginInformation GetInstance() {
        if (collection == null) {
            collection = new CalendarLoginInformation();
        }

        return collection;
    }

    public CalendarLoginInformation()
    {
        this.haslog = false;
    }

    public void setDate(String d)
    {
        this.date = d;
    }

    public String getDate()
    {
        return date;
    }

    public int getDateInt()
    {
        return Integer.parseInt(date);
    }

    public void setLogin(String u, String p)
    {
        this.username = u;
        this.password = p;
    }

    public String[] getLogin()
    {
        this.login = new String[]{this.username, this.password};
        return this.login;
    }

    public void setHasLogin(boolean log)
    {
        this.haslog = log;
    }

    public boolean getHasLogin()
    {
        return this.haslog;
    }
}


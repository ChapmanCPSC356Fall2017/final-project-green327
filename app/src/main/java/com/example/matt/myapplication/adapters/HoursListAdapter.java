package com.example.matt.myapplication.adapters;

/**
 * Created by Matt on 12/16/2017.
 */

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.matt.myapplication.HoursCollection;
import com.example.matt.myapplication.activities.CalendarActivity;
import com.example.matt.myapplication.fragments.HoursListFragment;
import com.example.matt.myapplication.models.HoursModel;
import com.example.matt.myapplication.models.selectedDate;
import com.example.matt.myapplication.R;
import com.example.matt.myapplication.activities.HoursPager;

import org.w3c.dom.Text;

//creating list view and handling user inputs
public class HoursListAdapter extends RecyclerView.Adapter<HoursListAdapter.HoursViewHolder>
{

    @Override
    public HoursViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.cell_hours, parent, false);

        return new HoursViewHolder(v);
    }

    //TODO refractor position of new hours list printed
    @Override
    public void onBindViewHolder(HoursViewHolder holder, int position)
    {
        HoursModel hours = HoursCollection.GetInstance().getHours().get(position);
        if(hours.getDate().equals(selectedDate.GetInstance().getDate()))
        {
            holder.setup(hours);
        }
    }

    @Override
    public int getItemCount()
    {
        return HoursCollection.GetInstance().getHours().size();
    }


    //creates view for each individual row in the list
    class HoursViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private HoursModel hours;

        private TextView titleTextView;

        private TextView hoursTestView;

        public HoursViewHolder(View itemView)
        {
            super(itemView);

            itemView.setOnClickListener(this);

            this.titleTextView = itemView.findViewById(R.id.tv_title);

            this.hoursTestView = itemView.findViewById(R.id.tv_hours);
        }

        public void setup(HoursModel hours)
        {
            this.hours = hours;
            System.out.println(hours.getEmployee());
            this.titleTextView.setText(hours.getEmployee());
            this.hoursTestView.setText(hours.getHours());
        }

        //initiates pager activity to open up more details on item selected
        @Override
        public void onClick(View view)
        {
            Intent hoursIntent = new Intent(view.getContext(), HoursPager.class);
            hoursIntent.putExtra(HoursPager.EXTRA_HOURS_ID, this.hours.getID());

            view.getContext().startActivity(hoursIntent);
        }
    }
}

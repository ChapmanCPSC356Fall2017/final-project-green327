package com.example.matt.myapplication.fragments;

/**
 * Created by Matt on 12/16/2017.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.matt.myapplication.HoursCollection;
import com.example.matt.myapplication.R;
import com.example.matt.myapplication.models.HoursModel;

import static android.app.Activity.RESULT_OK;

//on click fragment that appears when list is selected
public class HoursFragment extends Fragment
{
    private TextView name;
    private TextView number;
    private TextView time;

    private ImageView image;

    public final static String ARG_HOURS_ID = "hours_id";
    private static final int RESULT_LOAD_IMAGE = 1;

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

        this.image = v.findViewById(R.id.iv_image);

        this.name = v.findViewById(R.id.tv_name);
        this.number = v.findViewById(R.id.tv_number);
        this.time = v.findViewById(R.id.tv_hours);

        image.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
            }

        });

        name.setText(hours.getEmployee());
        number.setText(hours.getNumber());
        time.setText(hours.getHours());

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null)
        {
            Uri selectedImage = data.getData();
            image.setImageURI(selectedImage);
        }
    }
}

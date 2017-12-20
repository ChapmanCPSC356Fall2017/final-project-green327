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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.matt.myapplication.CalendarLoginInformation;
import com.example.matt.myapplication.HoursCollection;
import com.example.matt.myapplication.R;
import com.example.matt.myapplication.models.HoursModel;

import static android.app.Activity.RESULT_OK;

//on click fragment that appears when list is selected
public class ProfileViewFragment extends Fragment
{
    private Button but;
    private TextView name;
    private EditText number;
    private TextView time;
    private EditText password;

    private ImageView image;

    public final static String ARG_HOURS_ID = "hours_id";
    private static final int RESULT_LOAD_IMAGE = 1;

    private HoursModel hours;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        String hoursID = getArguments().getString(ProfileViewFragment.ARG_HOURS_ID);
        this.hours = HoursCollection.GetInstance().getHours(hoursID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.profilefragment, container, false);

        this.image = v.findViewById(R.id.iv_image);

        this.name = v.findViewById(R.id.tv_name);
        this.number = v.findViewById(R.id.et_number);
        this.time = v.findViewById(R.id.et_hours);
        this.password = v.findViewById(R.id.et_pass);
        this.but = v.findViewById(R.id.button);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(but.getText().equals("Edit")) {
                    number.setFocusable(true);
                    number.setFocusableInTouchMode(true);
                    number.setClickable(true);

                    password.setFocusable(true);
                    password.setFocusableInTouchMode(true);
                    password.setClickable(true);

                    but.setText(R.string.done);
                }
                else
                {
                    but.setText(R.string.edit_profile);

                    hours.setNumber(number.getText().toString());
                    hours.setPassword(password.getText().toString());

                    number.setFocusable(false);
                    number.setFocusableInTouchMode(false);
                    number.setClickable(false);

                    password.setFocusable(false);
                    password.setFocusableInTouchMode(false);
                    password.setClickable(false);
                }

            }
        });

        image.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                String[] loginCheck = CalendarLoginInformation.GetInstance().getLogin();
                    if (loginCheck[0].equals(hours.getEmployee()) && loginCheck[1].equals(hours.getNumber()))
                    {
                        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
                    }
            }
        });

        name.setText(hours.getEmployee());
        number.setText(hours.getNumber());
        password.setText(hours.getPassword());
        time.setText(hours.getHours());

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        image.setImageURI(this.hours.getProfile());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null)
        {
            Uri selectedImage = data.getData();
            this.hours.setProfile(selectedImage);
            image.setImageURI(selectedImage);
        }
    }
}

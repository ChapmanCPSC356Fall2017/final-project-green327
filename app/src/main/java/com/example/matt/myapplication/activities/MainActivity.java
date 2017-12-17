package com.example.matt.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.matt.myapplication.R;

import static android.view.View.VISIBLE;

//TODO change on back in pager layout to go back to calendar view and not main
public class MainActivity extends AppCompatActivity {

    public static final String USER_INFO = "user";
    EditText userName;
    EditText password;
    TextView wrong;
    Button log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.userName = findViewById(R.id.username);
        this.password = findViewById(R.id.password);
        this.wrong = findViewById(R.id.tvWrong);
        this.log = findViewById(R.id.login);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userName.getText().toString().equals("user") && password.getText().toString().equals("password"))
                {
                    Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
                    startActivity(intent);
                }
                else
                {
                    wrong.setVisibility(VISIBLE);
                }
            }
        });
    }
}

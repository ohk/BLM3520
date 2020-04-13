package com.example.blm3520;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class UserSettings extends AppCompatActivity {
    TextView name;
    TextView age;
    TextView height;
    TextView weight;
    RadioButton rb;
    Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);
    }
}

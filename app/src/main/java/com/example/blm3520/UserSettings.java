package com.example.blm3520;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class UserSettings extends AppCompatActivity implements View.OnClickListener{
    TextView name;
    TextView age;
    TextView height;
    TextView weight;
    RadioButton rb;
    RadioGroup rg;
    Switch sw;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);
        name = findViewById(R.id.text_settings_name);
        age = findViewById(R.id.text_settings_age);
        height = findViewById(R.id.text_settings_height);
        weight = findViewById(R.id.text_settings_weight);
        rg = findViewById(R.id.radio_settings_group);
        sw = findViewById(R.id.switch_settings_darkmode);
        save = findViewById(R.id.btn_settings_save);
        save.setOnClickListener(this);

        try {
            SharedPreferences sp = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
            name.setText(sp.getString("name",""));
            age.setText(String.valueOf(sp.getInt("age",0)));
            height.setText(String.valueOf(sp.getInt("height",0)));
            weight.setText(String.valueOf(sp.getFloat("weight",0)));
            rg.check(sp.getInt("radioGrup",2131165318));
            //Set data
            sw.setChecked(sp.getBoolean("switch",false));
        } catch(Exception e){
            Toast.makeText(getApplicationContext(), "Data not saved", Toast.LENGTH_LONG).show();
        }


        (findViewById(R.id.btn_settings_back)).setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent menu = new Intent(UserSettings.this,Menu.class);
                startActivity(menu);
            }
        });
    }

    @Override
    public void onClick(View v) {
        SharedPreferences sp = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("name",name.getText().toString());
        editor.putInt("age",Integer.parseInt(age.getText().toString()));
        editor.putInt("height",Integer.parseInt(height.getText().toString()));
        editor.putFloat("weight",Float.parseFloat(weight.getText().toString()));
        int selectedRadio = rg.getCheckedRadioButtonId();
        rb = findViewById(selectedRadio);
        editor.putInt("radioGrup",rb.getId());
        editor.putBoolean("switch",sw.isChecked());
        editor.apply();

        Toast.makeText(getApplicationContext(), "Preferences saved!", Toast.LENGTH_LONG).show();
    }
}

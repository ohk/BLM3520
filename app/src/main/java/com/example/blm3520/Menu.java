package com.example.blm3520;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //EMAIL
        (findViewById(R.id.btn_menu_email)).setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent email = new Intent(Menu.this,SendEmail.class);
                startActivity(email);
            }
        });

        //NOTES
        (findViewById(R.id.btn_menu_notes)).setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent notes = new Intent(Menu.this,NoteActivity.class);
                startActivity(notes);
            }
        });
        //List user
        (findViewById(R.id.btn_menu_users)).setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent listUser = new Intent(Menu.this,ListUser.class);
                startActivity(listUser);
            }
        });
        //Sensor
        (findViewById(R.id.btn_menu_sensor)).setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent sensor = new Intent(Menu.this, SensorControl.class);
                startActivity(sensor);
            }
        });
        //Settings
        (findViewById(R.id.btn_menu_settings)).setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent settings = new Intent(Menu.this,UserSettings.class);
                startActivity(settings);
            }
        });
    }
}

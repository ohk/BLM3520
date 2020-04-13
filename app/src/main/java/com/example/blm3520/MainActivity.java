package com.example.blm3520;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView username;
    TextView password;
    Users users;
    int failedLogin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = findViewById(R.id.btn_login);
        username = findViewById(R.id.field_username);
        password = findViewById(R.id.field_pass);
        users = new Users();
        login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if(users.checkUser(username.getText().toString(),password.getText().toString())){
            Intent menu = new Intent(MainActivity.this,Menu.class);
            startActivity(menu);
        } else {
            failedLogin++;
            alertDialog("Login Failed","Username or password is wrong. You can enter wrong 3 times in total.Total incorrect entries:" + failedLogin);
        }
        if(failedLogin == 3){
            finish();
            System.exit(0);
        }
        System.out.println("Failed login"+failedLogin);
    }

    private void alertDialog(String title,String message) {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage(message);
        dialog.setTitle(title);
        dialog.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                    }
                });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }
}

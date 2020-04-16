package com.example.blm3520;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ListUser extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<User> users ;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);


        recyclerView = findViewById(R.id.RecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        Users userList = new Users();
        users = userList.getUserList();
        System.out.println(users.size());

        UserAdapter userAdapter = new UserAdapter(users,context);
        recyclerView.setAdapter(userAdapter);


        (findViewById(R.id.btn_list_user_back)).setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent menu = new Intent(ListUser.this,Menu.class);
                startActivity(menu);
            }
        });
    }
}

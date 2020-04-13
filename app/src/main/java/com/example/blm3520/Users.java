package com.example.blm3520;

import android.util.Log;

import java.util.ArrayList;

public class Users {
    ArrayList<User> userList = new ArrayList<>();

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public Users() {
        userList.add(new User(
                "admin",
                "admin",
                "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2550&q=80")
        );
        userList.add(new User(
                "nousor",
                "yqqgjl",
                "https://images.unsplash.com/photo-1528892952291-009c663ce843?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1192&q=80")
        );
        userList.add(new User(
                "zinfor",
                "xzidgy",
                "https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2550&q=80")
        );
        userList.add(new User(
                "tionik",
                "tovjzc",
                "https://images.unsplash.com/photo-1519895609939-d2a6491c1196?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1234&q=80")
        );
        userList.add(new User(
                "precta",
                "cltlvb",
                "https://images.unsplash.com/photo-1508215302842-8a015a452a20?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=900&q=60")
        );
        userList.add(new User(
                "kateri",
                "exrqtk",
                "https://images.unsplash.com/photo-1501441858156-e505fb04bfbc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1266&q=80")
        );
    }

    public boolean checkUser(String username,String password){
        for(User a:userList){
            System.out.println("Username: " + username + "Password: " + password + "Kıyaslanan:" + a.username + "," + a.password);
            if(a.username.contentEquals(username) && a.password.contentEquals(password)){
                return true;
            }
        }
        return false;
    }
}

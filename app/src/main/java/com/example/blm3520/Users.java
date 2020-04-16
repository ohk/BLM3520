package com.example.blm3520;

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
                R.mipmap.wolverine
        ));
        userList.add(new User(
                "batman",
                "corona:)",
                R.mipmap.batman
        ));
        userList.add(new User(
                "superman",
                "clarkkent",
                R.mipmap.superman
        ));
        userList.add(new User(
                "wolverine",
                "hackedByDeadpool",
                R.mipmap.deadpool
        ));
        userList.add(new User(
                "spiderman",
                "BestSpiderInTheWorld",
                R.mipmap.spiderman
        ));
        userList.add(new User(
                "deadpool",
                "CaptainDeadpool!No,justDeadpool.",
                R.mipmap.deadpool
        ));
    }

    public boolean checkUser(String username,String password){
        for(User a:userList){
            if(a.username.contentEquals(username) && a.password.contentEquals(password)){
                return true;
            }
        }
        return false;
    }

    public User getUser(int position){
        return userList.get(position);
    }
}

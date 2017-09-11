package com.example.administrator.artly_android.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017-08-09.
 */

public class User {
    public String username;
    public String first_name;
    public String last_name;
    public String email;

    public User(String username, String first_name, String last_name, String email){
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

}

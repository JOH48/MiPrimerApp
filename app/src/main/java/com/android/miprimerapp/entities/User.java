package com.android.miprimerapp.entities;

public class User {
    String username;
    String name;
    String secondName;
    String password;

    public User(String username, String name, String secondName,
                String password){
        this.username=username;
        this.name=name;
        this.secondName=secondName;
        this.password=password;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

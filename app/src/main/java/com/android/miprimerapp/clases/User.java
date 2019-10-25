package com.android.miprimerapp.clases;

public class User {

    private String firstName;
    private String secondName;
    private String lastName;
    private String email;
    private String password;

    public User (String firstName, String secondName, String lastName, String email, String password ) {

        this.firstName=firstName;
        this.secondName=secondName;
        this.lastName=lastName;
        this.email=email;
        this.password=password;


    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


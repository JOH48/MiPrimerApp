package com.android.miprimerapp.dataBase;

import com.android.miprimerapp.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDataBase {
public static List<User> userList=new ArrayList<>();

public static Boolean searchUsername(String username){
    Boolean breturn=false;
    for(User user: userList){
        if(user.getUsername().equals(username)){
            breturn=true;
            break;
        }
    }
    return breturn;
}


public static void insertUser(String username, String name,
                              String secondName, String password){
    User newUser = new User(username, name, secondName, password);
    userList.add(newUser);
}

public static Boolean login(String username, String password){
    Boolean breturn = false;
    for ( User user: userList){
        if (user.getUsername().equals(username)&&user.getPassword().equals(password)){
            breturn = true;
            break;
        }
    }
    return breturn;
}

}

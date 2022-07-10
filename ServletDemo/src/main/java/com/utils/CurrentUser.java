package com.utils;

public class CurrentUser {

    // no constructor is needed because its static
    public static CurrentUser currentUser;
    public static Integer user_id;
    public static String first_name;
    public static String last_name;
    public static String email;

    public CurrentUser(Integer user_id, String first_name, String last_name, String email){

//        this.user_id = user_id;
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.email = email;
        CurrentUser.user_id = user_id;
        CurrentUser.first_name = first_name;
        CurrentUser.last_name = last_name;
        CurrentUser.email = email;

    }


}

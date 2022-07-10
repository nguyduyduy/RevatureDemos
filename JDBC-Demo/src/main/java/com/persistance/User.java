package com.persistance;

public class User {

    //these are variables
    //they describe the 'state' of our class
    private Integer user_id;
    private String first_name;
    private String last_name;
    private String email;

    // no args constructor
    public User(){


    }

    // this is the constructor we would use when retrieving from the database
    public User(Integer user_id, String first_name, String last_name, String email) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    //here we are not including the user_id
    // we would use this constructor when creating a user
    public User(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }



    // these are our getters and setters
    // because we have made our fields (or variables) private
    // we can use getters and setters to get or set the values
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {

        // I can add functionality to check the incoming info or param
        // or dependency to confirm that it is valid before setting it
        // to the class variable
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {

        // I can add functionality to this method to ensure that an email is valid
        // before creating a user
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }









}

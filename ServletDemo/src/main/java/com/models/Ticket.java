package com.models;

public class Ticket {
    Integer ticket_Id;
    String description;
    Integer user_Id;

    public Ticket() {
    }

        // This is for creating, our DB has ticket id as serial so no need to create
    public Ticket(String description, Integer user_Id) {
        this.description = description;
        this.user_Id = user_Id;
    }

        // This is for fetching or getting. Here we get all the info from the DB
    public Ticket(Integer ticket_Id, String description, Integer user_Id) {
        this.ticket_Id = ticket_Id;
        this.description = description;
        this.user_Id = user_Id;
    }

    public Integer getTicket_Id() {
        return ticket_Id;
    }

    public void setTicket_Id(Integer ticket_Id) {
        this.ticket_Id = ticket_Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Integer user_Id) {
        this.user_Id = user_Id;
    }
}



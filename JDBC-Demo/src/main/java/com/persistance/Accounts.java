package com.persistance;

import java.sql.Date;

public class Accounts {

    private Integer acc_id;

    private Double balance;

    private Integer type_id;

    private Integer user_id;

    private Date opened;

    private Date closed;


    public Accounts() {


    }

    // we will use to retrieve info from the database
    public Accounts(Integer acc_id, Double balance, Integer type_id, Integer user_id, Date opened, Date closed) {
        this.acc_id = acc_id;
        this.balance = balance;
        this.type_id = type_id;
        this.user_id = user_id;
        this.opened = opened;
        this.closed = closed;
    }


    //used tp create an account because the id is serial on the database
    //and we do not need to specify a closed date when we open an account
    public Accounts(Double balance, Integer type_id, Integer user_id, Date opened) {
        this.balance = balance;
        this.type_id = type_id;
        this.user_id = user_id;
        this.opened = opened;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Date getOpened() {
        return opened;
    }

    public void setOpened(Date opened) {
        this.opened = opened;
    }

    public Date getClosed() {
        return closed;
    }

    public void setClosed(Date closed) {
        this.closed = closed;
    }
}
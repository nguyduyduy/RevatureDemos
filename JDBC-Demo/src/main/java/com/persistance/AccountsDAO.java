package com.persistance;

import com.utils.ConnectionManager;
import com.utils.CustomDAOInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountsDAO implements CustomDAOInterface<Accounts> {

    Connection connection;

    public AccountsDAO(){

        connection = ConnectionManager.getConnection();

    }
    @Override
    public Integer create(Accounts accounts) {

        try {
            String sql = "INSERT INTO accounts (acc_id, balance, type_id, user_id, opened) VALUES (default, ?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setDouble(1, accounts.getBalance());
            pstmt.setInt(2, accounts.getType_id());
            pstmt.setInt(3, accounts.getUser_id());
            pstmt.setDate(4, accounts.getOpened());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            rs.next();

            return rs.getInt(1);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Accounts read(Integer id) {
        return null;
    }

    @Override
    public Accounts update(Accounts accounts) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}

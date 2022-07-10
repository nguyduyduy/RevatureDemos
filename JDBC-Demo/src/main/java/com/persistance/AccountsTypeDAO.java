package com.persistance;
import com.utils.ConnectionManager;
import com.utils.CustomDAOInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountsTypeDAO implements CustomDAOInterface<AccountsType> {

    Connection connection;

    public AccountsTypeDAO(){

        connection = ConnectionManager.getConnection();

    }


    @Override
    public Integer create(AccountsType accountsType) {

        try {
            String sql = "INSERT INTO accounttype (acc_ty_id, type_name) VALUES (default, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, accountsType.getType_name());

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
    public AccountsType read(Integer id) {
        return null;
    }

    @Override
    public AccountsType update(AccountsType accountsType) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}

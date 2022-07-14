package com.persistence;

import com.models.Ticket;
import com.utils.ConnectionManager;
import com.utils.CustomCRUDInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TicketDAO implements CustomCRUDInterface<Ticket> {


    Connection connection;
    // This will create the connection to the DB, unless already there
    public TicketDAO(){

        connection = ConnectionManager.getConnection();

    }

    @Override
    public Integer create(Ticket ticket) {

        try{

            String sql = "INSERT INTO tickets (ticket_id, description, user_id) VALUES (default, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, ticket.getDescription());
            pstmt.setInt(2, ticket.getUser_Id());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            rs.next();

            return rs.getInt(1);

        } catch(Exception e){

            System.out.println("This is the TicketDAO: " + e.getMessage());

        }

        return null;

    }

    @Override
    public Ticket read(Integer id) {
        return null;
    }

    @Override
    public Ticket update(Ticket ticket) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    // Taking in an Id and returning an ArrayList
    public ArrayList<Ticket> getAllTicketsForCurrentUser(Integer id){

        ArrayList<Ticket> allTickets = new ArrayList<>();

        // here we are connecting to the DB with try
        try {

            String sql = "SELECT * FROM tickets WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            // 1 is setting the parameter, and id from method parameter
            pstmt.setInt(1, id);


            ResultSet rs = pstmt.executeQuery();

            // While there is something in the ResultSet, I will execute the logic in the while loop, which is creating the Ticket
            // This logic will create the new Ticket
            while(rs.next()){
                // 1 = ticket id, 2 = description, 3 = user id
                Ticket newTicket = new Ticket(rs.getInt(1),rs.getString(2),rs.getInt(3));
                allTickets.add(newTicket);
            }

        } catch (Exception e){
            System.out.println("This is the TicketDAO: " + e.getMessage());
        }
        return allTickets;
    }
}

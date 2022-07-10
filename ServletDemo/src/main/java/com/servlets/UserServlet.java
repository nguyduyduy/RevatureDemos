package com.servlets;
import com.models.User;
import com.persistence.UserDAO;
import com.utils.CurrentUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    UserDAO userDAO = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);

//        Integer userId = Integer.parseInt(req.getParameter("user-id-input"));
//        User myUser = userDAO.read(userId);
//        resp.getWriter().println(myUser.getUser_id());
//        resp.getWriter().println(myUser.getFirst_name());
//        resp.getWriter().println(myUser.getLast_name());
//        resp.getWriter().println(myUser.getEmail());
//        System.out.println(resp.getStatus() + " - here we are printing out the response code");
        String email = String.valueOf(req.getParameter("email-sign-in"));
        String password = String.valueOf(req.getParameter("password-sign-in"));

        CurrentUser.currentUser = userDAO.loginCurrentUser(email, password);

        // this can be to decipher between employee types

//        if (CurrentUser.employeeType == "employee"){
//            // do some logic
//        } else {
//            // do some other logic
//        }
        // this logic allows us to either take a user to their ticket page
        // if we create an html page specific for tickets
        // or if the login is wrong and there is no user
        // it can take you to your error.html page
//        if (CurrentUser.currentUser == null){
//            req.getRequestDispatcher("error-page.html");
//        } else {
//            req.getRequestDispatcher("tickets.html");
//        }

        // HERE I am redirecting the client to the welcome.html page
        req.getRequestDispatcher("welcome.html").forward(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPut(req, resp);

        // here we are getting the values from the html form and
        // setting them to variables that we can use to create a user and call the create method
        // that will create a user in our database

        String firstName = String.valueOf(req.getParameter("firstName-input"));
        String lastName = String.valueOf(req.getParameter("lastName-input"));
        String email = String.valueOf(req.getParameter("email-input"));

        User newUser = new User(firstName,lastName,email);
        userDAO.create(newUser);

        resp.setStatus(203);

        // this is redirecting us to the index.html page aka our sign-in page
        req.getRequestDispatcher("index.html").forward(req,resp);
    }




}

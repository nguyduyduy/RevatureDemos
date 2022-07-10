package com.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        // we are sending a get form on the submit button in the login html 'action'
        //signUp.html will be created, this allows us to redirect users to this form
        req.getRequestDispatcher("signUp.html").forward(req,resp);
        System.out.println(resp.getStatus());
    }
}

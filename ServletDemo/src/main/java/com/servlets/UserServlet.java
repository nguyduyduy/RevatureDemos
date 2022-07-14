package com.servlets;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.Ticket;
import com.models.User;
import com.persistence.TicketDAO;
import com.persistence.UserDAO;
import com.utils.CurrentUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UserServlet extends HttpServlet {

    UserDAO userDAO = new UserDAO();
    TicketDAO ticketDAO = new TicketDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String URI = req.getRequestURI().replace("/ServletDemo/","");

        System.out.println(URI);

        switch (URI){
            case "tickets":

                getAllTicketsForCurrentUser(req,resp);

                break;

            default:
                System.out.println("We are in the default");
                break;
        }
//        // super.doGet(req, resp);
//
////        Integer userId = Integer.parseInt(req.getParameter("user-id-input"));
////        User myUser = userDAO.read(userId);
////        resp.getWriter().println(myUser.getUser_id());
////        resp.getWriter().println(myUser.getFirst_name());
////        resp.getWriter().println(myUser.getLast_name());
////        resp.getWriter().println(myUser.getEmail());
////        System.out.println(resp.getStatus() + " - here we are printing out the response code");
//        String email = String.valueOf(req.getParameter("email-sign-in"));
//        String password = String.valueOf(req.getParameter("password-sign-in")); //name from html file allowing us to get
//
//        CurrentUser.currentUser = userDAO.loginCurrentUser(email, password);
////
//        // this can be to decipher between employee types
//
////        if (CurrentUser.employeeType == "employee"){
////            // do some logic
////        } else {
////            // do some other logic
////        }
//        // this logic allows us to either take a user to their ticket page
//        // if we create an html page specific for tickets
//        // or if the login is wrong and there is no user
//        // it can take you to your error.html page
////        if (CurrentUser.currentUser == null){
////            req.getRequestDispatcher("error-page.html");
////        } else {
////            req.getRequestDispatcher("tickets.html");
////        }
//
//        // HERE I am redirecting the client to the welcome.html page
//        req.getRequestDispatcher("welcome.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String URI = req.getRequestURI().replace("/ServletDemo/", "");
        System.out.println(URI);

        switch (URI) {

            case "user":

                processUserLogin(req,resp);


                break;

            case "tickets":

                createNewTicket(req,resp);

                break;

            default:
                System.out.println("We are in the default");
                break;
        }

//        //super.doPut(req, resp);
//
//        // here we are getting the values from the html form and
//        // setting them to variables that we can use to create a user and call the create method
//        // that will create a user in our database
//
//        String firstName = String.valueOf(req.getParameter("firstName-input"));
//        String lastName = String.valueOf(req.getParameter("lastName-input"));
//        String email = String.valueOf(req.getParameter("email-input"));
//
//        User newUser = new User(firstName,lastName,email);
//        userDAO.create(newUser);
//
//        resp.setStatus(203);
//
//        // this is redirecting us to the index.html page aka our sign-in page
//        req.getRequestDispatcher("index.html").forward(req,resp);
    }

    // Here we are creating a helper method to login a user
    private void processUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        BufferedReader br = req.getReader();
        String line = br.readLine();


        StringBuilder sb = new StringBuilder();




        // Here we are going to read through each line of our req.getReader
        // It is possible for there to be only 1 line in our br
        // but creating a while loop is the safest way

        while (line != null){
            sb.append(line);
            line = br.readLine();
        }


        System.out.println(sb);

        String body = sb.toString();

        String[] sepByComma = body.split(",");


        ArrayList<String> values = new ArrayList<>();

        // will print out index 0 and 1 that is separated by comma
        for(String value: sepByComma) {
//            System.out.println(value);

            // Here we want to trim all of the excess symbols as well as
            // keys and key the values
            // note we can add multiple replaceAll functions
            // removes all "" and , commands

           value = value.replaceAll("\\{","").replaceAll("}","").replaceAll("\"","");

                    String target = value.substring(value.indexOf(":") + 1);

            System.out.println(target);
            values.add(target);

        }

            String email = values.get(0);
            String password = values.get(1);

            // Here we are doing the logic to login
            User user = userDAO.loginCurrentUser(email, password);

            if(user != null){
                resp.setStatus(200);

                // Get a HTTP session
                HttpSession session = req.getSession();
                session.setAttribute("user", user);

                PrintWriter out = resp.getWriter();

                resp.setContentType("application/json");

                ObjectMapper om = new ObjectMapper();

                // Convert the object with the mapper

                out.println(om.writeValueAsString(user));

                System.out.println("The user with: " + email + "has logged in");

            } else {
                resp.setStatus(204);
            }

        }


                            // Here we are creating a helper method to get all the current users tickets

    private void getAllTicketsForCurrentUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
         resp.setStatus(200);
         resp.setContentType("application/json");

         // Get the user id that we set in the header
         // Taking a string and changing it into an int
        Integer id = Integer.parseInt(req.getHeader("user-id"));

        System.out.println(id + " this is the user id from our header");

        // Getting the tickets from the backend
        // We are getting the id from the parsing of our header in the getAllTicketsForCurrentUser(id)
        ArrayList<Ticket> allTickets = ticketDAO.getAllTicketsForCurrentUser(id);

        // Create object mapper - this will change our array to JSON
        ObjectMapper mapper = new ObjectMapper();

        // Write this mapper as a string and it's going to be named json
        String json = mapper.writeValueAsString(allTickets);
        System.out.println(json);
        PrintWriter out = resp.getWriter();
        out.println(json);

    }

                                            // Helper method to create a new ticket
    private void createNewTicket(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader br = req.getReader();
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();

        while (line != null){
            sb.append(line);

            line = br.readLine();
        }

        System.out.println(sb);

        Integer id = Integer.parseInt(req.getHeader("user-id"));

        System.out.println(id + " this is suppose to be our id from" +  "req.getHeader in the create new ticket method");

            // I am sending a description from my front end (via JSON)
            // I am getting the id from the headers

        String description = sb.toString().replaceAll("\"","");

        Ticket newTicket = new Ticket(description, id);
        System.out.println(newTicket.getUser_Id() + "" + newTicket.getDescription());

        Integer ticketId = ticketDAO.create(newTicket);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(ticketId);

        PrintWriter out = resp.getWriter();

        out.println(json);

        resp.setStatus(200);
        resp.setContentType("application/json");


    }


    }






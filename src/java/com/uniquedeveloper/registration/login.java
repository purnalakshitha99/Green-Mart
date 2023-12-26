/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uniquedeveloper.registration;

import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
  
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asust
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {  
   @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String uemail = request.getParameter("username");
    String upwd = request.getParameter("password");
    HttpSession session = request.getSession();
    RequestDispatcher dispatcher = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/esupermarket", "root", "1234567");
        PreparedStatement pst = con.prepareStatement("select * from user where uemail=? and upwd=?");
        pst.setString(1, uemail);
        pst.setString(2, upwd);

        ResultSet rs = pst.executeQuery();
        
        if (rs.next()) {
            session.setAttribute("userId", rs.getString("id"));
            session.setAttribute("name", rs.getString("uname"));
            session.setAttribute("balance", rs.getDouble("ubalance"));
            session.setAttribute("email", rs.getString("uemail"));
            dispatcher = request.getRequestDispatcher("index.jsp");
        } else {
            request.setAttribute("status", "failed");
            dispatcher = request.getRequestDispatcher("login.jsp");
        }
        dispatcher.forward(request, response);

    } catch (ClassNotFoundException | SQLException | ServletException e) {
        e.printStackTrace(); // Handle the exception according to your needs
    }

      
    }


}

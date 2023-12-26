
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uniquedeveloper.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
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
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/Register"})
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        
                 String uname=request.getParameter("name");
                 String uemail=request.getParameter("email");
                 String upwd=request.getParameter("pass");
                 String umobile=request.getParameter("contact");
                 double balance=100000;
                 RequestDispatcher dispatcher=null;
                 Connection con=null;
                 
                 try{
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/esupermarket", "root", "1234567");
                 PreparedStatement pst = con.prepareStatement("insert into user(uname,upwd,uemail,umobile,ubalance) values(?,?,?,?,?)");
                 {
                 pst.setString(1,uname);
                 pst.setString(2,upwd);
                 pst.setString(3,uemail);
                 pst.setString(4,umobile);
                 pst.setDouble(5,balance);
                 
                 int rowCount = pst.executeUpdate();
                 dispatcher=request.getRequestDispatcher("registration.jsp");
                 if(rowCount>0){
                     request.setAttribute("status","success");    
                 }else{
                     request.setAttribute("status","failed");
                 }
                 
                 dispatcher.forward(request,response);}
                 }catch (SQLException | ClassNotFoundException e) {
                     // Handle the exception more gracefully, log it, or send a meaningful response to the user.
                     
    }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author piyum
 */
@WebServlet(name = "purchase", urlPatterns = {"/purchase"})
public class purchase {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        
                 String id=request.getParameter("id");
              
                 RequestDispatcher dispatcher=null;
                 Connection con=null;
                 
                 try{
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/esupermarket", "root", "");
                 PreparedStatement pst = con.prepareStatement("insert into user(number) values(?)");
                 {
                 pst.setString(1,id);
               
                 
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

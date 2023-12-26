/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uniquedeveloper.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chamith
 */
@WebServlet(name = "CartCheckoutServlet", urlPatterns = {"/CartCheckoutServlet"})
public class CartCheckoutServlet extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve parameters from the request
              String userIdString = (String) request.getSession().getAttribute("userId");
            int userId = Integer.parseInt(userIdString);
            
            if (userIdString != null && !userIdString.isEmpty())
            {
                request.setAttribute("userId", userId);
       
                request.getRequestDispatcher("cartCheckout.jsp").forward(request, response);
            } else {
                System.out.println("Pass null values in checkout");
                response.sendRedirect("error.jsp");
            }
        } catch (NumberFormatException e) {
            // Handle the exception (e.g., log or display an error message)
            e.printStackTrace();
        }
    }
 

}

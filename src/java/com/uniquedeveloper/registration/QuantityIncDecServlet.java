/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uniquedeveloper.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asust
 */
@WebServlet(name = "QuantityIncDecServlet", urlPatterns = {"/quantity-inc"})
public class QuantityIncDecServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String productIdString = request.getParameter("id");
            String cartIdString = request.getParameter("cartId");
            String quantity = request.getParameter("quantity");
            String type= request.getParameter("type");
            int Quantity = Integer.parseInt(quantity);
            if ( Quantity==0 && "dec".equals(type)) {
                
            response.sendRedirect("cart.jsp"); 
               
            } else {  
                 int productId = Integer.parseInt(productIdString);
                int cartId = Integer.parseInt(cartIdString);
                CartDao cartDao = new CartDao();
                try {
                    cartDao.increaseQuantity(cartId, productId,Quantity,type);
                    response.sendRedirect("cart.jsp");
                } catch (Exception e) {
                    out.println("Error increasing  " + e.getMessage());
                }
            }
        } catch (NumberFormatException e) {
            // Handle the NumberFormatException if necessary
            e.printStackTrace();
        }
    }


}



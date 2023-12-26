/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uniquedeveloper.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uniquedeveloper.registration.DbCon;
import com.uniquedeveloper.registration.OrderDao;
import com.uniquedeveloper.registration.*;

@WebServlet(name = "CheckOutServlet", urlPatterns = {"/check-out"})
public class CheckOutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve parameters from the request
            String userIdStr = request.getParameter("userId");
            String productIdStr = request.getParameter("productId");
            String quantityStr = request.getParameter("quantity");
            String cartIdStr = request.getParameter("quantity");
            
           
            // Check if parameters are not null or empty
            if (userIdStr != null && !userIdStr.isEmpty() &&
                    productIdStr != null && !productIdStr.isEmpty() &&
                    quantityStr != null && !quantityStr.isEmpty()) {

                // Parse parameters to integers
                int userId = Integer.parseInt(userIdStr);
                int productId = Integer.parseInt(productIdStr);
                int quantity = Integer.parseInt(quantityStr);
                 int cartId = Integer.parseInt(cartIdStr);
                  
                // Set request attributes
                request.setAttribute("userId", userId);
                request.setAttribute("productId", productId);
                request.setAttribute("quantity", quantity); 
                request.setAttribute("cartId",cartId);
                
                ProductDao productDao=new ProductDao(DbCon.getConnection());
                Product proudct=new Product();
                
                proudct= productDao.getProductById(productId);
                
                
                
                request.setAttribute("productName",proudct.getName());
                request.setAttribute("price",proudct.getPrice());
                request.setAttribute("category",proudct.getCategory());
                
                // Redirect to checkout.jsp
                request.getRequestDispatcher("checkout.jsp").forward(request, response);
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

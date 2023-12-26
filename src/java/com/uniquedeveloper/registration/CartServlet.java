/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uniquedeveloper.registration;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CartServlet", urlPatterns = {"/addToCart"})
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve parameters from the request
            String userIdStr = request.getParameter("userId");
            String productIdStr = request.getParameter("productId");
            String quantityStr = request.getParameter("quantity");

            // Check if parameters are not null or empty
            if (userIdStr != null && !userIdStr.isEmpty() &&
                productIdStr != null && !productIdStr.isEmpty() &&
                quantityStr != null && !quantityStr.isEmpty()) {

                // Parse parameters to integers
                int userId = Integer.parseInt(userIdStr);
                int productId = Integer.parseInt(productIdStr);
                int quantity = Integer.parseInt(quantityStr);

                // Call the DAO to add the item to the cart
                CartDao cartDao = new CartDao();
                cartDao.addToCart(userId, productId, quantity);

                // Redirect to a page or send a response
                response.sendRedirect("cart.jsp");
            } else {
                // Handle the case where parameters are missing or empty
                // You can redirect to an error page or display an error message
                response.sendRedirect("error.jsp");
            }
        } catch (NumberFormatException e) {
            // Handle the exception (e.g., log or display an error message)
            e.printStackTrace();
            
        }
    }
}

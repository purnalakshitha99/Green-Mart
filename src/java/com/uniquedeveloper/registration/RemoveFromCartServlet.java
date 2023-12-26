package com.uniquedeveloper.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RemoveFromCartServlet", urlPatterns = {"/remove-from-cart"})
public class RemoveFromCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String productIdString = request.getParameter("id");
            String cartIdString = request.getParameter("cartId");

            if (productIdString != null && cartIdString != null) {
                int productId = Integer.parseInt(productIdString);
                int cartId = Integer.parseInt(cartIdString);

               
                CartDao cartDao = new CartDao();

                try {
                    cartDao.removeCartItem(cartId, productId);
                    response.sendRedirect("cart.jsp");
                } catch (Exception e) {
                    out.println("Error removing item from cart: " + e.getMessage());
                }
            } else {
                 System.out.println("hehe");
                response.sendRedirect("cart.jsp");
            }
        } catch (NumberFormatException e) {
            // Handle the NumberFormatException if necessary
            e.printStackTrace();
        }
    }
}

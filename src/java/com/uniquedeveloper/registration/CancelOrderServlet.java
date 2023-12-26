/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uniquedeveloper.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CancelOrderServlet", urlPatterns = {"/cancel-order"})
public class CancelOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        		try(PrintWriter out = response.getWriter()) {
			int productId = Integer.parseInt(request.getParameter("id"));
                        int cartId= Integer.parseInt(request.getParameter("cardId"));
                   
			if(request.getParameter("cardId") != null) {
				CartDao cartDao=new CartDao();
                                cartDao.removeCartItem(cartId, productId);
			}
			response.sendRedirect("orders.jsp");
		} catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }

}

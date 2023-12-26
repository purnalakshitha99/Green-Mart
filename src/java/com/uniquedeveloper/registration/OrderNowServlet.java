/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uniquedeveloper.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uniquedeveloper.registration.DbCon;
import com.uniquedeveloper.registration.*;
import javax.servlet.http.HttpSession;

@WebServlet(name = "OrderNowServlet", urlPatterns = {"/order-now"})
public class OrderNowServlet extends HttpServlet {

   @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();

    Order order = new Order();
    HttpSession session = request.getSession();
    int uid = Integer.parseInt(request.getParameter("uid"));
     int cartId = Integer.parseInt(request.getParameter("cartId"));
    int pid = Integer.parseInt(request.getParameter("productId"));
    double price = Double.parseDouble(request.getParameter("price"));
    String name = request.getParameter("productName");
    int quantity = Integer.parseInt(request.getParameter("quantity")); 
    double balance = (Double)request.getSession().getAttribute("balance");
    String email=(String)request.getSession().getAttribute("email");
    double updatebalance=balance-price;
    
    order.setProductName(name);
    order.setProductId(pid);
    order.setQunatity(quantity);
    order.setUid(uid);
    order.setTPrice(price);
    order.setDate(formatter.format(date)); // Set the current date in the required format

    OrderDao orderDao = new OrderDao(DbCon.getConnection());
    
    boolean status=orderDao.insertOrder(order);
    
    if(cartId!=90000){
        CartDao cartDao= new CartDao();
        cartDao.removeCartItem(cartId, pid);
    }
    
    
    if(status){
        
        
          OrderDao orderDAO = new OrderDao(DbCon.getConnection());
          orderDAO.purchase(updatebalance, uid);
          session.setAttribute("balance", updatebalance);
          sendOrderConfirmationEmail(email,order.getProductName(),price );
          response.sendRedirect("order.jsp");
    }
    else{
        response.sendRedirect("error.jsp");
    }
    
}

 private void sendOrderConfirmationEmail(String userEmail, String productName,double price) {
        final String username = "greenmart227@gmail.com"; // Gmail email address
        final String password = "zspzyrgpkofyguya"; //  app  password

        // Set the properties for the email server
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Create a session with the email server
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
            message.setSubject("Order Confirmation");
            message.setText("Dear Customer,\n\nThank you for your order of " + productName +
                    ". Your order has been successfully placed. You paid "+price+" from your green card.\n\nYour sincerely,\nGreen Supermarket");


            // Send the message
            Transport.send(message);

            System.out.println("Order confirmation email sent to: " + userEmail);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
    

}
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.uniquedeveloper.registration.DbCon;
import com.uniquedeveloper.registration.*;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Chamith
 */
@WebServlet(name = "CartOrderServlet", urlPatterns = {"/CartOrderServlet"})
public class CartOrderServlet extends HttpServlet {

   @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
        HttpSession session = request.getSession();
      String userIdString = (String) request.getSession().getAttribute("userId");
      int userId = Integer.parseInt(userIdString);
      String email=(String)request.getSession().getAttribute("email");
        double balance = (Double)request.getSession().getAttribute("balance");
    List<Cart> cartProduct = (List<Cart>) request.getSession().getAttribute("cartProduct");
     OrderDao orderDAO = new OrderDao(DbCon.getConnection());
     
    for(Cart c:cartProduct){
        Order order=new Order();
        CartDao cartDao= new CartDao();
        order.setProductName(c.getName());
        order.setProductId(c.getId());
        order.setQunatity(c.getQuantity());
        order.setUid(userId);
        order.setTPrice(c.getPrice());
        order.setDate(formatter.format(date)); // Set the current date in the required format
        balance=balance-(c.getPrice());
      
    OrderDao orderDao = new OrderDao(DbCon.getConnection());
    boolean status=orderDao.insertOrder(order);

      if(!status){
         response.sendRedirect("error.jsp");   
    }
      cartDao.removeCartItem(c.getCartId(), c.getId()); 
          orderDAO.purchase(balance, userId);
          session.setAttribute("balance", balance);
    }

    
    sendOrderConfirmationEmail(email,"Items",balance );
     response.sendRedirect("order.jsp");

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
                    ". Your order has been successfully placed. Now Your green card balance is "+price+"\n\nYour sincerely,\nGreen Supermarket");

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
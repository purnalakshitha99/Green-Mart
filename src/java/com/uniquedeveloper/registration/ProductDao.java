/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uniquedeveloper.registration;

import java.sql.*;
import java.util.*;


public class ProductDao {
    private final Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;
    

	public ProductDao(Connection con) {
		super();
		this.con = con;
	}
	
	
	public List<Product> getAllProducts() {
        List<Product> book = new ArrayList<>();
        try {

            query = "select * from products";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
            	Product row;
                row = new Product();
                row.setId(rs.getInt("id"));
                row.setName(rs.getString("name"));
                row.setCategory(rs.getString("category"));
                row.setPrice(rs.getDouble("price"));
                row.setImage(rs.getString("image"));

                book.add(row);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return book;
    }
	
	
	 public Product getSingleProduct(int id) {
		 Product row = null;
	        try {
	            query = "select * from products where id=? ";

	            pst = this.con.prepareStatement(query);
	            pst.setInt(1, id);
	            ResultSet sr= pst.executeQuery();

	            while (sr.next()) {
	            	row = new Product();
	                row.setId(sr.getInt("id"));
	                row.setName(sr.getString("name"));
	                row.setCategory(sr.getString("category"));
	                row.setPrice(sr.getDouble("price"));
	                row.setImage(sr.getString("image"));
	            }
	        } catch (SQLException e) {
                    
	            System.out.println(e.getMessage());
	        }

	        return row;
	    }
	
	public double getTotalCartPrice(ArrayList<Cart> cartList) {
        double sum = 0;
        try {
            if (!cartList.isEmpty()) {
                for (Cart item : cartList) {
                    query = "select price from products where id=?";
                    pst = this.con.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        sum+=rs.getDouble("price")*item.getQuantity();
                    }

                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sum;
    }

    
public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
    List<Cart> book = new ArrayList<>();

    try {
        if (!cartList.isEmpty()) {
            // Use the existing connection passed to the constructor
            for (Cart item : cartList) {
                
                query = "select * from products where id=?";
                pst = con.prepareStatement(query);
                pst.setInt(1, item.getId());
                rs = pst.executeQuery();
                while (rs.next()) {
                    Cart row = new Cart();
                    row.setId(rs.getInt("id"));
                    row.setProductName(rs.getString("name"));
                    row.setCategory(rs.getString("category"));
                    row.setPrice(rs.getDouble("price") * item.getQuantity());
                    row.setQuantity(item.getQuantity());
                    row.setCartId(item.getCartId());
                    book.add(row);
                }
            }
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return book;
}

public Product getProductById(int pid) {
    Product product = new Product();
    try {
        query = "select * from products where id=?";
        pst = con.prepareStatement(query);
        pst.setInt(1, pid);
        rs = pst.executeQuery();

        // Move the cursor to the first row
        if (rs.next()) {
            // Access data after moving the cursor to the first row
            product.setName(rs.getString("name"));
            product.setCategory(rs.getString("category"));
            product.setPrice(rs.getDouble("price"));

            System.out.println(product.getName());
        }
    } catch (SQLException e) {
        System.out.println("hehe");
        System.out.println(e.getMessage());
    }
    return product;
}


}

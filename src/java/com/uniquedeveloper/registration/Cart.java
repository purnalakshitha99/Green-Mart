package com.uniquedeveloper.registration;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int id;
    public int userId;
    private int cartId;
    private String productName;
    private String category ;
    private double price;
    private int quantity;
    
    private List<Cart> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

   

  
    // Add a method to add a CartItem to the list
   

    // Add a method to remove a CartItem from the list
    public void removeItem(CartItem cartItem) {
        this.items.remove(cartItem);
    }
     public int getId() {
        return this.id;
    }
     public String getName(){
         return this.productName;
     }
     public String getCategory(){
         return this.category;
     }
     public double getPrice(){
        return this.price;
     }
     
     public int getQuantity(){
         return quantity;
     }
     public int getCartId(){
         return cartId;
     }
     public void setCartId(int id){
         this.cartId=id;
     }
     
     public void setId(int id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setUserId(int id){
        this.userId=id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    // Setter for cartItems
    public void setItems(List<Cart> cartItems) {
        this.items = cartItems;
    }

}

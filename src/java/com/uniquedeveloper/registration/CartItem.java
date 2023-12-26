package com.uniquedeveloper.registration;

public class CartItem {
    private int id; // Assuming you have an ID for cart items
    private int productId;
    private int quantity;

    public CartItem(int id, int productId, int quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getProduct() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

package com.uniquedeveloper.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
  public void addToCart(int userId, int productId, int quantity) {
        try (Connection connection = DbCon.getConnection()) {
            // Check if the user has an existing cart
            int cartId = getCartIdForUser(userId, connection);

            if (cartId == -1) {
                // If the user does not have an existing cart, create a new cart
                cartId = createCartForUser(userId, connection);
            }

            // Check if the product is already in the cart
            int cartItemId = getCartItemIdForProduct(cartId, productId, connection);

            if (cartItemId != -1) {
                // If the product is in the cart, update the quantity
                int currentQuantity = getCartItemQuantity(cartItemId, connection);
                int newQuantity = currentQuantity + quantity;

                String updateSql = "UPDATE cartitem SET quantity = ? WHERE idCartItem = ?";
                try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
                    updateStatement.setInt(1, newQuantity);
                    updateStatement.setInt(2, cartItemId);
                    updateStatement.executeUpdate();
                }
            } else {
                // If the product is not in the cart, insert a new row into cartitem
                String insertSql = "INSERT INTO cartitem (cartId, productId, quantity) VALUES (?, ?, ?)";
                try (PreparedStatement insertStatement = connection.prepareStatement(insertSql)) {
                    insertStatement.setInt(1, cartId);
                    insertStatement.setInt(2, productId);
                    insertStatement.setInt(3, quantity);
                    insertStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }
  
public ArrayList<Cart> getCartListForUser(int userId) {
    ArrayList<Cart> cartList = new ArrayList<>();
    try (Connection connection = DbCon.getConnection()) {
        List<Integer> cartIds = getCartIdsForUser(userId, connection);

        for (int cartId : cartIds) {
            Cart cart = new Cart();
            cart.setUserId(userId);
           

            List<Cart> cartItems = getCartItemsForCart(cartId, connection);
            cart.setId(cartId);
            cart.setItems(cartItems);
            
             for(Cart c: cartItems){
             Cart cart1 = new Cart();
            cart1.setId(c.getId());
            cart1.setQuantity(c.getQuantity());
            cart1.setCartId(c.getCartId());
             cartList.add(cart1);

    }
                     
        }
       
    } catch (SQLException e) {
        System.out.println("Error retrieving cart list");
        e.printStackTrace(); // Handle the exception according to your needs
    }
     
  
     
    return cartList;
}

private List<Cart> getCartItemsForCart(int cartId, Connection connection) throws SQLException {
    List<Cart> cartItems = new ArrayList<>();
    String sql = "SELECT productId, quantity FROM cartitem WHERE cartId = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, cartId);
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                
                int productId = resultSet.getInt("productId");
                int quantity = resultSet.getInt("quantity");
               
                Cart cartItem = new Cart();
               
                cartItem.setQuantity(quantity);
                cartItem.setId(productId);
                cartItem.setCartId(cartId);
                
                cartItems.add(cartItem);
               
            }
        }
    }
    
   
    return cartItems;
}


    private List<Integer> getCartIdsForUser(int userId, Connection connection) throws SQLException {
        List<Integer> cartIds = new ArrayList<>();
        String sql = "SELECT cartId FROM cart WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cartIds.add(resultSet.getInt("cartId"));
                }
            }
        }
        
        return cartIds;
    }
    

    private int getCartIdForUser(int userId, Connection connection) throws SQLException {
        String sql = "SELECT cartId FROM cart WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next() ? resultSet.getInt("cartId") : -1;
            }
        }
    }
    
     
    
    
    
    
    
    
     

    private int getCartItemIdForProduct(int cartId, int productId, Connection connection) throws SQLException {
        String sql = "SELECT idCartItem FROM cartitem WHERE cartId = ? AND productId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, cartId);
            statement.setInt(2, productId);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next() ? resultSet.getInt("idCartItem") : -1;
            }
        }
    }
     private int createCartForUser(int userId, Connection connection) throws SQLException {
        // Insert a new row for the user in the cart table and return the generated cartId
        String insertSql = "INSERT INTO cart (user_id) VALUES (?)";
        try (PreparedStatement insertStatement = connection.prepareStatement(insertSql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStatement.setInt(1, userId);
            insertStatement.executeUpdate();

            try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating cart failed, no ID obtained.");
                }
            }
        }
    }

    private int getCartItemQuantity(int cartItemId, Connection connection) throws SQLException {
        String sql = "SELECT quantity FROM cartitem WHERE idCartItem = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, cartItemId);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next() ? resultSet.getInt("quantity") : -1;
            }
        }
    }
    
    public void removeCartItem(int cartId,int productId) {
        try (Connection connection = DbCon.getConnection()) {
            
            String deleteSql = "DELETE FROM cartitem WHERE cartId = ? and productId=? ";
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
                deleteStatement.setInt(1, cartId);
                 deleteStatement.setInt(2, productId);
                int rowsDeleted = deleteStatement.executeUpdate();
                  
                if (rowsDeleted > 0) {
                    System.out.println("Cart item removed successfully.");
                } else {
                    System.out.println("Cart item not found or already removed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }
    
public void increaseQuantity(int cartId, int productId, int quantity,String type) {
    try (Connection connection = DbCon.getConnection()) {
         
       int newQuantity=quantity;
       
        if("int".equals(type)){
            System.out.println(type);
              ++newQuantity;
        }
        else if("dec".equals(type)){
              --newQuantity;
        }

        String updateSql = "UPDATE cartitem SET quantity = ? WHERE cartId = ? AND productId = ?";
        try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
            updateStatement.setInt(1, newQuantity);
            updateStatement.setInt(2, cartId);
            updateStatement.setInt(3, productId);
            updateStatement.executeUpdate();

            System.out.println("Quantity update successfully.");
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle the exception according to your needs
    }
}

    
    
    
}

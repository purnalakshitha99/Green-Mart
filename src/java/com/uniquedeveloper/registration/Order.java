/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uniquedeveloper.registration;

/**
 *
 * @author asust
 */
public class Order extends Product {
    private int orderId;
	private int uid;
        private int pid;
	private int qunatity;
	private String date;
        private String productName;
	private double price;
        
        
	public Order() {
	}
	
	public Order(int orderId, int uid, int qunatity, String date) {
		super();
		this.orderId = orderId;
		this.uid = uid;
		this.qunatity = qunatity;
		this.date = date;
	}

	public Order(int uid, int qunatity, String date) {
		super();
		this.uid = uid;
		this.qunatity = qunatity;
		this.date = date;
	}
        public String getProductName(){
            return this.productName;
        }
         public void setProductName(String name){
            this.productName=name;
        }
         public double getTPrice() {
		return this.price;
	}
         public void setTPrice(double price) {
		this.price = price;
	}
   

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
        public void setProductId(int productId){
            this.pid=productId;
        }
        
        public int getProductId(){
            return pid;
        }
	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getQunatity() {
		return qunatity;
	}
	public void setQunatity(int qunatity) {
		this.qunatity = qunatity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}

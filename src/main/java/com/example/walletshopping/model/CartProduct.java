package com.example.walletshopping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CartProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int cartProductId;
	private int cartId;
	private int productId;
	private int noOfQuantities;
	
	public int getNoOfQuantities() {
		return noOfQuantities;
	}
	public void setNoOfQuantities(int noOfQuantities) {
		this.noOfQuantities = noOfQuantities;
	}
	public int getCartProductId() {
		return cartProductId;
	}
	public void setCartProductId(int cartProductId) {
		this.cartProductId = cartProductId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
}

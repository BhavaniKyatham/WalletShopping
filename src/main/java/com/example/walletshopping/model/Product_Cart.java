package com.example.walletshopping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product_Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int product_CartId;
	private int productId;
	private int noOfQuantities;
	private int cartId;
	public int getProduct_CartId() {
		return product_CartId;
	}
	public void setProduct_CartId(int product_CartId) {
		this.product_CartId = product_CartId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getNoOfQuantities() {
		return noOfQuantities;
	}
	public void setNoOfQuantities(int noOfQuantities) {
		this.noOfQuantities = noOfQuantities;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

}

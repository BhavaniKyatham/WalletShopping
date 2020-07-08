package com.example.walletshopping.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.walletshopping.model.Product_Cart;

public interface CartProductDao extends CrudRepository<Product_Cart, Integer> {

	@Query(value="select p.product_id from product_cart p where p.cart_id=:cartId",nativeQuery = true)
	int findProductIdByCartId(int cartId);
	
	
	@Query(value="select p.no_of_quantities from product_cart p where p.cart_id=:cartId",nativeQuery = true)
	int findNoOfQuantiesBycartId(int cartId);


}

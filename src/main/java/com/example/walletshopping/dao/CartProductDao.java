package com.example.walletshopping.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.walletshopping.model.CartProduct;

@Repository
public interface CartProductDao extends CrudRepository<CartProduct, Integer> {

	@Query(value="select p.product_id from product_cart p where p.cart_id=:cartId",nativeQuery = true)
	int findProductIdByCartId(int cartId);
	
	
	@Query(value="select p.no_of_quantities from product_cart p where p.cart_id=:cartId",nativeQuery = true)
	int findNoOfQuantiesBycartId(int cartId);


	




}

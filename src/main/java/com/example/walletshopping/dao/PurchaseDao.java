package com.example.walletshopping.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.walletshopping.model.Purchase;

public interface PurchaseDao extends CrudRepository<Purchase, Integer>{
	
	
	@Query(value="select p.product_price from product p where p.product_id=:productId",nativeQuery = true)
	Double findpriceByProductId(int productId);

}

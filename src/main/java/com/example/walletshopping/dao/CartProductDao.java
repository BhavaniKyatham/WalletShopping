package com.example.walletshopping.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.walletshopping.model.CartProduct;

@Repository
public interface CartProductDao extends CrudRepository<CartProduct, Integer>{

	
		

}

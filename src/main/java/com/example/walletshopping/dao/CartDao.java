package com.example.walletshopping.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.walletshopping.model.Cart;

@Repository
public interface CartDao extends CrudRepository<Cart, Integer> {

}

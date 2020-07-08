package com.example.walletshopping.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.walletshopping.model.Product;

public interface ProductDao extends CrudRepository<Product, Integer>{

}

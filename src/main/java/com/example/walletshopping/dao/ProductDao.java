package com.example.walletshopping.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.walletshopping.model.Product;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer>{

	@Query(value = "select * from Product p where p.product_name like %:productName%", nativeQuery = true)
	public Optional<List<Product>> searchByProductName(@Param("productName") String productName);
}

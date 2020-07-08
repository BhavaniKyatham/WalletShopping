package com.example.walletshopping.service;

import com.example.walletshopping.dto.ProductListResponseDto;
import com.example.walletshopping.exceptions.ProductNotFoundException;

public interface ProductService {

	public ProductListResponseDto searchByProductName(String productName) throws ProductNotFoundException;
}

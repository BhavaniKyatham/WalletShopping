package com.example.walletshopping.service;

import java.util.List;

import com.example.walletshopping.dtos.CartProductDto;
import com.example.walletshopping.dtos.CartResponseDto;

public interface CartService {

	CartResponseDto AddProductsToCart(List<CartProductDto> cartProductDtolist, int userId);

	
}

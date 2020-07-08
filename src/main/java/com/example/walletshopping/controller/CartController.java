package com.example.walletshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.walletshopping.dtos.CartProductDto;
import com.example.walletshopping.dtos.CartResponseDto;
import com.example.walletshopping.service.CartService;


@RestController
public class CartController {

	@Autowired
	CartService cartService;
		 
	@PostMapping("/users/{userId}/cart")
	public ResponseEntity<CartResponseDto> AddProductToCart( @RequestBody List<CartProductDto> cartProductDtolist,@PathVariable("userId") int  userId)
	{
		CartResponseDto cartResponse = cartService.AddProductsToCart(cartProductDtolist,userId);
			return new ResponseEntity<CartResponseDto>(cartResponse,HttpStatus.OK);
	
		
			
	}	
}

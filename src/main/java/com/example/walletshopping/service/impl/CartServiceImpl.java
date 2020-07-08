package com.example.walletshopping.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.walletshopping.dao.CartDao;
import com.example.walletshopping.dao.CartProductDao;
import com.example.walletshopping.dao.UserDao;
import com.example.walletshopping.dtos.CartProductDto;
import com.example.walletshopping.dtos.CartResponseDto;
import com.example.walletshopping.model.Cart;
import com.example.walletshopping.model.CartProduct;
import com.example.walletshopping.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	CartProductDao cartProductDao;
	
	
	@Override
	public CartResponseDto AddProductsToCart(List<CartProductDto> cartProductDtolist, int userId) {
		Cart cart=new Cart();
		cart.setUserId(userId);
	    cartDao.save(cart);
		
	    List<CartProduct> cartProductList =  cartProductDtolist.stream().map(cartProductDto-> getCartProduct(cartProductDto,cart.getCartId())).collect(Collectors.toList());
        cartProductDao.saveAll(cartProductList);
	
        CartResponseDto cartresponsedto=new CartResponseDto();
        cartresponsedto.setCartId(cart.getCartId());
        cartresponsedto.setStatusCode(200);
        cartresponsedto.setMessage("succesfully added products to the cart");
	
		return cartresponsedto;
	}

	private CartProduct getCartProduct(CartProductDto cartProductDto, int cartId) {

		 CartProduct cartproduct= new CartProduct();
		 cartproduct.setNoOfQuantities(cartProductDto.getNoOfQuantities());
		 cartproduct.setProductId(cartProductDto.getProductId());
		 cartproduct.setCartId(cartId);
		return cartproduct;
	}
	
	
}
	



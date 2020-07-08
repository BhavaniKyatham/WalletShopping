package com.example.walletshopping.service.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.walletshopping.dao.ProductDao;
import com.example.walletshopping.dto.ProductListResponseDto;
import com.example.walletshopping.dto.ProductResponseDto;
import com.example.walletshopping.exceptions.ProductNotFoundException;
import com.example.walletshopping.model.Product;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {
	Product product;
	ProductListResponseDto ProductListResponseDto;

    @Mock
    ProductDao productDao;

    @InjectMocks
   
    ProductServiceImpl productServiceImpl;
    
    ProductResponseDto productResponseDto;
 
    @BeforeEach
    public void setUp() {
    	ProductListResponseDto = new ProductListResponseDto();
    }
    	 @Test
    	  public void searchByProductName() throws ProductNotFoundException {
    	     List<Product> productsList = new ArrayList<>();
    	     ProductResponseDto productResponseDto = new ProductResponseDto();
    	     productResponseDto.setProductId(1);
    	     productResponseDto.setProductName("Mimobile");
    	     productResponseDto.setProductPrice(5000);
    	     productResponseDto.setProductQuantity(1);
    	     
    	     when(productDao.searchByProductName("Mimobile")).thenReturn(Optional.ofNullable(productsList));
    	     
    	     productServiceImpl.searchByProductName("Mimobile");
    	    
    	     verify(productDao).searchByProductName("Mimobile");
    	        
    	        
    }

}

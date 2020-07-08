package com.example.walletshopping.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.walletshopping.dto.ProductListResponseDto;
import com.example.walletshopping.dto.ProductResponseDto;
import com.example.walletshopping.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

	 @Mock
	    ProductService productService;
	    MockMvc mockMvc;
	    ObjectMapper objectMapper;
	    
	    @InjectMocks
	    ProductController productController;
	    
	    ProductResponseDto productResponseDto;
	@BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();     
    }
	@Test
    public void getProductsByProductNameTests()throws Exception{
		ProductResponseDto productResponseDto=new ProductResponseDto();
		productResponseDto.setProductId(1);
		productResponseDto.setProductName("Mimobile");
		productResponseDto.setProductPrice(5000);
		productResponseDto.setProductQuantity(1);
        List<ProductResponseDto> productsResponseDtolist=new ArrayList<>();
        
        
        ProductListResponseDto responsedto=new ProductListResponseDto();
        productsResponseDtolist.add(productResponseDto);
        responsedto.setMessage("list of products");
        responsedto.setStatusCode(200);
        responsedto.setProductResponseDto(productsResponseDtolist);
        
        
        when(productService.searchByProductName("Mimobile")).thenReturn(responsedto);
         mockMvc.perform(get("/products").contentType(MediaType.APPLICATION_JSON_VALUE)
                 .param("productName","Mimobile").accept(MediaType.APPLICATION_JSON_VALUE))
                 .andExpect(MockMvcResultMatchers.status().isOk())
                 .andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class)));

 

         verify(productService).searchByProductName("Mimobile");
        
    }
}

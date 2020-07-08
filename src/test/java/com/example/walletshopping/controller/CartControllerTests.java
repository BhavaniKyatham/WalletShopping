package com.example.walletshopping.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.walletshopping.dtos.CartResponseDto;
import com.example.walletshopping.service.CartService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class CartControllerTests {

	
	@Mock
    CartService cartService;

	MockMvc mockMvc;
    ObjectMapper objectMapper;

    @InjectMocks
    CartController cartController;

    CartResponseDto cartResponseDto;
    
    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(cartController).build();
    }
    
    
}

package com.example.walletshopping.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.walletshopping.dto.PurchaseRequestDto;
import com.example.walletshopping.service.PurchaseService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class PurchaseControllerTest {
    
	ObjectMapper objectMapper;
	
	@Mock
	PurchaseService purchaseService;
	
	@InjectMocks
	PurchaseController purchaseController;
	
	MockMvc mockMvc;
	
	PurchaseRequestDto purchaseRequestDto;
	
	@BeforeEach
	public void setUp() {
		objectMapper = new ObjectMapper();
		mockMvc = MockMvcBuilders.standaloneSetup(purchaseController).build();
		purchaseRequestDto.setCartId(1);
		purchaseRequestDto.setWalletId(1);
	}
	
	@Test
	public void registerTest() throws Exception{
		mockMvc.perform(post("users/{userId}/purchase").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(purchaseRequestDto)))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$", Matchers.is("success")));
	}

		
		 
}

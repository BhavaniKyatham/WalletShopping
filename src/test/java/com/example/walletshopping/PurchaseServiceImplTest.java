package com.example.walletshopping;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import com.example.walletshopping.dao.PurchaseDao;
import com.example.walletshopping.dto.PurchaseRequestDto;
import com.example.walletshopping.exception.InavalidCartIdException;
import com.example.walletshopping.exception.InsufficientAmountException;
import com.example.walletshopping.model.Purchase;
import com.example.walletshopping.service.impl.PurchaseServiceImpl;



@ExtendWith(MockitoExtension.class)
public class PurchaseServiceImplTest {
	
	Purchase purchase;
	
	@Mock
	PurchaseDao purchasedao;
	
	@InjectMocks
	PurchaseServiceImpl purchaseServiceImpl;
	
	PurchaseRequestDto perchaseRequestDto;
	
	@BeforeEach
	public void setUp() {
		perchaseRequestDto.setCartId(1);
		perchaseRequestDto.setWalletId(1);
	}
	@Test
	public void savePurchaseDetailsTest() throws InsufficientAmountException, InavalidCartIdException  {
		
		//given
		when(purchasedao.save(any(Purchase.class))).thenReturn(any(Purchase.class));
		
		//when
		purchaseServiceImpl.savePurchaseProductDetails(1, perchaseRequestDto);
		
		//then
		verify(purchasedao).save(any(Purchase.class));
	}
	
}

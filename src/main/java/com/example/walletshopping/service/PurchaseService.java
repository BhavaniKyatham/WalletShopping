package com.example.walletshopping.service;

import com.example.walletshopping.dto.PurchaseRequestDto;
import com.example.walletshopping.exception.InavalidCartIdException;
import com.example.walletshopping.exception.InsufficientAmountException;

public interface PurchaseService {

	boolean savePurchaseProductDetails(int userId, PurchaseRequestDto purchaseRequestDto) throws InsufficientAmountException, InavalidCartIdException;

}

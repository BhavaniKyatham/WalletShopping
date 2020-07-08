package com.example.walletshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.walletshopping.dto.PurchaseRequestDto;
import com.example.walletshopping.dto.StatusRequestDto;
import com.example.walletshopping.exception.InavalidCartIdException;
import com.example.walletshopping.exception.InsufficientAmountException;
import com.example.walletshopping.service.PurchaseService;

@RestController
public class PurchaseController {
	
	@Autowired
	PurchaseService purchaseService;
	
	@PostMapping("users/{userId}/purchase")
	public StatusRequestDto savePurchaseProductDetails(@PathVariable("userId")int userId, @RequestBody PurchaseRequestDto purchaseRequestDto) throws InsufficientAmountException, InavalidCartIdException {
		StatusRequestDto errorresponse = new StatusRequestDto();
		purchaseService.savePurchaseProductDetails(userId,purchaseRequestDto);
		errorresponse.setStatusCode(202);
		errorresponse.setMessage("your purchase is successfull");
		return errorresponse;
	}
	@ExceptionHandler(InsufficientAmountException.class)
	public ResponseEntity<StatusRequestDto> exceptionHandler(InsufficientAmountException exception) {
		StatusRequestDto errorresponse = new StatusRequestDto();
		errorresponse.setStatusCode(502);
		errorresponse.setMessage(exception.getMessage());
		return new ResponseEntity<>(errorresponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InavalidCartIdException.class)
	public ResponseEntity<StatusRequestDto> exceptionHandler(InavalidCartIdException exception) {
		StatusRequestDto errorresponse = new StatusRequestDto();
		errorresponse.setStatusCode(503);
		errorresponse.setMessage(exception.getMessage());
		return new ResponseEntity<>(errorresponse, HttpStatus.NOT_FOUND);
	}

}

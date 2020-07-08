package com.example.walletshopping.dto;

import java.util.List;

public class ProductListResponseDto {
private String message;
private int statusCode;

List<ProductResponseDto> productResponseDto;

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public int getStatusCode() {
	return statusCode;
}

public void setStatusCode(int statusCode) {
	this.statusCode = statusCode;
}

public List<ProductResponseDto> getProductResponseDto() {
	return productResponseDto;
}

public void setProductResponseDto(List<ProductResponseDto> productResponseDto) {
	this.productResponseDto = productResponseDto;
}


}

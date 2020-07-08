package com.example.walletshopping.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.walletshopping.dto.ProductListResponseDto;
import com.example.walletshopping.exceptions.ProductNotFoundException;
import com.example.walletshopping.service.ProductService;

/**
 * @author Bhavani Kyatham
 *
 */
@RestController
public class ProductController {
	private static Log logger = LogFactory.getLog(ProductController.class);
	@Autowired
	ProductService productService;

	/**
	 * This method is for search products by product name
	 * @param productName
	 * @return products list
	 * @throws ProductNotFoundException
	 */

	@GetMapping("/products")
	public ResponseEntity<ProductListResponseDto> searchByProductName(@RequestParam("productName") String productName)
			throws ProductNotFoundException {
		logger.info("Inside searchByProductName product controller ");

		return new ResponseEntity<>(productService.searchByProductName(productName), HttpStatus.OK);
	}
}

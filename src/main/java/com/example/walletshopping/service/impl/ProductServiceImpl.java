package com.example.walletshopping.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.walletshopping.dao.ProductDao;
import com.example.walletshopping.dto.ProductListResponseDto;
import com.example.walletshopping.dto.ProductResponseDto;
import com.example.walletshopping.exceptions.ProductNotFoundException;
import com.example.walletshopping.model.Product;
import com.example.walletshopping.service.ProductService;

/**
 * @author Bhavani Kyatham
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	private static Log logger = LogFactory.getLog(ProductServiceImpl.class);
	@Autowired
	ProductDao productDao;

	@Override
	public ProductListResponseDto searchByProductName(String productName) throws ProductNotFoundException {
		ProductListResponseDto productListResponseDto = new ProductListResponseDto();
		logger.info("executing the searchByProductName and return the list of products");
		Optional<List<Product>> productsOptional = productDao.searchByProductName(productName);
		if (!productsOptional.isPresent()) {
			throw new ProductNotFoundException("There is no products with the given productName:" + productName);
		}

		List<ProductResponseDto> productResponseDto = productsOptional.get().stream()
				.map(product -> getProductResponseDto(product)).collect(Collectors.toList());
		productListResponseDto.setProductResponseDto(productResponseDto);

		productListResponseDto.setMessage("List of Products");
		productListResponseDto.setStatusCode(200);

		return productListResponseDto;

	}

	private ProductResponseDto getProductResponseDto(Product product) {
		ProductResponseDto productresponseDto = new ProductResponseDto();
		BeanUtils.copyProperties(product, productresponseDto);
		return productresponseDto;
	}

}

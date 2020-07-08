package com.example.walletshopping.service.impl;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.walletshopping.dao.CartProductDao;
import com.example.walletshopping.dao.ProductDao;
import com.example.walletshopping.dao.PurchaseDao;
import com.example.walletshopping.dao.WalletDao;
import com.example.walletshopping.dto.PurchaseRequestDto;
import com.example.walletshopping.exception.InavalidCartIdException;
import com.example.walletshopping.exception.InsufficientAmountException;
import com.example.walletshopping.model.Product;
import com.example.walletshopping.model.Purchase;
import com.example.walletshopping.model.Wallet;
import com.example.walletshopping.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	PurchaseDao purchaseDao;

	@Autowired
	CartProductDao cartProductDao;

	@Autowired
	WalletDao walletDao;

	@Autowired
	ProductDao productDao;

	/**
	 *return boolean
	 */
	@Override
	public boolean savePurchaseProductDetails(int userId, PurchaseRequestDto purchaseRequestDto)
			throws InsufficientAmountException, InavalidCartIdException {

		Purchase purchase = new Purchase();
		Wallet wallet = walletDao.findById(purchaseRequestDto.getWalletId()).get();
		if (cartProductDao.findById(purchaseRequestDto.getCartId()).isPresent()) {
			BeanUtils.copyProperties(purchaseRequestDto, purchase);
		} else {
			throw new InavalidCartIdException("your cart id is not valid");
		}
		purchase.setUserId(userId);
		purchase.setPurchaseDate(LocalDate.now());
		int productId = cartProductDao.findProductIdByCartId(purchaseRequestDto.getCartId());
		int noOfQuanties = cartProductDao.findNoOfQuantiesBycartId(purchaseRequestDto.getCartId());
		double price = purchaseDao.findpriceByProductId(productId);

		if (wallet.getAmount() > price) {
			purchase.setTotalPrice(price * noOfQuanties);
		} else {
			throw new InsufficientAmountException("your wallet amount is not sufficient");

		}
		Product product = productDao.findById(productId).get();
		product.setProductQuantity(product.getProductQuantity() - noOfQuanties);
		productDao.save(product);
		wallet.setAmount(wallet.getAmount() - price);
		walletDao.save(wallet);
		return false;
	}

}

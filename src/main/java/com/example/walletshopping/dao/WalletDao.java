package com.example.walletshopping.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.walletshopping.model.Wallet;

public interface WalletDao extends CrudRepository<Wallet, Integer>{

}

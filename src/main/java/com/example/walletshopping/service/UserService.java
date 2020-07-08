package com.example.walletshopping.service;

import javax.validation.Valid;

import com.example.walletshopping.dto.LoginDto;
import com.example.walletshopping.dto.LoginResponseDto;

public interface UserService {

	public LoginResponseDto loginUser(@Valid LoginDto loginDto);

}

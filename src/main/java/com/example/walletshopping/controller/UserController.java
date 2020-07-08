package com.example.walletshopping.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.walletshopping.dto.LoginDto;
import com.example.walletshopping.dto.LoginResponseDto;
import com.example.walletshopping.service.UserService;

/**
 * @author Bhavani Kyatham
 *
 */
@RestController
public class UserController {
	private static Log logger = LogFactory.getLog(UserController.class);
	@Autowired
	UserService userService;

	/**
	 * This method is used for successful login
	 * 
	 * @param loginDto
	 * @return logged in successfully
	 */
	@PostMapping("/users/login")
	public ResponseEntity<LoginResponseDto> userLogin(@Valid @RequestBody LoginDto loginDto) {

		logger.info("Inside userlogin method ");

		return new ResponseEntity<>(userService.loginUser(loginDto), HttpStatus.OK);

	}
}
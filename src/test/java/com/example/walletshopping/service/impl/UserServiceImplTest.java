package com.example.walletshopping.service.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.walletshopping.dao.UserDao;
import com.example.walletshopping.dto.LoginDto;
import com.example.walletshopping.dto.LoginResponseDto;
import com.example.walletshopping.model.User;
@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    User user;
    LoginResponseDto loginResponseDto;

    @Mock
    UserDao userDao;

    @InjectMocks
    UserServiceImpl userServiceImpl;

    LoginDto loginDto;
    @BeforeEach
    public void setUp() {
    	loginResponseDto = new LoginResponseDto();
        loginResponseDto.setMessage("User logged in");
        loginResponseDto.setStatusCode(200);
    }

    @Test
    public void loginEmployeeTest() {
        
        User user = new User();
        user.setUserId(1);
        user.setUserName("bhavani");
        
        user.setPassword("1234");
        
        LoginDto loginDto = new LoginDto();
        loginDto.setUserName("bhavani");
        loginDto.setPassword("1234");
        
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setMessage("User logged in");
        loginResponseDto.setStatusCode(200);
        when(userDao.findByUserNameAndPassword("bhavani","1234")).thenReturn(Optional.of(user));
        userServiceImpl.loginUser(loginDto);
        verify(userDao).findByUserNameAndPassword("bhavani", "1234");
    }

}
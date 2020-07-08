package com.example.walletshopping.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.walletshopping.model.User;
/**
 * @author Bhavani Kyatham
 *
 */
@Repository
public interface UserDao extends CrudRepository<User, Integer> {
	/**This method validate user login
     * @param userName
     * @param password
     * @return User
     */
	public Optional<User> findByUserNameAndPassword( String userName,String password);
	
	/**
	 * This method is used to get User by userId
	 * @param userId
	 * @return User
	 */
	public Optional<User> findByUserId(int userId);
}

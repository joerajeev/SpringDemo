package com.joerajeev.carsales.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.joerajeev.carsales.dao.AuthorityDao;
import com.joerajeev.carsales.dao.UserDao;

/**
 * Service layer class providing User related services 
 * 
 * @author Rajeev
 *
 */
@Service
public class UserService {

	Logger logger = Logger.getLogger(UserService.class.toString());
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private AuthorityDao authorityDao;
	
	/**
	 * 
	 * @param user
	 * @return id of the user created
	 */
	public int createUser(User user) throws ServiceException{
		//Need to do this in a transaction
		try {
			authorityDao.create(user.getEmail(), "ROLE_USER");
			return userDao.create(user);
		} catch (Exception e) {
			logger.warning("Error creating user "+e);
			throw new ServiceException("Error creating user", e);
		}
	}
	
	public User readByUsername(String username) {
		
		return userDao.read(username);
	}
	
	/**
	 * @return the userDao
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * @return the authorityDao
	 */
	public AuthorityDao getAuthorityDao() {
		return authorityDao;
	}

	/**
	 * @param authorityDao the authorityDao to set
	 */
	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}
}

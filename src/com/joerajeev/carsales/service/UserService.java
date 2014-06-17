package com.joerajeev.carsales.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.joerajeev.carsales.dao.AuthorityDao;
import com.joerajeev.carsales.dao.SellerDao;

@Service
public class UserService {

	Logger logger = Logger.getLogger(UserService.class.toString());
	
	@Autowired
	private SellerDao sellerDao;

	@Autowired
	private AuthorityDao authorityDao;
	
	/**
	 * 
	 * @param user
	 * @return id of the user created
	 */
	public int createUser(Seller user) throws ServiceException{
		//Need to do this in a transaction
		try {
			authorityDao.create(user.getEmail(), "ROLE_USER");
			return sellerDao.create(user);
		} catch (Exception e) {
			logger.warning("Error creating user "+e);
			throw new ServiceException("Error creating user", e);
		}
	}
	
	public Seller readByUsername(String username) {
		
		return sellerDao.read(username);
	}
	
	/**
	 * @return the sellerDao
	 */
	public SellerDao getSellerDao() {
		return sellerDao;
	}

	/**
	 * @param sellerDao the sellerDao to set
	 */
	public void setSellerDao(SellerDao sellerDao) {
		this.sellerDao = sellerDao;
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

package com.joerajeev.carsales.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joerajeev.carsales.dao.AuthorityDao;
import com.joerajeev.carsales.dao.CarsDao;
import com.joerajeev.carsales.dao.SellerDao;

@Service("adService")
public class AdService {

	Logger logger = Logger.getLogger(AdService.class.toString());
	
	private CarsDao carsDao;
	private SellerDao sellerDao;
	private AuthorityDao authorityDao;
	
	@Autowired
	public void setCarsDao(CarsDao carsDao) {
		this.carsDao = carsDao;
	}
	
	@Autowired
	public void setSellerDao(SellerDao sellerDao) {
		this.sellerDao = sellerDao;
	}
	
	@Autowired
	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}
	
	public List<Vehicle> getAllVehicles(){
		return carsDao.getAllVehicles();
	}
	
	public void createVehicle(Vehicle vehicle) throws ServiceException{
		try {
			carsDao.create(vehicle);
		} catch (Exception e) {
			logger.warning("Error creating vehicle.");
			throw new ServiceException("Error creating vehicle", e);
		}
	}
	
	/*public void createAd(Vehicle vehicle, Seller seller) throws ServiceException{
		//TODO: need to save both of these in a transaction
		try {
			//authorityDao.create(seller.getEmail(), "WEB_USER");
			int sellerId = sellerDao.create(seller);
			vehicle.setOwner(sellerId);
			carsDao.create(vehicle);
			
		} catch (Exception e) {
			logger.warning("Error creating ad :"+e.getMessage());
			throw new ServiceException("Error creating ad", e);
		}
	}*/
}

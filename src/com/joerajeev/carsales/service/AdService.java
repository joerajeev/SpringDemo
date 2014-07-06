package com.joerajeev.carsales.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joerajeev.carsales.dao.AuthorityDao;
import com.joerajeev.carsales.dao.CarsDao;
import com.joerajeev.carsales.dao.UserDao;

/**
 * Service level class providing car advert related services
 * 
 * @author Rajeev
 *
 */
@Service("adService")
public class AdService {

	Logger logger = Logger.getLogger(AdService.class.toString());
	
	private CarsDao carsDao;
	
	@Autowired
	public void setCarsDao(CarsDao carsDao) {
		this.carsDao = carsDao;
	}
	
	public List<Vehicle> getAllVehicles(){
		return carsDao.getAllVehicles();
	}
	
	public boolean createVehicle(Vehicle vehicle) throws ServiceException{
		try {
			return carsDao.create(vehicle);
		} catch (Exception e) {
			logger.warning("Error creating vehicle.");
			throw new ServiceException("Error creating vehicle", e);
		}
	}
	}

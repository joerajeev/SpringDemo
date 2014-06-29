package com.joerajeev.carsales.controller;

import java.security.Principal;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joerajeev.carsales.service.AdService;
import com.joerajeev.carsales.service.Seller;
import com.joerajeev.carsales.service.ServiceException;
import com.joerajeev.carsales.service.UserService;
import com.joerajeev.carsales.service.Vehicle;

@Controller
public class AdController {

	Logger logger = Logger.getLogger(AdController.class.toString());
	
	@Autowired
	private AdService adService;
	
	@Autowired
	private UserService userService;
	
	
	public void setAdService(AdService adService) {
		this.adService = adService;
	}
		
	@RequestMapping("/")
	public String showHome(Model model) {
		return "home";
	}
	
	@RequestMapping("/buy")
	public String showAvailableCars(Model model) {
		model.addAttribute("vehicles", adService.getAllVehicles());
		return "list-cars";
	}
	
	@RequestMapping("/sell")
	public String showAddCar(Model model) {
		
		model.addAttribute("vehicle" , new Vehicle());
		return "add-car";
	}
	
	@RequestMapping("/docreatecar")
	public String createCar(HttpServletRequest request,@Valid Vehicle vehicle, BindingResult result, Model model, Principal principal) {
		if(!result.hasErrors()) {
			logger.info("Vehicle: "+vehicle);
			try {
				String username= principal.getName();
				logger.info("user :"+username);
				Seller user = userService.readByUsername(username);
				if(user != null) {
					vehicle.setOwner(user.getId());
					adService.createVehicle(vehicle);
					request.setAttribute("message", "Ad created successfully");
					return "home";
				}else {
					request.setAttribute("error", "Not a valid user");
					return "add-car";
				}
			} catch (ServiceException e) {
				request.setAttribute("message", "Error adding car");
				return "add-car";
			}
		}else {
			for (ObjectError error : result.getAllErrors()) {
				logger.warning(error.toString());
			}
			request.setAttribute("message", "Error adding car");
			return "add-car";
		}
		
	}
	
	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}

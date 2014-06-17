package com.joerajeev.carsales.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.joerajeev.carsales.service.Seller;
import com.joerajeev.carsales.service.ServiceException;
import com.joerajeev.carsales.service.UserService;

@Controller
public class SecurityController {

	Logger logger = Logger.getLogger(SecurityController.class.toString());
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String doLogin() {
		return "login";
	}
	
	@RequestMapping("/sign-up")
	public String showSignUpPage(Model model) {
		model.addAttribute(new Seller());
		return "sign-up";
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
	
	@RequestMapping(value="/docreateuser", method=RequestMethod.POST)
	public String createUser(Model model, @Valid Seller user, BindingResult result) {
		if(result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError objectError : errors) {
				logger.warning(objectError.toString());
			}
			return "sign-up";
		}else {
			try {
				userService.createUser(user);
				return "login";
			} catch (ServiceException e) {
				return "sign-up";	//TODO need to do error handling - at least display an error msg
			}
		}
	}
}

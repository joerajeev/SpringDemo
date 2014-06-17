package com.joerajeev.carsales.service;

public class ServiceException extends Exception {
	 
    private static final long serialVersionUID = 4664456874499611218L;
     
    public ServiceException(String message, Throwable cause){
        super(message, cause);
    }
 
}
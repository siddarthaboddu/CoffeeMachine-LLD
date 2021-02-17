package com.example.coffemachine.exception;

/**
 * exception when Beverage is not found
 * @author siddu
 *
 */
public class BeverageNotFoundException extends RuntimeException{

	public BeverageNotFoundException(String msg) {
		super(msg);
	}
	
}

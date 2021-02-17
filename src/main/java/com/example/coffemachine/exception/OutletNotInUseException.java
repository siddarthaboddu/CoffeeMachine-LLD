package com.example.coffemachine.exception;

/**
 * Exception when specified outlet is not in use.
 * @author siddu
 *
 */
public class OutletNotInUseException extends RuntimeException {

	public OutletNotInUseException(String msg) {
		super(msg);
	}
	
}

package com.example.coffemachine.exception;

/**
 * Exception when specified outlet is already in use
 * @author siddu
 *
 */
public class OutletInUseException extends RuntimeException {

	public OutletInUseException(String msg) {
		super(msg);
	}
}

package com.example.coffemachine.exception;

/**
 * exception when outlet specified is invalid
 * @author siddu
 *
 */
public class InvalidOutletException extends RuntimeException {

	public InvalidOutletException(String msg) {
		super(msg);
	}
}

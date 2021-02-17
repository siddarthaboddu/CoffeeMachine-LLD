package com.example.coffemachine.exception;

/**
 * Exception when InventoryItem quantity is not sufficient
 * @author siddu
 *
 */
public class InventoryItemNotSufficient extends RuntimeException {

	public InventoryItemNotSufficient(String msg) {
		super(msg);
	}
}

package com.example.coffemachine.exception;

/** 
 * Exception when InventoryItem is not found
 * @author siddu
 *
 */
public class InventoryItemNotFound extends RuntimeException{

	public InventoryItemNotFound(String msg) {
		super(msg);
	}
}

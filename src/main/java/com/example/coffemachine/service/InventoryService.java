package com.example.coffemachine.service;

import com.example.coffemachine.exception.InventoryItemNotFound;
import com.example.coffemachine.exception.InventoryItemNotSufficient;
import com.example.coffemachine.model.InventoryItem;
import com.example.coffemachine.repository.InventoryManager;

/** manages {@link InventoryItem}
 * @author siddu
 *
 */
public class InventoryService {

	private InventoryManager inventoryManager;

	public InventoryService(InventoryManager inventoryManager) {
		super();
		this.inventoryManager = inventoryManager;
	}

	/**
	 * acquires {@link InventoryItem} with specified {@code name} and {@code quantity} form Inventory
	 * @param name is the {@link String} which is the name of the {@link InventoryItem}
	 * @param quantity is the {@link Long} which is required quantity of {@link InventoryItem}
	 * @throws {@link InventoryItemNotFound} when {@link InventoryItem} with {@code name} is not present
	 * @throws {@link InventoryItemNotSufficient} when {@link InventoryItem} with {@code name} and required {@code quantity} is more than available {@code quantity}
	 */
	public synchronized void acquireInventoryItem(String name, long quantity) {
		InventoryItem inventoryItem = inventoryManager.getInventory(name);
		if(inventoryItem == null) {
			throw new InventoryItemNotFound(name+" is not available");
		}
		
		if(inventoryItem.getQuantity() < quantity) {
			throw new InventoryItemNotSufficient(name+" is not sufficient");
		}
		
		inventoryItem.setQuantity(inventoryItem.getQuantity() - quantity);
		inventoryManager.replaceInventoryItem(inventoryItem);
	}

	/**
	 * adds {@link InventoryItem} with {@code name} and {@code quantity}
	 * @param itemName is the {@link String} which is the name of the {@link InventoryItem}
	 * @param quantity is the {@link Long} which is the quantity of the {@link InventoryItem}
	 * @return {@link InventoryItem} with total available {@code quantity}
	 */
	public synchronized InventoryItem addInventoryItem(String itemName, long quantity) {
		InventoryItem inventoryItem = new InventoryItem(itemName, quantity);
		return inventoryManager.addIngredient(inventoryItem);
	}
	
}

package com.example.coffemachine.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.example.coffemachine.model.InventoryItem;

/**
 * InventoryManager implementation using InMemory storage
 * 
 * @author siddu
 *
 */
public class InventoryManagerImpl implements InventoryManager {

	private Map<String, InventoryItem> inventoryMap;

	public InventoryManagerImpl() {
		inventoryMap = new ConcurrentHashMap<>();
	}

	@Override
	public synchronized InventoryItem getInventory(String inventoryName) {
		return inventoryMap.get(inventoryName);
	}

	@Override
	public synchronized void replaceInventoryItem(InventoryItem inventoryItem) {
		inventoryMap.put(inventoryItem.getName(), inventoryItem);
	}

	@Override
	public synchronized InventoryItem addIngredient(InventoryItem inventory) {
		if (inventoryMap.containsKey(inventory.getName())) {
			inventory.setQuantity(inventory.getQuantity() + inventoryMap.get(inventory.getName()).getQuantity());
		}

		inventoryMap.put(inventory.getName(), inventory);

		return inventory;
	}

}

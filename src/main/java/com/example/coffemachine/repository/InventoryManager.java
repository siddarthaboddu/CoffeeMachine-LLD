package com.example.coffemachine.repository;

import com.example.coffemachine.model.InventoryItem;

/**
 * holds InventoryItems instances
 * 
 * @author siddu
 *
 */
public interface InventoryManager {

	public InventoryItem getInventory(String inventoryName);

	public InventoryItem addIngredient(InventoryItem inventory);

	public void replaceInventoryItem(InventoryItem inventoryItem);

}

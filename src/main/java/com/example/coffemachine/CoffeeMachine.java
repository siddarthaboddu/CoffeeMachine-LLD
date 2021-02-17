package com.example.coffemachine;

import java.util.List;

import com.example.coffemachine.configuration.Configuration;
import com.example.coffemachine.model.Beverage;
import com.example.coffemachine.model.Ingredient;
import com.example.coffemachine.model.InventoryItem;
import com.example.coffemachine.service.BeverageService;
import com.example.coffemachine.service.InventoryService;
import com.example.coffemachine.service.OutletService;

/**
 * it is a CoffeeMachine
 * @author siddu
 */
public class CoffeeMachine {

	private Configuration configuration;
	private OutletService outletService;
	private InventoryService inventoryService;
	private BeverageService beverageService;

	public CoffeeMachine(Configuration configuration, InventoryService inventoryService, BeverageService beverageService) {
		super();
		this.configuration = configuration;
		this.inventoryService = inventoryService;
		this.beverageService = beverageService;
		this.outletService = new OutletService(this.configuration.getOutletCount());
	}

	/**
	 * creates a required beverage from specified outlet.
	 * @param outlet it is {@link Integer} which is outlet number
	 * @param beverageName it is {@link String} which is the beverage name
	 * @return created {@link Beverage} instance
	 * */
	public Beverage getBeverage(Integer outlet, String beverageName) {
		Beverage createdBeverage = null;
		try {
			outletService.acquireOutlet(outlet);
			createdBeverage = beverageService.createBeverage(beverageName);
			outletService.releaseOutlet(outlet);
			System.out.println(createdBeverage.getName()+" is prepared");
		} catch (RuntimeException e) {
			System.out.println(beverageName + " cannot be prepared because " + e.getMessage());
		}
		return createdBeverage;
	}

	/**
	 * adds specified Inventory item with {@code itemName} and {@code quantity} in the CoffeeMachine 	 
	 * @param itemName is the {@link String} which is Inventory Item name
	 * @param quantity is the {@link Long} which is quantity of the item
	 * @return a {@link InventoryItem} instance with total quantity in the coffee machine
	 */
	public InventoryItem addInventoryItem(String itemName, Long quantity) {

		return inventoryService.addInventoryItem(itemName, quantity);
	}

	/**
	 * adds Beverage Entry in the CoffeeMachine
	 * @param beverageName is the {@link String} which is the name of the beverage
	 * @param ingredients is the {@link List<Ingredient>} which is list of ingredients to make this beverage
	 */
	public void addBeverageEntry(String beverageName, List<Ingredient> ingredients) {
		beverageService.addBeverageEntry(beverageName, ingredients);
	}
}

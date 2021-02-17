package com.example.coffemachine.service;

import java.util.List;

import com.example.coffemachine.exception.BeverageNotFoundException;
import com.example.coffemachine.model.Beverage;
import com.example.coffemachine.model.Ingredient;
import com.example.coffemachine.repository.BeverageCatalog;

/**
 * manages {@link Beverage} creation
 * @author siddu
 *
 */
public class BeverageService {

	private BeverageCatalog beverageCatalog;
	private InventoryService inventoryService;

	public BeverageService(BeverageCatalog beverageCatalog, InventoryService inventoryService) {
		super();
		this.beverageCatalog = beverageCatalog;
		this.inventoryService = inventoryService;
	}

	/**
	 * creates an Instance of {@link Beverage} when necessary {@link Ingredients} are acquired
	 * @param beverageName is name of the {@link Beverage}
	 * @return {@link Beverage} instance if {@link Ingredients} are acquired
	 * @throws {@link BeverageNotFoundException} if no {@link Beverage} with name as {@code beverageName}
	 */
	public Beverage createBeverage(String beverageName) {
		Beverage beverage = beverageCatalog.getBeverage(beverageName);

		if (beverage == null) {
			throw new BeverageNotFoundException("invalid beverage : " + beverageName);
		} else {
			for (Ingredient ingredient : beverage.getIngredients()) {
				inventoryService.acquireInventoryItem(ingredient.getName(),
						ingredient.getQuantity()); // acquiring ingredients required for given beverage
			}
			return beverage;
		}
	}

	/**
	 * adds a {@link Beverage} to {@link BeverageCatalog} with provided {@code beverageName} and {@code ingredients}
	 * @param beverageName is name of the {@link Beverage}
	 * @param ingredients is {@link List} of {@link Ingredient}
	 */
	public void addBeverageEntry(String beverageName, List<Ingredient> ingredients) {
		Beverage beverage = new Beverage(beverageName, ingredients);
		beverageCatalog.addBeverage(beverage); // adding a new beverage entry to beverage catalog in CoffeeMachine
	}
}

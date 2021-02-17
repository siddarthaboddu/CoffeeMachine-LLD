package com.example.coffemachine.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.example.coffemachine.CoffeeMachine;
import com.example.coffemachine.configuration.Configuration;
import com.example.coffemachine.helper.JsonHelper;
import com.example.coffemachine.model.Ingredient;
import com.example.coffemachine.repository.BeverageCatalog;
import com.example.coffemachine.repository.BeverageCatalogImpl;
import com.example.coffemachine.repository.InventoryManager;
import com.example.coffemachine.repository.InventoryManagerImpl;
import com.example.coffemachine.service.BeverageService;
import com.example.coffemachine.service.InventoryService;

/**
 * Factory to create CoffeeMachine
 * @author siddu
 *
 */
public class CoffeeMachineFactory {

	@SuppressWarnings("unchecked")
	public static CoffeeMachine getCoffeMachine(String configData) {
		JsonHelper jsonHelper = new JsonHelper();

		InventoryManager inventoryManager = new InventoryManagerImpl();
		BeverageCatalog beverageCatalog = new BeverageCatalogImpl();

		InventoryService inventoryService = new InventoryService(inventoryManager);
		BeverageService beverageService = new BeverageService(beverageCatalog, inventoryService);

		JSONObject config = (JSONObject) jsonHelper.getJsonData(configData);

		long outletCount = (Long) jsonHelper.getJSONObject(config, "machine", "outlets").get("count_n");
		Configuration configuration = new Configuration();
		configuration.setOutletCount( (int) outletCount);
		
		CoffeeMachine coffeeMachine = new CoffeeMachine(configuration, inventoryService, beverageService);

		JSONObject totalItemsQuantityJsonObject = (JSONObject) jsonHelper.getJSONObject(config, "machine",
				"total_items_quantity");

		totalItemsQuantityJsonObject.forEach((key, value) -> {
			coffeeMachine.addInventoryItem((String) key, (Long) value);
		});

		JSONObject beveragesJsonObject = (JSONObject) jsonHelper.getJSONObject(config, "machine", "beverages");

		for (Object entry : beveragesJsonObject.entrySet()) {
			Map.Entry<Object, Object> beverage = (Map.Entry<Object, Object>) entry;

			String beverageName = (String) beverage.getKey();
			JSONObject ingredients = (JSONObject) beverage.getValue();

			List<Ingredient> ingredientList = new ArrayList<>();
			ingredients.forEach((key, value) -> {
				ingredientList.add(new Ingredient((String) key, (Long) value));
			});

			coffeeMachine.addBeverageEntry(beverageName, ingredientList);
		}

		return coffeeMachine;
	}
}

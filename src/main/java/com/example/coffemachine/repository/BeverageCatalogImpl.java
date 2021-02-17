package com.example.coffemachine.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.example.coffemachine.model.Beverage;

/**
 * BeverageCatalog implementation using InMemory storage
 * 
 * @author siddu
 *
 */
public class BeverageCatalogImpl implements BeverageCatalog {

	private Map<String, Beverage> beverages;

	public BeverageCatalogImpl() {
		this.beverages = new ConcurrentHashMap<>();
	}

	@Override
	public void addBeverage(Beverage beverage) {
		beverages.put(beverage.getName(), beverage);
	}

	@Override
	public Beverage getBeverage(String beverageName) {
		return beverages.get(beverageName);
	}

	@Override
	public Map<String, Beverage> getBeverageMap() {
		return this.beverages;
	}

}

package com.example.coffemachine.repository;

import java.util.Map;

import com.example.coffemachine.model.Beverage;

/**
 * holds different Beverage Instances
 * 
 * @author siddu
 *
 */
public interface BeverageCatalog {

	public void addBeverage(Beverage beverage);

	public Beverage getBeverage(String beverageName);

	public Map<String, Beverage> getBeverageMap();
}

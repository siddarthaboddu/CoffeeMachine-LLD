package com.example.coffemachine.model;

import java.util.List;

/**
 * Beverage which has a {@code name} and List of {@link Ingredient}
 * @author siddu
 *
 */
public class Beverage {

	private String name;
	private List<Ingredient> ingredients;

	public Beverage() {
		super();
	}

	public Beverage(String name) {
		super();
		this.name = name;
	}

	public Beverage(String name, List<Ingredient> ingredients) {
		super();
		this.name = name;
		this.ingredients = ingredients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
	}

	@Override
	public String toString() {
		return "Beverage [name=" + name + ", ingredients=" + ingredients + "]";
	}

}

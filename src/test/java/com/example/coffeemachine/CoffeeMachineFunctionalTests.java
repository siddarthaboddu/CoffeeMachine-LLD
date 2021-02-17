package com.example.coffeemachine;

import org.junit.Test;

import com.example.coffemachine.CoffeeMachine;
import com.example.coffemachine.factory.CoffeeMachineFactory;
import com.example.coffemachine.fixture.CoffeeMachineInputData;

/**
 * CoffeeMachine Functional Test cases
 * 
 * @author siddu
 *
 */
public class CoffeeMachineFunctionalTests {

	/**
	 * single threaded test for acquiring 3 beverages
	 */
	@Test
	public void singleThreadedTest() {
		CoffeeMachine coffeeMachine = CoffeeMachineFactory.getCoffeMachine(CoffeeMachineInputData.input_1);

		coffeeMachine.getBeverage(1, "hot_tea");
		coffeeMachine.getBeverage(2, "black_tea");
		coffeeMachine.getBeverage(3, "green_tea");
	}

	/**
	 * valid Beverage with sufficient ingredients in CoffeeMachine
	 */
	@Test
	public void validBeverageAndValidOutletAndSufficientIngredients() {
		CoffeeMachine coffeeMachine = CoffeeMachineFactory.getCoffeMachine(CoffeeMachineInputData.input_1);

		coffeeMachine.getBeverage(1, "hot_tea");
	}

	/**
	 * invalid outlet
	 */
	@Test
	public void InvalidOutletTest() {
		CoffeeMachine coffeeMachine = CoffeeMachineFactory.getCoffeMachine(CoffeeMachineInputData.input_1);

		coffeeMachine.getBeverage(4, "hot_tea");
		coffeeMachine.getBeverage(0, "hot_tea");
		coffeeMachine.getBeverage(-1, "hot_tea");
	}

	/**
	 * valid outlet but invalid beverage
	 */
	@Test
	public void validOutletButInvalidBeverageTest() {
		CoffeeMachine coffeeMachine = CoffeeMachineFactory.getCoffeMachine(CoffeeMachineInputData.input_1);

		coffeeMachine.getBeverage(1, "invalid_tea");
	}

	/**
	 * valid outlet, beverageName but insufficient ingredient
	 */
	@Test
	public void insufficientIngredient() {
		CoffeeMachine coffeeMachine = CoffeeMachineFactory.getCoffeMachine(CoffeeMachineInputData.input_2);

		coffeeMachine.getBeverage(1, "hot_tea");

	}

	/**
	 * 4 threads parallelly trying to get each one a beverage
	 */
	@Test
	public void getFourBeveragesMultiThreadedTest() {
		CoffeeMachine coffeeMachine = CoffeeMachineFactory.getCoffeMachine(CoffeeMachineInputData.input_1);

		Thread t1 = new Thread(() -> {
			coffeeMachine.getBeverage(1, "hot_tea");
		});
		Thread t2 = new Thread(() -> {
			coffeeMachine.getBeverage(2, "black_tea");
		});
		Thread t3 = new Thread(() -> {
			coffeeMachine.getBeverage(3, "green_tea");
		});
		Thread t4 = new Thread(() -> {
			coffeeMachine.getBeverage(1, "hot_coffee");
		});

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	/**
	 * outlet in use exception might occur because because two threads t1 and t2
	 * trying to acquire same outlet at once
	 */
	@Test
	public void outletInUseMayOccurBecauseOfMultipleThreadsTryToUseSameOutletTest() {
		CoffeeMachine coffeeMachine = CoffeeMachineFactory.getCoffeMachine(CoffeeMachineInputData.input_2);

		Thread t1 = new Thread(() -> {
			coffeeMachine.getBeverage(1, "hot_tea");
		});

		Thread t2 = new Thread(() -> {
			coffeeMachine.getBeverage(1, "hot_tea");
		});

		t1.start();
		t2.start();

	}
}

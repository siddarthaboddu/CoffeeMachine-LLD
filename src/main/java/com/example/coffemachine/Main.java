package com.example.coffemachine;

import com.example.coffemachine.factory.CoffeeMachineFactory;
import com.example.coffemachine.fixture.CoffeeMachineInputData;

public class Main {

	public static void main(String[] args) {
		CoffeeMachine coffeeMachine = CoffeeMachineFactory.getCoffeMachine(CoffeeMachineInputData.input_1);
		System.out.println("CoffeMachine instance created : "+ coffeeMachine);
	}
}

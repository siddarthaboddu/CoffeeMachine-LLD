package com.example.coffemachine.model;

/**
 * InventoryItem with {@code name} and {@code quantity}
 * @author siddu
 *
 */
public class InventoryItem {

	private String name;
	private Long quantity;

	public InventoryItem() {
		super();
	}

	public InventoryItem(String name, Long quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "InventoryItem [name=" + name + ", quantity=" + quantity + "]";
	}

}

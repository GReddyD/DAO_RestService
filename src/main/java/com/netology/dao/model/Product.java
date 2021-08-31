package com.netology.dao.model;

public class Product {
	private String product_name;

	public Product(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_name() {
		return product_name;
	}

	@Override
	public String toString() {
		return "Product{" +
						"product_name = '" + product_name + '\'' +
						'}';
	}
}

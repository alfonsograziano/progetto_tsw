package model;

import java.util.ArrayList;
import java.util.List;

import model.bean.Product;

public class Cart {

	private List<Product> products;
	
	public Cart() {
		products = new ArrayList<Product>();
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public void deleteProduct(Product product) {
		for(Product prod : products) {
			if(prod.getId() == product.getId()) {
				products.remove(prod);
				break;
			}
		}
 	}
	
	public List<Product> getProducts() {
		return  products;
	}
}
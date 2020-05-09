package model.bean;

import java.util.ArrayList;

public class Product {
	private int id;
	private String name;
	private String brand; 
	private double price;
	private String description;
	
	private ArrayList<String> pictures;
	private ArrayList<String> categories;
	
	public Product() {
		pictures = new ArrayList<>();
		categories = new ArrayList<>();

	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double d) {
		this.price = d;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} 
	

}

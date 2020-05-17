package model.bean;

import java.util.ArrayList;

public class Product {
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", visible=" + visible + ", pictures=" + pictures + ", categories=" + categories + "]";
	}
	private int id;
	private String name;
	private double price;
	private String description;
	private boolean visible;
	

	private ArrayList<String> pictures;
	private ArrayList<String> categories;
	
	public Product() {
		pictures = new ArrayList<>();
		categories = new ArrayList<>();

	}
	
	public boolean getVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
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

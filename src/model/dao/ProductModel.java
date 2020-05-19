package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import model.bean.Product;

public interface ProductModel {
	public Product getById(int id) throws SQLException;
	public ArrayList<Product> get() throws SQLException;
	public ArrayList<Product> getVisible() throws SQLException;

	public void add(Product product)  throws SQLException;
	public void update(Product product)  throws SQLException;
	
}

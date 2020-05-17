package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Category;
import model.bean.Product;
import model.bean.Belongs;

public interface BelongsModel {
	public ArrayList<Belongs> get() throws SQLException;
	public ArrayList<Category> getByProduct(int product) throws SQLException;
	public ArrayList<Product> getByCategory(String category) throws SQLException;

	public void add(Belongs belongs)  throws SQLException;
	public boolean delete(String product, int category)  throws SQLException;
}

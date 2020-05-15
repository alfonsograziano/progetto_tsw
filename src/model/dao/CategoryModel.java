package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Category;

public interface CategoryModel {
	public ArrayList<Category> get() throws SQLException;
	public Category getById(int id) throws SQLException;
	
	public void add(Category category)  throws SQLException;
	public void update(Category category)  throws SQLException;
	public boolean delete(int id)  throws SQLException;
}

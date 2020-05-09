package model.dao;

import java.sql.SQLException;
import java.util.Collection;

import model.bean.Product;

public interface ProductModel {
	public void doSave(Product product)  throws SQLException;
	public Product doRetrieveByKey(int id) throws SQLException;
	public boolean doDelete(int id)  throws SQLException;
	public Collection<Product> doRetrieveAll(String order) throws SQLException;
}

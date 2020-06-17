package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Contains;
import model.bean.Order;
import model.bean.Product;

public interface ContainsModel {
	public void add(Contains contains)  throws SQLException;
	public boolean delete(int IdOrder, int IdProduct)  throws SQLException;
	public ArrayList<Contains> get() throws SQLException;
	public ArrayList<Product> getByOrder(int IdOrder) throws SQLException;
	public ArrayList<Order> getByProduct(int IdProduct) throws SQLException;
	public Contains getByOrderProduct(int IdOrder,int IdProduct)throws SQLException;
}

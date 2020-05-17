package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Shipping;

public interface ShippingModel {
	public ArrayList<Shipping> get() throws SQLException;
	public Shipping getById(int id) throws SQLException;
	
	public void add(Shipping shipping)  throws SQLException;
	public void update(Shipping shipping)  throws SQLException;
	public boolean delete(int id)  throws SQLException;
}

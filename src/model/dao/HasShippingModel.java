package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.HasShipping;

public interface HasShippingModel {
	
	public ArrayList<HasShipping> getByUser(int id) throws SQLException;
	public void add(HasShipping hasshipping)  throws SQLException;

	

}

package model.dao;

import java.sql.SQLException;
import java.util.Collection;

import model.bean.Customer;

public interface CustomerModel {
	public Collection<Customer> get() throws SQLException;
	public Customer getById(int id) throws SQLException;
	
	public void add(Customer customer)  throws SQLException;
	public void update(Customer customer)  throws SQLException;
	public boolean delete(int id)  throws SQLException;
}

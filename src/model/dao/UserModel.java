package model.dao;

import java.sql.SQLException;
import java.util.Collection;

import model.bean.User;

public interface UserModel {
	public int checkPsw(String email, String password)  throws SQLException; 
	public Collection<User> get() throws SQLException;
	public User getById(int id) throws SQLException;
	
	public void add(User user)  throws SQLException;
	public void update(User user)  throws SQLException;
	public boolean delete(int id)  throws SQLException;
}

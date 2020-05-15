package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.bean.Product;
import model.bean.User;


public class UserModelDS implements UserModel {
	
	private static DataSource ds;
	private static final String TABLE_NAME = "user";

	public UserModelDS(){
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/Web");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	
	
	public Collection<User> get() throws SQLException{
		return new ArrayList<User>();
	}
	
	public User getById(int id) throws SQLException{
		return new User();
	}
	
	public void add(User user)  throws SQLException{

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + TABLE_NAME
				+ " (name, surname, email, password, is_admin) VALUES (?, ?, ?, ?, false)";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getSurname());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());

			preparedStatement.executeUpdate();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		
	}
	
	public void update(User user)  throws SQLException{
		
	}
	
	public boolean delete(int id)  throws SQLException{
		return true;
	}


	@Override
	public int checkPsw(String email, String password) throws SQLException {
		/*
		 * 0 => Non trovato
		 * 1 => Trovato
		 * 2 => Admin
		 * n => Altri permessi
		 */
		int user = 0; 
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Product bean = new Product();

		String selectSQL = "SELECT * FROM " + UserModelDS.TABLE_NAME + " WHERE email = ? AND password = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			ResultSet rs = preparedStatement.executeQuery();

			if(rs.next()) {
				user = 1;
				if(rs.getBoolean("is_admin")) {
					user = 2;
				}
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return user;

	}
}
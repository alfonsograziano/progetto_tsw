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
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<User>  users = new ArrayList<User>();

		String selectSQL = "SELECT * FROM " + TABLE_NAME;

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				User bean = new User();

				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				
				users.add(bean);
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
		return users;
	}
	
	public User getById(int id) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		User bean = new User();

		String selectSQL = "SELECT * FROM " + UserModelDS.TABLE_NAME + " WHERE id= ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			if(rs.next()) {
				bean.setEmail(rs.getString("email"));
				bean.setName(rs.getString("name"));
				bean.setSurname(rs.getString("surname"));
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
		
		return bean;
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
	public ArrayList<Integer> checkPsw(String email, String password) throws SQLException {
		/*
		 * 0 => Non trovato
		 * 1 => Trovato
		 * 2 => Admin
		 * n => Altri permessi
		 */
		int user = 0; 
		int user_id = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "SELECT * FROM " + UserModelDS.TABLE_NAME + " WHERE email = ? AND password = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			ResultSet rs = preparedStatement.executeQuery();

			if(rs.next()) {
				user_id = rs.getInt("id");
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
		ArrayList<Integer> data = new ArrayList<>();
		data.add(user); //tipo di utente
		data.add(user_id);
		return data;

	}
}

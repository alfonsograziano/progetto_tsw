package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.bean.Category;

public class CategoryModelDS implements CategoryModel {

	private static DataSource ds;

	public CategoryModelDS() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/Web");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	private static final String TABLE_NAME = "category";

	@Override
	public ArrayList<Category> get() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Category> categories = new ArrayList<Category>();

		String selectSQL = "SELECT * FROM " + CategoryModelDS.TABLE_NAME;

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Category bean = new Category();

				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				
				categories.add(bean);
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
		return categories;
	}

	@Override
	public Category getById(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Category bean = new Category();

		String selectSQL = "SELECT * FROM " + CategoryModelDS.TABLE_NAME + " WHERE id = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));

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

	@Override
	public void add(Category category) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + CategoryModelDS.TABLE_NAME + " (name, id) VALUES (?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, category.getName());
			preparedStatement.setString(2, category.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				System.out.println("Error:" + e.getMessage());
			}

		}

	}
	// Per l'update, quando si vuole cambiare l'id va fornito quello vecchio tramite
	// il bean e quello nuovo tramite string
	// in modo da permettere la ricerca prima della modifica, se si vuole mantenere
	// lo stesso id basterà impostare string=""

	@Override
	public void update(Category category, String newId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String updateSQL;
		if (newId.isEmpty()) {
			updateSQL = "UPDATE category SET name = ? WHERE id = ?";
		} else {
			updateSQL = "UPDATE category SET name = ?, id = ? WHERE id = ?";
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, category.getName());
			if (newId.isEmpty()) {
				preparedStatement.setString(2, category.getId());
			} else {
				preparedStatement.setString(2, newId);
				preparedStatement.setString(3, category.getId());
			}

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				System.out.println("Error:" + e.getMessage());
			}

		}

	}

	@Override
	public boolean delete(String id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE from category WHERE id = ?";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, id);

			preparedStatement.executeUpdate();
			if (preparedStatement != null)
				preparedStatement.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
			return false;
		}
	}

}

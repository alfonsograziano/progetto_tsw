package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.bean.Product;

public class ProductModelDS implements ProductModel{

	private static DataSource ds;
	
	public ProductModelDS(){
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/Web");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	private static final String TABLE_NAME = "product";
	
	public void add(Product product) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ProductModelDS.TABLE_NAME
				+ " (name, description, price, visible, iva) VALUES (?, ?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getDescription());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.setBoolean(4, true);
			preparedStatement.setInt(5, product.getIva());

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
	
	public Product getById(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Product bean = new Product();

		String selectSQL = "SELECT * FROM " + ProductModelDS.TABLE_NAME + " WHERE id = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();
			BelongsModelDS belongsModel = new BelongsModelDS();
			ImageModelDS imageModel = new ImageModelDS();

			if(rs.next()) {
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setDescription(rs.getString("description"));
				bean.setPrice(rs.getDouble("price"));
				bean.setVisible(rs.getBoolean("visible"));
				bean.setIva(rs.getInt("iva"));
				bean.setCategories(belongsModel.getByProduct(id));
				bean.setImages(imageModel.getImagesByProduct(id));

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
	
	
	public ArrayList<Product> get() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Product>  products = new ArrayList<Product>();

		String selectSQL = "SELECT * FROM " + ProductModelDS.TABLE_NAME;

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Product bean = new Product();

				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setDescription(rs.getString("description"));
				bean.setPrice(rs.getDouble("price"));
				bean.setVisible(rs.getBoolean("visible"));
				bean.setIva(rs.getInt("iva"));

				products.add(bean);
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
		return products;
	}

	@Override
	public void update(Product product) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String updateSQL;
		
		System.out.println("Imposto visible: " + product.getVisible());
		
		updateSQL = "UPDATE product SET name = ?, description = ?, price = ?, visible = ?, iva = ? WHERE id = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getDescription());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.setBoolean(4, product.getVisible());
			preparedStatement.setInt(5, product.getIva());
			preparedStatement.setInt(6, product.getId());

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
	public ArrayList<Product> getVisible() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Product>  products = new ArrayList<Product>();

		String selectSQL = "SELECT * FROM " + ProductModelDS.TABLE_NAME + " WHERE visible=true";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Product bean = new Product();

				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setDescription(rs.getString("description"));
				bean.setPrice(rs.getDouble("price"));
				bean.setIva(rs.getInt("iva"));
				bean.setVisible(rs.getBoolean("visible"));

				products.add(bean);
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
		return products;

	}

	@Override
	public ArrayList<Product> search(String name) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Product>  products = new ArrayList<Product>();

		String selectSQL = "SELECT * FROM " + ProductModelDS.TABLE_NAME + " WHERE name LIKE ? ";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, "%"+name+"%");
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();
			ImageModelDS imageModel = new ImageModelDS();

			while (rs.next()) {
				Product bean = new Product();

				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setDescription(rs.getString("description"));
				bean.setPrice(rs.getDouble("price"));
				bean.setIva(rs.getInt("iva"));
				bean.setVisible(rs.getBoolean("visible"));
				bean.setImages(imageModel.getImagesByProduct(bean.getId()));

				products.add(bean);
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
		return products;

	}
}

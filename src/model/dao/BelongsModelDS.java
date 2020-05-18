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
import model.bean.Product;
import model.bean.Belongs;

public class BelongsModelDS implements BelongsModel{

	private static DataSource ds;

	public BelongsModelDS() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/Web");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	private static final String TABLE_NAME = "belongs";
	
	@Override
	public ArrayList<Belongs> get() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Belongs> belongs = new ArrayList<Belongs>();

		String selectSQL = "SELECT * FROM " + BelongsModelDS.TABLE_NAME;

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Belongs bean = new Belongs();

				bean.setProduct(rs.getInt("product"));
				bean.setCategory(rs.getString("category"));
				
				belongs.add(bean);
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
		return belongs;

	}



	@Override
	public void add(Belongs belongs) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + BelongsModelDS.TABLE_NAME + " (product, category) VALUES (?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, belongs.getProduct());
			preparedStatement.setString(2, belongs.getCategory());

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
	public boolean delete(String product, int category) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE from "+TABLE_NAME+" WHERE category = ? AND product= ?";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, product);
			preparedStatement.setInt(2, category);

			preparedStatement.executeUpdate();
			if (preparedStatement != null)
				preparedStatement.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
			return false;
		}
	}



	@Override
	public ArrayList<Category> getByProduct(int product) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Category> categories = new ArrayList<Category>();

		String selectSQL = "SELECT * FROM " + BelongsModelDS.TABLE_NAME + 
				" JOIN category on belongs.category=category.id"+
				" WHERE product = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, product);

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
	public ArrayList<Product> getByCategory(String category) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Product> products = new ArrayList<Product>();

		String selectSQL = "SELECT * FROM " + BelongsModelDS.TABLE_NAME + 
				" JOIN product on belongs.product=product.id"+
				" WHERE category = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, category);

			ResultSet rs = preparedStatement.executeQuery();
			ImageModelDS imageModel = new ImageModelDS();
			while (rs.next()) {
				Product bean = new Product();
				
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setDescription(rs.getString("description"));
				bean.setPrice(rs.getDouble("price"));
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

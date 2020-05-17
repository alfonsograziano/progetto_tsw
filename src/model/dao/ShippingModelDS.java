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

import model.bean.Shipping;

public class ShippingModelDS implements ShippingModel {

	private static DataSource ds;

	public ShippingModelDS() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/Web");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	private static final String TABLE_NAME = "shipping_type";

	@Override
	public ArrayList<Shipping> get() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Shipping> shipp = new ArrayList<Shipping>();

		String selectSQL = "SELECT * FROM " + ShippingModelDS.TABLE_NAME;

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Shipping bean = new Shipping();

				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setDays(rs.getInt("days"));
				bean.setPrice(rs.getDouble("price"));

				shipp.add(bean);
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
		return shipp;
	}

	@Override
	public Shipping getById(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Shipping bean = new Shipping();

		String selectSQL = "SELECT * FROM " + ShippingModelDS.TABLE_NAME + " WHERE id = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setDays(rs.getInt("days"));
				bean.setPrice(rs.getDouble("price"));

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
	public void add(Shipping shipping) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ShippingModelDS.TABLE_NAME + " (name, days, price, id) VALUES (?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, shipping.getName());
			preparedStatement.setInt(2, shipping.getDays());
			preparedStatement.setDouble(3, shipping.getPrice());
			preparedStatement.setInt(4, shipping.getId());

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
	public void update(Shipping shipping) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String updateSQL = "UPDATE shipping_type SET name = ?, price = ?, days = ? WHERE id = ?";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, shipping.getName());
			preparedStatement.setDouble(2, shipping.getPrice());
			preparedStatement.setInt(3, shipping.getDays());
			preparedStatement.setInt(4, shipping.getId());

			preparedStatement.executeUpdate();

		} catch (

		SQLException e) {
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
	public boolean delete(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE from shipping_type WHERE id = ?";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);

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

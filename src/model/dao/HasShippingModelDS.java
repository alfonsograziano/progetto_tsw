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

import model.bean.Belongs;
import model.bean.Category;
import model.bean.HasShipping;

public class HasShippingModelDS implements HasShippingModel {
	private static DataSource ds;

	public HasShippingModelDS() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/Web");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	private static final String TABLE_NAME = "has_shipping";
	
	
	public void add(HasShipping hasshipping) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + HasShippingModelDS.TABLE_NAME + " (shipping_info_id, user_id) VALUES (?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, hasshipping.getShippingInfoId());
			preparedStatement.setInt(2, hasshipping.getUserId());

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
	
	
	public ArrayList<HasShipping> getByUser(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<HasShipping> hasshipping = new ArrayList<HasShipping>();

		String selectSQL = "SELECT * FROM " + HasShippingModelDS.TABLE_NAME + 
				" JOIN shipping_info_id on Has_shipping.shipping_info_id=shipping_info.id"+
				" WHERE user_id = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				HasShipping bean = new HasShipping();
				
				bean.setShippingInfoId(rs.getInt("shipping_info_id"));
				bean.setUserId(rs.getInt("user_id"));

				
				
				hasshipping.add(bean);
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
		return hasshipping;

	}
	
	
	
	
	
	
	
	
	
	
	
	

}

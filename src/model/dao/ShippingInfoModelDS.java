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
import model.bean.ShippingInfo;

public class ShippingInfoModelDS implements ShippingInfoModel {
	private static DataSource ds;
	
	public ShippingInfoModelDS() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/Web");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	private static final String TABLE_NAME = "shipping_info";
	
	public void add(ShippingInfo shippinginfo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ShippingInfoModelDS.TABLE_NAME + " (address, state, zip_code, city, id_user) VALUES (?, ?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, shippinginfo.getAddress());
			preparedStatement.setString(2, shippinginfo.getState());
			preparedStatement.setString(3, shippinginfo.getZipCode());
			preparedStatement.setString(4, shippinginfo.getCity());
			preparedStatement.setInt(5, shippinginfo.getUserId());

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
	
	public boolean delete(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE from shipping_info WHERE id = ?";
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
	
	
	public void updateAddress(ShippingInfo shippinginfo, String newaddress) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String updateSQL;
			updateSQL = "UPDATE shipping_info SET address = ? WHERE id = ?";
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, newaddress);
			preparedStatement.setInt(2,shippinginfo.getId());
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
	
	public void updateState(ShippingInfo shippinginfo, String newstate) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String updateSQL;
			updateSQL = "UPDATE shipping_info SET state = ? WHERE id = ?";
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, newstate);
			preparedStatement.setInt(2,shippinginfo.getId());
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
	
	
	public void updateZipCode(ShippingInfo shippinginfo, String newzipcode) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String updateSQL;
			updateSQL = "UPDATE shipping_info SET zip_code = ? WHERE id = ?";
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, newzipcode);
			preparedStatement.setInt(2,shippinginfo.getId());
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
	
	
	public void updateCity(ShippingInfo shippinginfo, String newcity) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String updateSQL;
			updateSQL = "UPDATE shipping_info SET city = ? WHERE id = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, newcity);
			preparedStatement.setInt(2,shippinginfo.getId());
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
	
	
	public ShippingInfo getById(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ShippingInfo bean = new ShippingInfo();

		String selectSQL = "SELECT * FROM " + ShippingInfoModelDS.TABLE_NAME + " WHERE id = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setId(rs.getInt("id"));
				bean.setAddress(rs.getString("address"));
				bean.setState(rs.getString("state"));
				bean.setZipCode(rs.getString("zip_code"));
				bean.setCity(rs.getString("city"));

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

	public ArrayList<ShippingInfo> getByUser(int user) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<ShippingInfo> shipUser = new ArrayList<ShippingInfo>();
		String selectSQL = "SELECT * FROM " + ShippingInfoModelDS.TABLE_NAME + " WHERE id_user = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1,user);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ShippingInfo bean=new ShippingInfo();
				bean.setId(rs.getInt("id"));
				bean.setAddress(rs.getString("address"));
				bean.setState(rs.getString("state"));
				bean.setZipCode(rs.getString("zip_code"));
				bean.setCity(rs.getString("city"));
				shipUser.add(bean);
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
		return shipUser;
		
	}

	
	
	
	
	
	
	
	
	

}

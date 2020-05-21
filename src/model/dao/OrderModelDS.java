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
import model.bean.Order;

public class OrderModelDS implements OrderModel{
	private static DataSource ds;
	
	public OrderModelDS() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/Web");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	private static final String TABLE_NAME = "`order`";
	
	public void add(Order order) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + OrderModelDS.TABLE_NAME + " (date, iva, city, address, state, zip_code, details, track_id, shipping_price, payment_id, shipping_type_id, payment_code, id_user, order_state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setTimestamp(1,order.getData());
			preparedStatement.setDouble(2, order.getIva());
			preparedStatement.setString(3,order.getCity());
			preparedStatement.setString(4,order.getAddress());
			preparedStatement.setString(5,order.getState());
			preparedStatement.setString(6,order.getZipCode());
			preparedStatement.setString(7,order.getDetails());
			preparedStatement.setString(8,order.getTrack_id());
			preparedStatement.setDouble(9,order.getShippingPrice());
			preparedStatement.setString(10,order.getPaymentId());
			preparedStatement.setInt(11,order.getShippingTypeId());
			preparedStatement.setString(12,order.getPaymentCode());
			preparedStatement.setInt(13,order.getIdUser());
			preparedStatement.setInt(14,order.getOrderState());
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

		String deleteSQL = "DELETE from `order` WHERE id = ?";
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
	
	
	public ArrayList<Order> get(){
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Order> orders = new ArrayList<Order>();
		String selectSQL = "SELECT * FROM " + OrderModelDS.TABLE_NAME;

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Order bean=new Order();
				bean.setId(rs.getInt("id"));
				bean.setData(rs.getTimestamp("date"));
				bean.setIva(rs.getDouble("iva"));
				bean.setCity(rs.getString("city"));
				bean.setAddress(rs.getString("address"));
				bean.setState(rs.getString("state"));
				bean.setZipCode(rs.getString("zip_code"));
				bean.setDetails(rs.getString("details"));
				bean.setTrack_id(rs.getString("track_id"));
				bean.setShippingPrice(rs.getDouble("shipping_price"));
				bean.setPaymentId(rs.getString("payment_id"));
				bean.setShippingTypeId(rs.getInt("shipping_type_id"));
				bean.setPaymentCode(rs.getString("payment_code"));
				bean.setIdUser(rs.getInt("id_user"));
				bean.setOrderState(rs.getInt("order_state"));
				orders.add(bean);
			}

		}catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			}catch (SQLException e) {
				System.out.println("Error:" + e.getMessage());
			}
			finally {
				if (connection != null)
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		return orders;
		
	}

	
	
	public ArrayList<Order> getByUser(int idUser)  {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Order> orderUser = new ArrayList<Order>();
		String selectSQL = "SELECT * FROM " + OrderModelDS.TABLE_NAME + " WHERE id_user = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1,idUser);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Order bean=new Order();
				bean.setId(rs.getInt("id"));
				bean.setData(rs.getTimestamp("date"));
				bean.setIva(rs.getDouble("iva"));
				bean.setCity(rs.getString("city"));
				bean.setAddress(rs.getString("address"));
				bean.setState(rs.getString("state"));
				bean.setZipCode(rs.getString("zip_code"));
				bean.setDetails(rs.getString("details"));
				bean.setTrack_id(rs.getString("track_id"));
				bean.setShippingPrice(rs.getDouble("shipping_price"));
				bean.setPaymentId(rs.getString("payment_id"));
				bean.setShippingTypeId(rs.getInt("shipping_type_id"));
				bean.setPaymentCode(rs.getString("payment_code"));
				bean.setIdUser(rs.getInt("id_user"));
				bean.setOrderState(rs.getInt("order_state"));
				orderUser.add(bean);
			}

		}catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			}catch (SQLException e) {
				System.out.println("Error:" + e.getMessage());
			}
			finally {
				if (connection != null)
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		return orderUser;
		
	}
	
	public ArrayList<Order> getByState(int idUser){
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Order> orderUser = new ArrayList<Order>();
		String selectSQL = "SELECT * FROM " + OrderModelDS.TABLE_NAME + " WHERE id_user = ? AND order_state !=4";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1,idUser);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Order bean=new Order();
				bean.setId(rs.getInt("id"));
				bean.setData(rs.getTimestamp("date"));
				bean.setIva(rs.getDouble("iva"));
				bean.setCity(rs.getString("city"));
				bean.setAddress(rs.getString("address"));
				bean.setState(rs.getString("state"));
				bean.setZipCode(rs.getString("zip_code"));
				bean.setDetails(rs.getString("details"));
				bean.setTrack_id(rs.getString("track_id"));
				bean.setShippingPrice(rs.getDouble("shipping_price"));
				bean.setPaymentId(rs.getString("payment_id"));
				bean.setShippingTypeId(rs.getInt("shipping_type_id"));
				bean.setPaymentCode(rs.getString("payment_code"));
				bean.setIdUser(rs.getInt("id_user"));
				bean.setOrderState(rs.getInt("order_state"));
				orderUser.add(bean);
			}

		}catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			}catch (SQLException e) {
				System.out.println("Error:" + e.getMessage());
			}
			finally {
				if (connection != null)
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		return orderUser;	
	}
	
	public void updateTracking(int id, String newTracking) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String updateSQL;
			updateSQL = "UPDATE `order` SET track_id = ? WHERE id = ?";
			//System.out.println(newTracking);

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			if (!newTracking.isEmpty()) {
				preparedStatement.setString(1, newTracking);
				preparedStatement.setInt(2, id);
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
	
	
	public void updateOrderState(int id, int newOrderState) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String updateSQL;
			updateSQL = "UPDATE `order` SET order_state = ? WHERE id = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			if (newOrderState==1 || newOrderState==2 || newOrderState==3 || newOrderState==4) {
				preparedStatement.setInt(1, newOrderState);
				preparedStatement.setInt(2, id);
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

}

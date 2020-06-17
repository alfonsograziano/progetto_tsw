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
import model.bean.Contains;
import model.bean.Order;
import model.bean.Product;

public class ContainsModelDS {
	
	private static DataSource ds;

	public ContainsModelDS() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/Web");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	private static final String TABLE_NAME = "contains";
	
	public void add(Contains contains)  {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ContainsModelDS.TABLE_NAME + " (order_id, product_id, price, quantity) VALUES (?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, contains.getOrderId());
			preparedStatement.setInt(2, contains.getProductId());
			preparedStatement.setDouble(3,contains.getPrice());
			preparedStatement.setInt(4,contains.getQuantity());

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
	
	
	public boolean delete(int IdOrder, int IdProduct)  {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE from "+TABLE_NAME+" WHERE order_id = ? AND product_id= ?";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, IdOrder);
			preparedStatement.setInt(2, IdProduct);

			preparedStatement.executeUpdate();
			if (preparedStatement != null)
				preparedStatement.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
			return false;
		}
	}
	
	public ArrayList<Contains> get()  {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Contains> contains = new ArrayList<Contains>();

		String selectSQL = "SELECT * FROM " + ContainsModelDS.TABLE_NAME;

		try {
			try {
				connection = ds.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				preparedStatement = connection.prepareStatement(selectSQL);
				ResultSet rs = preparedStatement.executeQuery();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Contains bean = new Contains();

				bean.setOrderId(rs.getInt("order_id"));
				bean.setProductId(rs.getInt("product_id"));
				bean.setPrice(rs.getDouble("price"));
				bean.setQuantity(rs.getInt("quantity"));
				
				contains.add(bean);
			}


		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
			}}	
		
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contains;
		
	}
	
	public Contains getByOrderProduct(int IdOrder,int IdProduct) throws SQLException {
		Connection connection = null;
		Contains bean=new Contains();
		PreparedStatement preparedStatement = null;
		String selectSQL = "SELECT * FROM " + ContainsModelDS.TABLE_NAME + 
				" WHERE order_id = ? and product_id=?";
	
			try {
				connection = ds.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setInt(1, IdOrder);
				preparedStatement.setInt(2, IdProduct);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			try {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setOrderId(rs.getInt("order_id"));
				bean.setProductId(rs.getInt("product_id"));
				bean.setPrice(rs.getDouble("price"));
				bean.setQuantity(rs.getInt("quantity"));
				
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

	
	public ArrayList<Product> getByOrder(int IdOrder) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Product> products = new ArrayList<Product>();

		String selectSQL = "SELECT * FROM " + ContainsModelDS.TABLE_NAME + 
				" JOIN product on contains.product_id=product.id"+
				" WHERE order_id = ? ";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, IdOrder);

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
			

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		return products;
	}
	
	
	public ArrayList<Order> getByProduct(int IdProduct) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Order> orders = new ArrayList<Order>();

		String selectSQL = "SELECT * FROM " + ContainsModelDS.TABLE_NAME + 
				" JOIN `order` on contains.order_id=order.id"+
				" WHERE product_id = ? ";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, IdProduct);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Order bean = new Order();
				bean.setId(rs.getInt("id"));
				bean.setDate(rs.getTimestamp("date"));
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
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				if (preparedStatement != null)
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			} finally {
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
}

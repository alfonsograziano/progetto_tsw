package model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


import model.bean.Image;
import model.bean.Product;

/**
 * Servlet implementation class ImageModelDS
 */
@WebServlet("/ImageModelDS")
public class ImageModelDS extends HttpServlet {
	private static DataSource ds;
	private static final String TABLE_NAME = "image";


	
	public ImageModelDS(){
		
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/Web");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	public synchronized static byte[] load(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "SELECT img FROM "+ImageModelDS.TABLE_NAME+" WHERE id = ?";

		byte[] bt = null;

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			preparedStatement.setInt(1, id);


			if (rs.next()) {
				bt = rs.getBytes("img");
			}

		} catch (SQLException sqlException) {
			System.out.println(sqlException);
		} 
	 finally {
		try {
			if (preparedStatement != null)
				preparedStatement.close();
		} finally {
			if (connection != null)
				connection.close();
		}
	}
		return bt;
	}

	public synchronized static void updatePhoto(String prodotto, String img) throws SQLException {
		int id = Integer.parseInt(prodotto);
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		 String sql="UPDATE"+ ImageModelDS.TABLE_NAME+ "SET img = ? WHERE id = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			preparedStatement.setString(1, img);
			preparedStatement.setInt(2, id);

			File file = new File(img);
			try {
				FileInputStream fis = new FileInputStream(file);
				preparedStatement.setBinaryStream(1, fis, fis.available());
				preparedStatement.setInt(2, id);
				preparedStatement.executeUpdate();
				connection.commit();
			} catch (FileNotFoundException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
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
		}
	}	

	
	
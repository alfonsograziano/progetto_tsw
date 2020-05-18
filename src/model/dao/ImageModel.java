package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Category;

public interface ImageModel {
	
	public void updatePhoto(String prodotto, String img) throws SQLException;
	public byte[] load(int idImmagine) throws SQLException;
	public void deletePhoto(int idImmagine) throws SQLException;
}

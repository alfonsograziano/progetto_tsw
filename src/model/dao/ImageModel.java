package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Category;
import model.bean.Image;

public interface ImageModel {
	
	public void updatePhoto(String prodotto, String img) throws SQLException;
	public byte[] load(int idImmagine) throws SQLException;
	
	public ArrayList<Image> getImagesByProduct(int id)  throws SQLException;
}

package model.dao;

import java.sql.SQLException;

import model.bean.Category;
import model.bean.ShippingInfo;

public interface ShippingInfoModel {
	public void add(ShippingInfo shippinginfo)  throws SQLException;
	public void updateAddress(ShippingInfo shippinginfo, String newaddress)  throws SQLException;
	public boolean delete(int id)  throws SQLException;

}

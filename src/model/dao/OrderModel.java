package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Order;

public interface OrderModel {
	public long add(Order order)  throws SQLException;
	public boolean delete(int id)  throws SQLException;
	public ArrayList<Order> get() throws SQLException ;  //tutti gli ordini di tutti gli utenti(admin)
	public Order getById(int id) throws SQLException ;  //tutti gli ordini di tutti gli utenti(admin)
	public Order getCompleteOrderById(int id) throws SQLException ;  //tutti gli ordini di tutti gli utenti(admin)

	
	public ArrayList<Order> getByUser(int idUser) throws SQLException ; //tutti gli ordini di un utente(admin)
	public ArrayList<Order> getByState(int id) throws SQLException ;  //tutti gli ordini di un utente con codice di stato diverso da 4
	public void updateTracking(int id, String newTracking) throws SQLException;
	public void updateOrderState(int id, int newOrderState) throws SQLException;
}

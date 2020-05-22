package model.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Order {
	@Override
	public String toString() {
		return "Order [id=" + id + ", data=" + date + ", iva=" + iva + ", city=" + city + ", address=" + address
				+ ", state=" + state + ", zipCode=" + zipCode + ", details=" + details + ", track_id=" + track_id
				+ ", shippingPrice=" + shippingPrice + ", paymentId=" + paymentId + ", shippingTypeId=" + shippingTypeId
				+ ", paymentCode=" + paymentCode + ", idUser=" + idUser + ", orderState=" + orderState + "]";
	}
	public ArrayList<ChoosenProduct> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<ChoosenProduct> products) {
		this.products = products;
	}
	private int id;
	private Timestamp date;
	private double iva;
	private String city;
	private String address;
	private String state;
	private String zipCode;
	private String details;
	private String track_id;
	private double shippingPrice;
	private String paymentId;
	private int shippingTypeId;
	private String paymentCode;
	private int idUser;
	private int orderState;
	
	private ArrayList<ChoosenProduct> products;
	
	public Order() {
		products = new ArrayList<ChoosenProduct>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getTrack_id() {
		return track_id;
	}
	public void setTrack_id(String track_id) {
		this.track_id = track_id;
	}
	public double getShippingPrice() {
		return shippingPrice;
	}
	public void setShippingPrice(double shippingPrice) {
		this.shippingPrice = shippingPrice;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public int getShippingTypeId() {
		return shippingTypeId;
	}
	public void setShippingTypeId(int shippingTypeId) {
		this.shippingTypeId = shippingTypeId;
	}
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	public String getStringOrderState() {
		if(this.orderState == 1) return "pending";
		if(this.orderState == 2) return "sent";
		if(this.orderState == 3) return "fulfilled";
		if(this.orderState == 4) return "deleted";
		return "";
	}

	
}

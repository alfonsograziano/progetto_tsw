package model.dao;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Contains;
import model.bean.Order;
import model.bean.Product;

/**
 * Servlet implementation class prova
 */
@WebServlet("/prova")
public class prova extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public prova() {
        super();
        // TODO Auto-generated constructor stub
    }

	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderModelDS d=new OrderModelDS();
		Order o=new Order();
		Timestamp x=new Timestamp(2020,05,21,12,06,0,0);
		o.setData(x);
		o.setIva(21.45);
		o.setCity("stabia");
		o.setAddress("via napoli 12");
		o.setState("italia");
		o.setZipCode("80053");
		o.setDetails("beh no");
		o.setTrack_id("666");
		o.setShippingPrice(11.20);
		o.setPaymentId(2);
		o.setShippingTypeId(2);
		o.setPaymentCode("non lo conosco");
		o.setIdUser(1);
		o.setOrderState(4);
		o.toString();
		
	}*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderModelDS d=new OrderModelDS();
		Order o=new Order();
		Timestamp x=new Timestamp(2020,05,21,12,06,0,0);
		/*o.setData(x);
		o.setIva(21.45);
		o.setCity("milano");
		o.setAddress("via roma");
		o.setState("italia");
		o.setZipCode("80087");
		o.setDetails("nmnb");
		o.setTrack_id("789");
		o.setShippingPrice(7.20);
		o.setPaymentId("okok");
		o.setShippingTypeId(1);
		o.setPaymentCode("bghy");
		o.setIdUser(1);
		o.setOrderState(4);
		d.add(o);*/
		
		/*System.out.println(o.getData());
		System.out.println(o.getCity());
		System.out.println(o.getAddress());
		System.out.println(o.getState());
		System.out.println(o.getZipCode());
		System.out.println(o.getDetails());
		System.out.println(o.getTrack_id());
		System.out.println(o.getShippingPrice());
		System.out.println(o.getPaymentId());
		System.out.println(o.getPaymentCode());
		System.out.println(o.getIdUser());
		System.out.println(o.getOrderState());*/
		//d.add(o);
		//d.delete(3);
		/*ArrayList<Order> b;
		b=d.getByUser(1);
		for(int i=0;i<b.size();i++) {
			System.out.println(b.get(i).getCity());
		}*/
//d.updateOrderState(4,2);
		
	
		//ContainsModelDS dao=new ContainsModelDS();
		
		/*ArrayList<Contains> y=dao.get();
		for(int i=0;i<y.size();i++) {
			System.out.println(y.get(i).getPrice());
		}*/
		
		/*c.setOrderId(5);
		c.setProductId(5);
		c.setPrice(63.20);
		c.setQuantity(1);
		dao.add(c);*/
		//dao.delete(4, 2);

		/*ArrayList<Product> y=dao.getByOrder(4);
		for(int i=0;i<y.size();i++) {
			System.out.println(y.get(i).getPrice());
		}*/
		
		/*ArrayList<Order> y=dao.getByProduct(5);
		for(int i=0;i<y.size();i++) {
			System.out.println(y.get(i).getAddress());
		}*/ 
		
	/*	OrderModelDS da=new OrderModelDS();
		/*ArrayList<Order> r=da.get();
		for(int i=0;i<r.size();i++) {
			System.out.println(r.get(i).getAddress());
		}*/
		ArrayList<Order> b=d.getByState(1);
		for(int i=0;i<b.size();i++) {
			System.out.println(b.get(i).getAddress());
		}
		
		
		
		
		
		
		
		
		
	}

}

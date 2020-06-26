package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

import model.bean.ChoosenProduct;
import model.bean.Contains;
import model.bean.Order;
import model.bean.User;
import model.bean.Shipping;
import model.dao.ContainsModelDS;
import model.dao.OrderModelDS;
import model.dao.ShippingModelDS;
import model.dao.UserModelDS;

/**
 * Servlet implementation class CreateOrder
 */
@WebServlet("/order/add")
public class CreateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateOrder() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chiamo la servlet di creazione dell'ordine....");
		
		//Controllo se l'utente è loggato
		if(request.getSession().getAttribute("user_id") == null) {
			response.setStatus(301);
			response.getWriter().append("Errore, non sei loggato, non puoi effettuare l'acquisto");
		}else {
			Integer user_id = (Integer) request.getSession().getAttribute("user_id");
			try {
				
				//Controllo se nel carrello ci sono elementi
				ArrayList<ChoosenProduct> cart = (ArrayList<ChoosenProduct>) request.getSession().getAttribute("cart");
				if (cart == null) {
					response.setStatus(400);
					response.getWriter().append("Errore, non hai elementi nel carrello");
				}else {
					int shipping_type_id = -1;
					ShippingModelDS shippingModel = new ShippingModelDS();
					Shipping shipping = new Shipping();
					//Verifico se ho impostato un tipo di spedizione
					if(request.getSession().getAttribute("shipping_type_id") == null){
						response.getWriter().append("Errore, non hai impostato il tipo di spedizione");

					}else{
						shipping_type_id = (int) request.getSession().getAttribute("shipping_type_id");
						shipping = shippingModel.getById(shipping_type_id);
						
						//Inizio a prendere tutti gli attributi
						Date date = new Date();
						Timestamp time = new Timestamp(date.getTime());
						 
						String state = request.getParameter("state");
						String city = request.getParameter("city");
						String address = request.getParameter("address");
						String zipCode = request.getParameter("zip_code");
						String details = request.getParameter("details");
						String track_id = null; //non ho ancora spedito
						String paymentId = (String) request.getParameter("payment_id");

											
						Order o = new Order();
						o.setDate(time);
						o.setCity(city);
						o.setAddress(address);
						o.setState(state);
						o.setZipCode(zipCode);
						o.setDetails(details);
						o.setTrack_id(track_id);
						o.setPaymentId(paymentId);
						o.setShippingPrice(shipping.getPrice());
						o.setShippingTypeId(shipping.getId());
						o.setIdUser(user_id);
						o.setPaymentCode(null);
						o.setOrderState(1);
						
						System.out.println(o);

						OrderModelDS orderModel = new OrderModelDS();
						int id = (int) orderModel.add(o);
						System.out.println("Ordine con id: " + id + " creato!");
						
						ContainsModelDS containsModel = new ContainsModelDS();
						for(int i = 0; i < cart.size(); i++) {
							Contains prd = new Contains();
							prd.setIva(cart.get(i).getProduct().getIva());
							prd.setOrderId(id);
							prd.setPrice(cart.get(i).getProduct().getPrice());
							prd.setProductId(cart.get(i).getProduct().getId());
							prd.setQuantity(cart.get(i).getQuantity());
							containsModel.add(prd);
							
						}
						
						response.getWriter().append("Ordine creato...");
						
						//Riazzero il carrello
						request.getSession().setAttribute("cart",new ArrayList<ChoosenProduct>());

					}
				}
				

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 			
			
		}
		
	}

}

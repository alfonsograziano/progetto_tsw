package control.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.OrderModelDS;

/**
 * Servlet implementation class UpdateOrderState
 */
@WebServlet("/orders/updateOrderState")
public class UpdateOrderState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrderState() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer orderId = Integer.parseInt(request.getParameter("order_id"));
		Integer state =  Integer.parseInt(request.getParameter("order_state"));
		
		//TODO: Gestisci il metodo updateTracking con il try catch nell'utilizzatore e non nel metodo
		OrderModelDS orderModel = new OrderModelDS();
		orderModel.updateOrderState(orderId, state);
		response.sendRedirect((String) request.getHeader("referer"));
		
	}

}

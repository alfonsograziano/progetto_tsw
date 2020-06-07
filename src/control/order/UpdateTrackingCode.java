package control.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.OrderModelDS;

/**
 * Servlet implementation class UpdateTrackingCode
 */
@WebServlet("/orders/updateTrackingCode")
public class UpdateTrackingCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateTrackingCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Integer orderId = Integer.parseInt(request.getParameter("order_id"));
			String trackingId = (String) request.getParameter("tracking_id");

			OrderModelDS orderModel = new OrderModelDS();
			orderModel.updateTracking(orderId, trackingId);
			response.sendRedirect((String) request.getHeader("referer"));
		} catch (Exception e) {
			response.setStatus(400);
			response.getWriter().append("Errore");
		}
	}

}

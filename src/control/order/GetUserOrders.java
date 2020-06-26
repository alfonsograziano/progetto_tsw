package control.order;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Order;
import model.dao.OrderModelDS;

/**
 * Servlet implementation class GetUserOrders
 */
@WebServlet("/GetUserOrders")
public class GetUserOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public GetUserOrders() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderModelDS orderModel = new OrderModelDS();
		ArrayList<Order> orders = orderModel.getByUser((int) request.getSession().getAttribute("user_id"));
		request.setAttribute("orders", orders);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/components/pages/user/ShowOrders.jsp");
		dispatcher.forward(request, response);

	}



}

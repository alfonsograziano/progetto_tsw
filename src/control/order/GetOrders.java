package control.order;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Order;
import model.bean.User;
import model.dao.OrderModelDS;
import model.dao.UserModelDS;

/**
 * Servlet implementation class GetOrders
 */
@WebServlet("/admin/dashboard/orders")
public class GetOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			OrderModelDS orderModel = new OrderModelDS();
			ArrayList<Order> orders = orderModel.get();
			request.setAttribute("orders", orders);
			
			UserModelDS userModel = new UserModelDS();
			ArrayList<User> users = (ArrayList<User>) userModel.get();
			request.setAttribute("users", users);
			
			request.setAttribute("pageName", "/components/pages/admin/OrderList.jsp");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/components/pages/admin/AdminPage.jsp");
			dispatcher.forward(request, response);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}

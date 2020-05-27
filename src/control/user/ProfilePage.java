package control.user;

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
 * Servlet implementation class ProfilePage
 */
@WebServlet("/profile")
public class ProfilePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession().getAttribute("user_id") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
		}else {
			int id = (int) request.getSession().getAttribute("user_id");
			OrderModelDS orderModel = new OrderModelDS();
			ArrayList<Order> orders = orderModel.getByUser(id);
			request.setAttribute("orders", orders);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/components/pages/shop/Profile.jsp"); 
			dispatcher.forward(request, response);

		}
		
	}

}

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

import model.bean.Contains;
import model.bean.Order;
import model.bean.Product;
import model.bean.User;
import model.dao.ContainsModelDS;
import model.dao.OrderModelDS;
import model.dao.UserModelDS;

@WebServlet("/order")
public class UserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Integer id = Integer.parseInt(request.getParameter("id"));

			OrderModelDS orderModel = new OrderModelDS();
			Order order;

			order = orderModel.getCompleteOrderById(id);

			request.setAttribute("order", order);

			
			if(null == request.getSession().getAttribute("user_id")) {
				response.sendRedirect(request.getContextPath()+"/login");
			}else {
				int userId = (Integer) request.getSession().getAttribute("user_id");
				
				if (order.getIdUser() == userId) {
					ContainsModelDS containsModel = new ContainsModelDS();

					ArrayList<Product> products = containsModel.getByOrder(id);
					ArrayList<Contains> contains = new ArrayList<Contains>();
					for (int i = 0; i < products.size(); i++) {
						contains.add(containsModel.getByOrderProduct(id, products.get(i).getId()));
					}
					request.setAttribute("contains", contains);
					request.setAttribute("products", products);

					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/components/pages/user/ShowOrderDetails.jsp");
					dispatcher.forward(request, response);

				} else {
					response.sendRedirect(request.getContextPath()+"/page-not-found");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

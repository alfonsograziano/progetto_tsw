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

		/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("ok fra");

			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				OrderModelDS orderModel = new OrderModelDS();
				UserModelDS userModel = new UserModelDS();
				try {
					Order order = orderModel.getCompleteOrderById(id);
					User user = userModel.getById(order.getIdUser());
					request.setAttribute("user", user);
					request.setAttribute("order", order);
					request.setAttribute("pageName", "/components/pages/admin/OrderDetails.jsp");
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/components/pages/admin/AdminPage.jsp");
					dispatcher.forward(request, response);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				response.setStatus(400);
				response.getWriter().append("Errore");
			}

		}*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		OrderModelDS orderModel = new OrderModelDS();
		ContainsModelDS containsModel=new ContainsModelDS();
		try {
			ArrayList<Product> products=containsModel.getByOrder(id);
			ArrayList<Contains> contains=new ArrayList<Contains>();
			for(int i=0;i<products.size();i++) {
				contains.add(containsModel.getByOrderProduct(id,products.get(i).getId()));
			}
			request.setAttribute("contains", contains);
			request.setAttribute("products", products);
			Order order = orderModel.getCompleteOrderById(id);
			request.setAttribute("order", order);
			System.out.println("prodotto 1: "+ products.get(0).getName());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/components/pages/user/ShowOrderDetails.jsp");
			dispatcher.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	}


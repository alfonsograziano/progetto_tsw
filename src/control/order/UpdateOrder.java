package control.order;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.OrderModelDS;

/**
 * Servlet implementation class Update
 */
@WebServlet("/orders/update")
public class UpdateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			OrderModelDS orderModel = new OrderModelDS();
			try {
				request.setAttribute("order", orderModel.getById(id));
				request.setAttribute("pageName", "/components/pages/admin/UpdateOrder.jsp");
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

	}

}

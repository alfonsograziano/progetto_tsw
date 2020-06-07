package control.shippingType;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Shipping;
import model.dao.ShippingModelDS;

/**
 * Servlet implementation class UpdateShipping
 */
@WebServlet("/shipping/update")
public class UpdateShipping extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateShipping() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			int days = Integer.parseInt(request.getParameter("days"));
			Double price = Double.parseDouble(request.getParameter("price"));
			int id = Integer.parseInt(request.getParameter("id"));

			Shipping shipp = new Shipping();
			shipp.setName(name);
			shipp.setDays(days);
			shipp.setPrice(price);
			shipp.setId(id);

			ShippingModelDS shippingModel = new ShippingModelDS();

			try {
				shippingModel.update(shipp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect(request.getContextPath() + "/admin/dashboard/shipping_type");
		} catch (Exception e) {
			response.setStatus(400);
			response.getWriter().append("Errore");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("pageName", "/components/pages/admin/UpdateShipping.jsp");
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/components/pages/admin/AdminPage.jsp");
		dispatcher.forward(request, response);
	}

}
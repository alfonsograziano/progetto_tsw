package control.shippingInfo;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ShippingInfo;
import model.dao.ShippingInfoModelDS;
import model.dao.ShippingModelDS;

/**
 * Servlet implementation class AddShippingInfo
 */
@WebServlet("/add")
public class AddShippingInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddShippingInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.getSession().setAttribute("user_id", 1);
			int user = (int) request.getSession().getAttribute("user_id");
			String address = request.getParameter("address");
			String state = request.getParameter("state");
			String zip = request.getParameter("zipCode");
			String city = request.getParameter("city");
			// System.out.println(user);
			ShippingInfo x = new ShippingInfo();
			x.setUserId(user);
			x.setAddress(address);
			x.setState(state);
			x.setZipCode(zip);
			x.setCity(city);
			// System.out.println("prova"+x.getUserId());

			ShippingInfoModelDS shippingInfoModel = new ShippingInfoModelDS();

			shippingInfoModel.add(x);
		} catch (Exception e) {
			response.setStatus(400);
			response.getWriter().append("Errore");
		}
	}

}

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
 * Servlet implementation class AddShipping
 */
@WebServlet("/shipping/add")
public class AddShipping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShipping() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int days = Integer.parseInt(request.getParameter("days"));
		double price = Double.parseDouble(request.getParameter("price"));
		
		
		Shipping shipp = new Shipping();
		shipp.setName(name);
		shipp.setDays(days);
		shipp.setPrice(price);
		
		ShippingModelDS shippingModel = new ShippingModelDS();
		
			try {
				shippingModel.add(shipp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect(request.getContextPath() + "/admin/dashboard/shipping_type");

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/components/pages/admin/AddShipping.jsp");
		dispatcher.forward(request, response);
	}

}
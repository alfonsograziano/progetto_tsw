package control.shippingType;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ShippingModelDS;

/**
 * Servlet implementation class DeleteShipping
 */
@WebServlet("/shipping/delete")
public class DeleteShipping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteShipping() {
        super();
        // TODO Auto-generated constructor stub
    }

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		ShippingModelDS shippingModel = new ShippingModelDS();
		
			try {
				shippingModel.delete(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect(request.getContextPath() + "/admin/dashboard/shipping_type");

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pageName", "/components/pages/admin/DeleteShipping.jsp");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/components/pages/admin/AdminPage.jsp");
		dispatcher.forward(request, response);
	}

}
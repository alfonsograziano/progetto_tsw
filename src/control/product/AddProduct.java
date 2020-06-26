package control.product;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Product;
import model.dao.ProductModelDS;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/product/add")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			Double price = Double.parseDouble(request.getParameter("price"));
			int iva = Integer.parseInt(request.getParameter("iva"));

			Product product = new Product();
			product.setIva(iva);
			product.setName(name);
			product.setDescription(description);
			product.setPrice(price);

			ProductModelDS productModel = new ProductModelDS();
			try {
				productModel.add(product);
				response.sendRedirect(request.getContextPath() + "/admin/dashboard");

			} catch (SQLException e) {
				response.getWriter().append("Error: \n" + e);
				e.printStackTrace();
			}

		} catch (Exception e) {
			response.setStatus(400);
			response.getWriter().append("Errore");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("pageName", "/components/pages/admin/AddProduct.jsp");
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/components/pages/admin/AdminPage.jsp");
		dispatcher.forward(request, response);
	}

}

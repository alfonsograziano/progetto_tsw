package control.product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProductModelDS;

/**
 * Servlet implementation class Search
 */
@WebServlet("/product/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			ProductModelDS productModel = new ProductModelDS();
			ArrayList<model.bean.Product> products;
			try {
				products = productModel.search(name);
				response.getWriter().append(products.toString());

			} catch (SQLException e) {
				response.getWriter().append("Errore: " + e);

			}
		} catch (Exception e) {
			response.setStatus(400);
			response.getWriter().append("Errore");
		}

	}

}

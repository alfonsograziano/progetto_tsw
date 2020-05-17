package control.product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.BelongsModelDS;
import model.dao.CategoryModelDS;
import model.dao.ProductModelDS;

import model.bean.Product;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/admin/dashboard/products/update")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		if(id != null && !id.isEmpty()) {
			int productId = Integer.parseInt(id);
		
			ProductModelDS productModel = new ProductModelDS();
			CategoryModelDS categoryModel = new CategoryModelDS();
			BelongsModelDS belongsModel = new BelongsModelDS();
			
		
			try {
				Product product = productModel.getById(productId);
				ArrayList<Category> categories = categoryModel.get();
				ArrayList<Category> productCategories = belongsModel.getByProduct(productId);
			
				request.setAttribute("product", product);
				request.setAttribute("categories", categories);
				request.setAttribute("productCategories", productCategories);
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/components/pages/admin/UpdateProduct.jsp");
				dispatcher.forward(request, response);	
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			response.sendRedirect(request.getContextPath() + "/admin/dashboard/products");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

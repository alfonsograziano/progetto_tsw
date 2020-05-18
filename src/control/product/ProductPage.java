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
import model.bean.Product;
import model.dao.CategoryModelDS;
import model.dao.ProductModelDS;

/**
 * Servlet implementation class ProductPage
 */
@WebServlet("/shop/product")
public class ProductPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println(id);
		if(id != null && !id.isEmpty()) {
			int productId = Integer.parseInt(id);
		
			ProductModelDS productModel = new ProductModelDS();

			try {
				Product product = productModel.getById(productId);
				request.setAttribute("product", product);
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/components/pages/shop/ProductPage.jsp");
				dispatcher.forward(request, response);	
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			//response.sendRedirect(request.getContextPath() + "/home");

		}
		
	}


}

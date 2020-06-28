package control.cart;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ChoosenProduct;
import model.bean.Product;
import model.dao.ProductModelDS;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/cart/add-to-cart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ProductModelDS pmds = new ProductModelDS();
			ArrayList<ChoosenProduct> cart = (ArrayList<ChoosenProduct>) request.getSession().getAttribute("cart");
			if(cart == null) {
				cart = new ArrayList<ChoosenProduct>();
			}
			ChoosenProduct bean = new ChoosenProduct();
			Product prod=null;
			try {
				prod = pmds.getById(Integer.parseInt(request.getParameter("product")));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bean.setProduct(prod);
			bean.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			cart.add(bean);
			request.getSession().setAttribute("cart", cart);
			response.sendRedirect(request.getContextPath() + "/home");
		}catch(Exception e) {
			response.setStatus(400);
			response.getWriter().append("Errore");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

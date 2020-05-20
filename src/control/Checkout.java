package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ShippingModelDS;
import model.dao.UserModelDS;
import model.bean.User;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(null ==  request.getSession().getAttribute("user_id")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/components/pages/shop/Checkout/CheckoutErrorPage.jsp"); 
			dispatcher.forward(request, response);
		}else {
			int id =  (int) request.getSession().getAttribute("user_id");
			System.out.println(id);
			UserModelDS userModel = new UserModelDS();
			
			try {
				User currentUser = (User) userModel.getById(id);
				System.out.println(currentUser);

				request.setAttribute("user", currentUser);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/components/pages/shop/Checkout/CheckoutPage.jsp"); 
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}


}

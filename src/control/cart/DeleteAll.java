package control.cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ChoosenProduct;

/**
 * Servlet implementation class DeleteAll
 */
@WebServlet("/cart/delete-all")
public class DeleteAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ChoosenProduct> cart = (ArrayList<ChoosenProduct>) request.getSession().getAttribute("cart");
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			for(int i=0; i<cart.size(); i++) {
				if(cart.get(i).getProduct().getId() == id) {
						cart.remove(i);
				}
			}
			request.getSession().setAttribute("cart", cart);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cart");
			dispatcher.forward(request, response);
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

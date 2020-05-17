package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BelongsModelDS;
import model.dao.ProductModelDS;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductModelDS productModel = new ProductModelDS();
		BelongsModelDS belongsModel = new BelongsModelDS();
		
		try {
			request.setAttribute("products", belongsModel.getByCategory("main"));
			//request.setAttribute("products", productModel.get());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/components/pages/shop/Home.jsp"); 
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			response.getWriter().append("Errore: \n"+e);
			e.printStackTrace();
		}
		
	}



}

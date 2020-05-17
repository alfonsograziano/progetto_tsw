package control.category;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryModelDS;


/**
 * Servlet implementation class Category
 */
@WebServlet("/admin/dashboard/categories")
public class GetCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryModelDS categoryModel = new CategoryModelDS();
		try {
			request.setAttribute("categories",categoryModel.get());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/components/pages/admin/Category.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			response.getWriter().append("Error: \n"+ e);
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

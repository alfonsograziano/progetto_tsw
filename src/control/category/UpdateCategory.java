package control.category;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CategoryModelDS;

/**
 * Servlet implementation class UpdateCategory
 */
@WebServlet("/category/update")
public class UpdateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String newId = request.getParameter("newId");
		
		
		Category category = new Category();
		category.setName(name);
		category.setId(id);
		
		CategoryModelDS categoryModel = new CategoryModelDS();
		
			categoryModel.update(category, newId);
			response.sendRedirect(request.getContextPath() + "/admin/dashboard/categories");

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/components/pages/admin/UpdateCategory.jsp");
		dispatcher.forward(request, response);
	}

}

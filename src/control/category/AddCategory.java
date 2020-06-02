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
 * Servlet implementation class AddCategory
 */
@WebServlet("/category/add")
public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		
		
		Category category = new Category();
		category.setName(name);
		category.setId(id);
		
		CategoryModelDS categoryModel = new CategoryModelDS();
		
			categoryModel.add(category);
			response.sendRedirect(request.getContextPath() + "/admin/dashboard/categories");

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pageName", "/components/pages/admin/AddCategory.jsp");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/components/pages/admin/AdminPage.jsp");
		dispatcher.forward(request, response);
		
	}

}

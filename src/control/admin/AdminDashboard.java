package control.admin;

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
import model.bean.Order;
import model.bean.Product;
import model.dao.CategoryModelDS;
import model.dao.OrderModelDS;
import model.dao.ProductModelDS;

/**
 * Servlet implementation class AdminDashboard
 */
@WebServlet("/admin/dashboard")
public class AdminDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDashboard() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CategoryModelDS categoryModel = new CategoryModelDS();
			ArrayList<Category> categories = categoryModel.get();
			request.setAttribute("categories",new ArrayList<Category>(categories.subList(0, categories.size()>5?5:categories.size())));
			
			OrderModelDS orderModel = new OrderModelDS();
			ArrayList<Order> orders = orderModel.get();
			request.setAttribute("orders", new ArrayList<Order>(orders.subList(0, orders.size()>5?5:orders.size())));
			
			ProductModelDS productModel = new ProductModelDS();
			ArrayList<Product> products = productModel.get();
			request.setAttribute("products",new ArrayList<Product>(products.subList(0, products.size()>5?5:products.size())));
			
			request.setAttribute("pageName", "/components/pages/admin/AdminDashboard.jsp");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/components/pages/admin/AdminPage.jsp");
			dispatcher.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}



}

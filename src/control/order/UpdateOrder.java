package control.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.OrderModelDS;

/**
 * Servlet implementation class Update
 */
@WebServlet("/orders/update")
public class UpdateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrder() {
        super();
        // TODO Auto-generated constructor stub
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		OrderModelDS orderModel = new OrderModelDS();
		//request.setAttribute("order", orderModel.get(id));
		//TODO: scrivi un getById
				
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/components/pages/admin/UpdateOrder.jsp"); 
		dispatcher.forward(request, response); 
	}


}

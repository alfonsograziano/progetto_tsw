package control.order;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Invoice;
import model.bean.Order;
import model.bean.User;
import model.dao.OrderModelDS;
import model.dao.UserModelDS;

/**
 * Servlet implementation class PrintOrder
 */
@WebServlet("/PrintOrder")
public class PrintOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user_id = (int) request.getSession().getAttribute("user_id");
		int order_id = Integer.parseInt(request.getParameter("order"));
		OrderModelDS orderds = new OrderModelDS();
		UserModelDS userds = new UserModelDS();
		try {
			Order o = orderds.getCompleteOrderById(order_id);
			User u = userds.getById(user_id);
			String root = getServletContext().getRealPath("/assets/");
			String pathIn = root+"invoice.pdf";
			String pathOut = root+String.valueOf(o.getId()) +".pdf";
			Invoice printer = new Invoice(o, u, pathIn, pathOut);
			printer.print();
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "attachment; filename=Fattura.pdf");
			 try(InputStream in = request.getServletContext().getResourceAsStream("/assets/"+ String.valueOf(o.getId()) +".pdf");
			          OutputStream out = response.getOutputStream()) {
			 
			            byte[] buffer = new byte[52428800];
			         
			            int numBytesRead;
			            while ((numBytesRead = in.read(buffer)) > 0) {
			                out.write(buffer, 0, numBytesRead);
			            }
			        }
			 printer.deleteInvoice();
		} catch (SQLException e) {
			e.printStackTrace();
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

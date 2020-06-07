package control.shippingInfo;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ShippingInfo;
import model.dao.ShippingInfoModelDS;

@WebServlet("/shippingInfo/update")
public class UpdateShippingInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateShippingInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShippingInfoModelDS ds= new ShippingInfoModelDS();
		ShippingInfo risposta=new ShippingInfo();
		int id = Integer.parseInt(request.getParameter("id"));	
		String address = request.getParameter("address");		
		String stato = request.getParameter("state");	
		String zip = request.getParameter("zipCode");	
		String city = request.getParameter("city");	
		risposta.setId(id);
		ds.updateAddress(risposta, address);
		ds.updateState(risposta, stato);
		ds.updateZipCode(risposta, zip);
		ds.updateCity(risposta, city);
		response.sendRedirect(request.getContextPath() + "/ShowShippingInfo");


			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id2"));
		ShippingInfoModelDS ds= new ShippingInfoModelDS();
		ShippingInfo bean;

		try {
			bean=ds.getById(id);
			request.setAttribute("update", bean);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/components/pages/user/UpdateShippingInfo.jsp");
			dispatcher.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		




	}

}

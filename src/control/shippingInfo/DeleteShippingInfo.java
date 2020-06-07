package control.shippingInfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ShippingInfoModelDS;

@WebServlet("/shippingInfo/delete")
public class DeleteShippingInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteShippingInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int id = Integer.parseInt(request.getParameter("id"));
		int id=Integer.parseInt(request.getParameter("id"));
		//System.out.println("valore di id : "+id);
		ShippingInfoModelDS shippingInfo = new ShippingInfoModelDS();
		
			shippingInfo.delete(id);
			response.sendRedirect(request.getContextPath() + "/ShowShippingInfo");
	}

}

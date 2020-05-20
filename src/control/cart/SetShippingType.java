package control.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetShippingType
 */
@WebServlet("/cart/setshippingtype")
public class SetShippingType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetShippingType() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            System.out.println(paramName);
            String paramValue = request.getParameter(paramName);
            System.out.println(paramValue);
        }
 		*/
        int id = Integer.parseInt(request.getParameter("shipping_type_id"));

		request.getSession().setAttribute("shipping_type_id", id);
		response.sendRedirect((String) request.getHeader("referer"));
	
		
		

	}

}

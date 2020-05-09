package control.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CustomerModelDs;
import model.dao.ProductModelDS;

/**
 * Servlet implementation class GetUsers
 */
@WebServlet("/users")
public class GetUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerModelDs model;
    public GetUsers() {
        super();
		model = new CustomerModelDs();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Trovo tutti gli utenti ").append(request.getContextPath());
	}

	

}

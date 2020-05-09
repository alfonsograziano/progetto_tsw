package control.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/admin/login")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if(email != null && password != null) {
			if(email.equals(email) && password.equals(password)) {
				request.getSession().setAttribute("isAdmin", new Boolean(true));
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/components/pages/admin/AdminLogin.jsp");
				dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/components/pages/admin/AdminLogin.jsp");
				dispatcher.forward(request, response);
			}	
		}else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/components/pages/admin/AdminLogin.jsp");
			dispatcher.forward(request, response);
		}	
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}

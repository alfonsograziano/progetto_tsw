package control.auth;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.User;
import model.dao.UserModelDS;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/components/pages/auth/Signup.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		//TODO: fai la validazione dei parametri
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setName(name);
		user.setSurname(surname);
		
		//TODO: Usa l'hash della password al posto della password in chiaro per salvare
		//TODO: Prima di eseguire il salvataggio controlla se la mail � gi� stata utilizzata
		UserModelDS userModel = new UserModelDS();
		
		try {
			userModel.add(user);
			response.sendRedirect(request.getContextPath() + "/welcome");
		} catch (SQLException e) {
			response.getWriter().append("Errore nella creazione dell'utente \n"+e);
			e.printStackTrace();
		}
		
		
		
	}

}

package control.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.User;
import model.dao.UserModelDS;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/user/add")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserModelDS model;
	
    public AddUser() {
        super();
		model = new UserModelDS();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO: trova un modo per fare validazione lato server fatta per bene
		//TODO: hasha la password prima di metterla nel customer
		
		//Non li aggiungo direttamente nell'oggetto, perchè dovrei fare la validazione
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		System.out.println("Provo a creare: " + email);
		
		User customer = new User();
		customer.setName(name);
		customer.setSurname(surname);
		customer.setEmail(email);
		customer.setPhone(phone);
		customer.setPassword(password);

		try {
			System.out.println(customer);
			model.add(customer);
			
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			PrintWriter out = response.getWriter();
			out.print("Utente creato");
			out.flush();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			PrintWriter out = response.getWriter();
			out.print("Errore nella creazione dell'utente");
			out.flush();
		}

	}

}

package control.image;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ImageModelDS;

/**
 * Servlet implementation class DeleteImage
 */
@WebServlet("/DeleteImage")
public class DeleteImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteImage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getParameter("image_id");

		int idImmagine=Integer.parseInt(id);
		try {
			ImageModelDS imageModel = new ImageModelDS();
			imageModel.deletePhoto(idImmagine);
			response.sendRedirect((String) request.getHeader("referer"));

			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}

}

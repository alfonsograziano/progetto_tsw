package control.image;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ImageModel;
import model.dao.ImageModelDS;


@WebServlet("/getPicture")
public class GetPicture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetPicture() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getParameter("id");
		int id_foto=Integer.parseInt(id);
		
		ServletOutputStream out = response.getOutputStream();
		
			try {
			ImageModelDS imageModel = new ImageModelDS();
			byte[] bt = imageModel.load(id_foto);			
			if(bt != null)
			{
				out.write(bt);
				response.setContentType("image/jpeg");			
			}
			out.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
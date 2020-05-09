package control.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 * Servlet implementation class provaup
 */
@WebServlet("/provaup")
public class provaup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public provaup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            String savePath = "C:" + File.separator + SAVE_DIR;
                File fileSaveDir=new File(savePath);
                if(!fileSaveDir.exists()){
                    fileSaveDir.mkdir();
                }
            String firstName=request.getParameter("firstname");
            String lastName=request.getParameter("lastname");
            Part part=request.getPart("file");
            String fileName=extractFileName(part);
            /*if you may have more than one files with same name then you can calculate some random characters and append that characters in fileName so that it will  make your each image name identical.*/
            part.write(savePath + File.separator + fileName);
    
    
    }
    }
    
    
    
    
    
    
    
    
    
    
    
}

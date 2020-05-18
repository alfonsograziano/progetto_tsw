package control.image;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.dao.CategoryModelDS;
import model.dao.ImageModelDS;
import model.dao.ProductModelDS;


@WebServlet("/Uploader")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)   // 50MB

public class AddImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private  final String SAVE_DIR="images";
  
  
    public AddImage() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String appPath= request.getServletContext().getRealPath("");
		String id=request.getParameter("product_id");
		System.out.println("id preso da addImage:"+id);
	    String savePath = appPath + File.separator + SAVE_DIR;
	    //System.out.println("path: "+savePath);
	         
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}

		for (Part part : request.getParts()) {
			String fileName = extractFileName(part);
			
			//System.out.println("nome file: "+ fileName);
			
			if (fileName != null && !fileName.equals("")) {
				part.write(savePath + File.separator + fileName);
			
				
				try {
					ImageModelDS imageModel = new ImageModelDS();

					imageModel.updatePhoto(id,savePath+File.separator+fileName);
				} catch (SQLException sqlException) {
					System.out.println(sqlException);
				}
			}
		}
	}

	 private String extractFileName(Part part) {
	        String contentDisp = part.getHeader("content-disposition");
	        String[] items = contentDisp.split(";");
	        for (String s : items) {
	            if (s.trim().startsWith("filename")) {
	                return (s.substring(s.indexOf("=") + 2, s.length()-1));
	            }
	        }
	        return "";
	    }		
}

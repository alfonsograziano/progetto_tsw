package control.image;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.dao.ProductModelDS;


@WebServlet("/Uploader")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)   // 50MB

public class Uploader extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private  final String SAVE_DIR="images";
  
  
    public Uploader() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String appPath= request.getServletContext().getRealPath("");
		String id=request.getParameter("product_id");
		String savePath= appPath+SAVE_DIR;
		File fileSaveDir=new File(savePath);
		if(!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		for(Part part : request.getParts()) {
			String fileName= extractFileName(part);
			if((File.separator).equals("/")) {
				int index=fileName.lastIndexOf("/");
				fileName=fileName.substring(index-1);
			}else if ((File.separator).equals("\\")) {
				int index=fileName.lastIndexOf("\\");
				fileName=fileName.substring(index+1);
			}
			if (fileName!=null && !fileName.equals("")) {
				part.write(savePath+File.separator+fileName);
				
				try {
					ImageModelDS.updatePhoto(id,savePath+File.separator+fileName);
				}
				catch(SLQException e) {			
		}
	
			}
			}}
	
	 private String extractFileName(Part part) {
	        String contentDisp = part.getHeader("content-disposition");
	        String[] items = contentDisp.split(";");
	        for (String s : items) {
	            if (s.trim().startsWith("filename")) {
	                return s.substring(s.indexOf("=") + 2, s.length()-1);
	            }
	        }
	        return "";
	    }		
	
	
	
	
	

}

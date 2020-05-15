package control.admin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Random;

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
	private static final String PATH = "../../../WebContent/assets/img/products/";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public provaup() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    	this.doPost(request, response);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    	try {
		//get the file chosen by the user
		Part filePart = request.getPart("fileToUpload");
		
		//get the InputStream to store the file somewhere
	    InputStream fileInputStream = filePart.getInputStream();
	    Random r = new Random();

	    String alphabet = "abcdefghilmnopqrstuvzxwykj";
	    String random="";
	    
	    for (int i = 0; i < 5; i++) {
	        random = random + alphabet.charAt(r.nextInt(alphabet.length()));
	    }
	    //for example, you can copy the uploaded file to the server
	    //note that you probably don't want to do this in real life!
	    //upload it to a file host like S3 or GCS instead
	    File fileToSave = new File(PATH + random +filePart.getSubmittedFileName());
		Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
    	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    
    
    }
}

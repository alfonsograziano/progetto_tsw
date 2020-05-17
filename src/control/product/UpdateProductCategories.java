package control.product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import model.bean.Category;
import model.dao.BelongsModelDS;

/**
 * Servlet implementation class UpdateProductCategories
 */
@WebServlet("//admin/dashboard/products/update-categories")
public class UpdateProductCategories extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductCategories() {
        super();
        // TODO Auto-generated constructor stub
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fetchedCategories[] =  request.getParameterValues("categories"); //ritorna gli id delle categorie 
		ArrayList<String> categories = new ArrayList<String>(Arrays.asList(fetchedCategories));
		
		int product = Integer.parseInt(request.getParameter("product"));
		//verifico quali categorie ho attualmente nel prodotto
		BelongsModelDS belongsModel = new BelongsModelDS();
		try {
			ArrayList<Category> currentCategories =  belongsModel.getByProduct(product);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

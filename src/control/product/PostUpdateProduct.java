package control.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Belongs;
import model.bean.Category;
import model.bean.Product;

import model.dao.BelongsModelDS;
import model.dao.ProductModelDS;

/**
 * Servlet implementation class PostUpdateProduct
 */
@WebServlet("/admin/dashboard/products/update2")
public class PostUpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostUpdateProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ArrayList<String> categories;
			String[] fetchedCategories = request.getParameterValues("categories");
			if (fetchedCategories != null && fetchedCategories.length > 0) {
				categories = new ArrayList<String>(Arrays.asList(fetchedCategories));
			} else {
				categories = new ArrayList<String>();

			}

			Integer id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			Double price = Double.parseDouble(request.getParameter("price"));
			boolean visible = request.getParameter("visible").equals("true") ? true : false;
			System.out.println(visible);

			Product product = new Product();
			product.setId(id);
			product.setName(name);
			product.setDescription(description);
			product.setPrice(price);
			product.setVisible(visible);

			ProductModelDS productModel = new ProductModelDS();
			BelongsModelDS belongsModel = new BelongsModelDS();
			try {

				// Aggiorno il prodotto
				productModel.update(product);

				// Aggiorno le categorie
				ArrayList<Category> oldCategories = belongsModel.getByProduct(id);
				ArrayList<String> toAdd = findCategoriesToAdd(categories, oldCategories);
				ArrayList<String> toRemove = findCategoriesToRemove(categories, oldCategories);

				// System.out.println(toAdd);
				// System.out.println(toRemove);

				for (int i = 0; i < toAdd.size(); i++) {
					Belongs belongs = new Belongs();
					belongs.setCategory(toAdd.get(i));
					belongs.setProduct(id);
					belongsModel.add(belongs);
				}

				for (int i = 0; i < toRemove.size(); i++) {
					belongsModel.delete(toRemove.get(i), id);
				}

				response.sendRedirect((String) request.getHeader("referer"));

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			response.setStatus(400);
			response.getWriter().append("Errore");
		}
	}

	public ArrayList<String> findCategoriesToRemove(ArrayList<String> categories, ArrayList<Category> oldCategories) {
		ArrayList<String> newc = new ArrayList<String>();

		for (int i = 0; i < oldCategories.size(); i++) {
			boolean find = false;
			for (int j = 0; j < categories.size(); j++) {
				if (categories.get(j).equals(oldCategories.get(i).getId())) {
					find = true;
				}
			}
			if (!find) {
				newc.add(oldCategories.get(i).getId());
			}
		}
		return newc;
	}

	public ArrayList<String> findCategoriesToAdd(ArrayList<String> categories, ArrayList<Category> oldCategories) {
		ArrayList<String> newc = new ArrayList<String>();

		for (int i = 0; i < categories.size(); i++) {
			boolean find = false;
			for (int j = 0; j < oldCategories.size(); j++) {
				if (categories.get(i).equals(oldCategories.get(j).getId())) {
					find = true;
				}
			}
			if (!find) {
				newc.add(categories.get(i));
			}
		}
		return newc;
	}

}

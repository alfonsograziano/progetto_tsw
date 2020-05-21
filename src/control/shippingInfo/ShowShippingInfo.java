package control.shippingInfo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ShippingInfo;
import model.dao.ShippingInfoModelDS;

@WebServlet("/ShowShippingInfo")
public class ShowShippingInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ShowShippingInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getSession().setAttribute("user_id", 1);
		ShippingInfoModelDS shippingInfoModel = new ShippingInfoModelDS();
		int user=(int)request.getSession().getAttribute("user_id");
		try {
			ArrayList<ShippingInfo> ship = shippingInfoModel.getByUser(user);
			for(int i=0; i<ship.size();i++) {
				System.out.println(ship.get(i).getAddress());
			}
			request.setAttribute("shipInfo",shippingInfoModel.getByUser(user));
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/components/pages/user/ShowShippingInfo.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	

}

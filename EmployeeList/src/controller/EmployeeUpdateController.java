package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DB;
import db.DBExceptions;

/**
 * Servlet implementation class EmployeeUpdateController
 */
@WebServlet("/EmployeeUpdate")
public class EmployeeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    DB db;
    String table ="employee";
    String phoneCol = "phone";
    String nameCol = "name";
    String typeCol = "type";
    String emailCol = "email";
    
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		db = new DB("C:\\Users\\kurwhibble\\Documents\\Renrgyx\\Repositories\\OnlineBooks\\BookShopping\\app.properties");
		try {
			db.connect();
		} catch (DBExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("eName");
		String eType = request.getParameter("eType");
		String phone = request.getParameter("ePhone");
		String email = request.getParameter("eEmail");
		HashMap<String, String> hm = new HashMap<String,String>();
		hm.put(nameCol, name);
		hm.put(typeCol, eType);
		hm.put(phoneCol, phone);
		hm.put(emailCol, email);
		
		String message = "";
		try {
			message = db.saveData(table, hm);
			if (message.equalsIgnoreCase("failure")) {
				message = "Employee not saved.";
			} else {
				message = "Employee Saved Successfully";
			}
		} catch (DBExceptions e) {
			// TODO Auto-generated catch block
			message = "Something went wrong.";
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = "Something went wrong.";
			e.printStackTrace();
		}
		
		response.setContentType("text/html");
		response.getWriter().append("<p style='color:red'>" + message + "</p>");
		response.setHeader("Refresh", "3; URL=/EmployeeList/Employee");
	}

}

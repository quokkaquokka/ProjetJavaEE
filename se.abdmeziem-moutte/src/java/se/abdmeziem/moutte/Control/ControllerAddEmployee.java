package se.abdmeziem.moutte.Control;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import se.abdmeziem.moutte.Employee;
import se.abdmeziem.moutte.model.DBActions;
import static se.abdmeziem.moutte.utils.Constantes.*;

/**
 *
 * @author Théo Abdmeziem
 */
public class ControllerAddEmployee extends HttpServlet {
	
	private InputStream input;
    private String dbUrl = "";
    private String dbPwd = "";
    private String dbLogin = "";

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name      = request.getParameter("nameField");
		String firstname = request.getParameter("firstnameField");
		String homePhone = request.getParameter("homePhoneField");
		String mobPhone  = request.getParameter("mobPhoneField");
		String proPhone  = request.getParameter("proPhoneField");
		String address   = request.getParameter("addressField");
		String postcode  = request.getParameter("postcodeField");
		String city      = request.getParameter("cityField");
		String email     = request.getParameter("emailField");
		
		Properties prop = new Properties();
        input = getServletContext().getResourceAsStream("/WEB-INF/db.properties");
        prop.load(input);
        dbUrl= prop.getProperty("dbUrl");
        dbLogin= prop.getProperty("dbUser");
        dbPwd= prop.getProperty("dbPwd");
		
		DBActions dba = new DBActions(dbUrl, dbLogin, dbPwd);
		
		dba.addEmployee(name, firstname, homePhone, mobPhone, proPhone, address, postcode, city, email);
		
		ArrayList<Employee> listEmployees = dba.getEmployees();
		request.setAttribute("klistEmployees", listEmployees);
		//!! à passer en session
		request.setAttribute("krole", "admin");
		request.getRequestDispatcher(JSP_LIST_EMPLOYEE_PAGE).forward(request, response);
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}

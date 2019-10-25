/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.se.abdmeziem.moutte.part2.Model.EmployeeModel;
import com.mycompany.se.abdmeziem.moutte.part2.Classes.Employee;
import static com.mycompany.se.abdmeziem.moutte.part2.Utils.Constantes.JSP_LIST_EMPLOYEE_PAGE;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author QuokkaKoala
 */
public class ControllerAddEmployee extends HttpServlet {

   private InputStream input;

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
        
        EmployeeModel employeeModel = new EmployeeModel(prop);
		
		employeeModel.addEmployee(name, firstname, homePhone, mobPhone, proPhone, address, postcode, city, email);
		
		ArrayList<Employee> listEmployees = employeeModel.getEmployees();
		request.setAttribute("klistEmployees", listEmployees);
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

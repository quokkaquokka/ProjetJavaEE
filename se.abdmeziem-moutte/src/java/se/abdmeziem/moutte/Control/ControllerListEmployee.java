/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.abdmeziem.moutte.Control;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import se.abdmeziem.moutte.Employee;
import se.abdmeziem.moutte.model.DBActions;
import se.abdmeziem.moutte.model.EmployeeModel;
import static se.abdmeziem.moutte.utils.Constantes.*;

/**
 *
 * @author QuokkaKoala
 */

public class ControllerListEmployee extends HttpServlet {
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
		
		Properties prop = new Properties();
		input = getServletContext().getResourceAsStream("/WEB-INF/db.properties");
		prop.load(input);
		EmployeeModel employeeModel = new EmployeeModel(prop);

		String id = request.getParameter("ids");
		
		// to get the details of the selected employee
        if(request.getParameter("details") != null) {
            String[] ids = request.getParameterValues("ids");
            HttpSession session=request.getSession();  
            String role = (String) session.getAttribute("krole");  

            System.out.println("Role " + role);
            
            
            id = "";
            if(ids != null){
                if(ids.length == 1) id = ids[0];
                Employee empl = employeeModel.getEmployee(id);
                request.setAttribute("kEmployee", empl);
                request.getRequestDispatcher(JSP_DETAIL_EMPLOYEE_PAGE).forward(request, response);
            }
            
            // requete

        }
		// to delete the selected employee
		else if(request.getParameter("delete") != null) {
			employeeModel.deleteEmployee(id);

			ArrayList<Employee> listEmployees = employeeModel.getEmployees();
			request.setAttribute("klistEmployees", listEmployees);
			request.getRequestDispatcher(JSP_LIST_EMPLOYEE_PAGE).forward(request, response);
		}
       
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

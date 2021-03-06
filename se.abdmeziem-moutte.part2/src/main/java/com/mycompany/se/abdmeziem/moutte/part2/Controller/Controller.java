/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.se.abdmeziem.moutte.part2.Controller;

import com.mycompany.se.abdmeziem.moutte.part2.Classes.Employees;
import com.mycompany.se.abdmeziem.moutte.part2.Classes.EmployeesSB;
import static com.mycompany.se.abdmeziem.moutte.part2.Utils.Constantes.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Camille Moutte and Theo Abdmeziem
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
    @EJB
    private EmployeesSB employeesSB;

    private HttpSession session;
    private InputStream input;
    
    private String userName = "";
    private String userPwd = "";
    private String adminName ="";
    private String adminPwd = "";
    private String errKey = "";

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
        
        //EmployeeDAO employeeDAO = new EmployeeDAO(prop);
        
        
        // if this is the first time we come here redirect to login page
        if(request.getParameter("action") == null) {
             request.getRequestDispatcher(JSP_HOME_PAGE).forward(request, response);
        } else {
            session = request.getSession();

            String loginInput = request.getParameter("loginField");
            String pwdInput = request.getParameter("pwdField");

            userName = prop.getProperty("userName");
            userPwd = prop.getProperty("userPwd");

            adminName = prop.getProperty("adminName");
            adminPwd = prop.getProperty("adminPwd");

            // check login
            String role = "user";
            if(loginInput.equals(userName) && pwdInput.equals(userPwd)){
                role = "user";
            }
            else
            {
                if(loginInput.equals(adminName) && pwdInput.equals(adminPwd)) {
                    role = "admin";
                    errKey = "";
                }
                else
                    errKey = ERR_CONNECTION;
            }
            if(loginInput.isEmpty() || pwdInput.isEmpty())
                    errKey = ERR_EMPTY_FIELDS;

            // then redirect to the correct page with the correct rights
            if (errKey.isEmpty()) {
                ArrayList<Employees> listEmployees = new ArrayList<>();
                listEmployees.addAll(employeesSB.getEmployees());
                request.setAttribute("klistEmployees", listEmployees);
                session.setAttribute("krole", role);
                request.getRequestDispatcher(JSP_LIST_EMPLOYEE_PAGE).forward(request, response);
            } else {
                request.setAttribute("errKey", errKey);
                request.getRequestDispatcher(JSP_HOME_PAGE).forward(request, response);
            }
                
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

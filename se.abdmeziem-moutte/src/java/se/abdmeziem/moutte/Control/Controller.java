package se.abdmeziem.moutte.Control;

/**
 *
 * @author QuokkaKoala
 */
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
import static se.abdmeziem.moutte.utils.Constantes.*;


/**
 *
 * @author Camille Moutte
 */
public class Controller extends HttpServlet {
	private HttpSession session;
	
    private InputStream input;
    private String dbUrl = "";
    private String dbPwd = "";
    private String dbLogin = "";
    
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
        dbUrl= prop.getProperty("dbUrl");
        dbLogin= prop.getProperty("dbUser");
        dbPwd= prop.getProperty("dbPwd");
        
        

        if(request.getParameter("action") == null) {
             request.getRequestDispatcher(JSP_HOME_PAGE).forward(request, response);
        } else {
			session = request.getSession();
			
			DBActions dba = new DBActions(dbUrl, dbLogin, dbPwd);

			String loginInput = request.getParameter("loginField");
			String pwdInput = request.getParameter("pwdField");

			userName = prop.getProperty("userName");
			userPwd = prop.getProperty("userPwd");

			adminName = prop.getProperty("adminName");
			adminPwd = prop.getProperty("adminPwd");

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
                


            
            if (errKey.isEmpty()) {
                ArrayList<Employee> listEmployees = dba.getEmployees();
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


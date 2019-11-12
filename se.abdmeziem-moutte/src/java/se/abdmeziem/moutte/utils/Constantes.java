package se.abdmeziem.moutte.utils;

/**
 * List of constants needed to the project
 * @author Camille Moutte
 */
public class Constantes {
    public static final String JSP_HOME_PAGE = "WEB-INF/home.jsp";
    public static final String JSP_LIST_EMPLOYEE_PAGE = "WEB-INF/listEmployee.jsp";
    public static final String JSP_DETAIL_EMPLOYEE_PAGE = "WEB-INF/detailsEmployee.jsp";
	public static final String JSP_GOODBYE_PAGE = "WEB-INF/goodbye.jsp";
    
    public static final String SEL_QUERY = "SELECT * from CREDENTIALS";
    public static final String SEL_EMPLOYEES = "SELECT * from EMPLOYEES";
    public static final String SEL_EMPLOYEE = "SELECT * from EMPLOYEES WHERE ID = ";
    public static final String INS_EMPLOYEE = "INSERT INTO EMPLOYEES (NAME,FIRSTNAME,TELHOME,TELMOB,TELPRO,ADRESS,POSTALCODE,CITY,EMAIL) VALUES (?,?,?,?,?,?,?,?,?)";
    public static final String UPD_EMPLOYEE = "UPDATE EMPLOYEES SET NAME = ?, FIRSTNAME = ?, TELHOME = ?, TELMOB = ?, TELPRO = ?, ADRESS = ?, POSTALCODE = ?, CITY = ?, EMAIL = ? WHERE ID = ?";
	public static final String DEL_EMPLOYEE = "DELETE from EMPLOYEES WHERE ID=?";
	
    public static final String ERR_EMPTY_FIELDS = "You must enter values in both fields";
    public static final String ERR_CONNECTION = "Connection failed! Verify your login/password and try again.";
    
}

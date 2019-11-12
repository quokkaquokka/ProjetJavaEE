package se.abdmeziem.moutte.model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import se.abdmeziem.moutte.Employee;
import static se.abdmeziem.moutte.utils.Constantes.DEL_EMPLOYEE;
import static se.abdmeziem.moutte.utils.Constantes.INS_EMPLOYEE;
import static se.abdmeziem.moutte.utils.Constantes.SEL_EMPLOYEE;
import static se.abdmeziem.moutte.utils.Constantes.SEL_EMPLOYEES;
import static se.abdmeziem.moutte.utils.Constantes.UPD_EMPLOYEE;

/**
 *
 * @author QuokkaKoala
 */
public class EmployeeModel {
    
    Connection conn;
    Statement stmt;
    PreparedStatement prepStmt;
    ResultSet rs;
    Employee employee;
    ArrayList<Employee> listEmployees = null;
    DBActions db;
    private InputStream input;
    
    public EmployeeModel(Properties prop){
        String url = prop.getProperty("dbUrl");
        String user = prop.getProperty("dbUser");
        String pwd = prop.getProperty("dbPwd");
        db = new DBActions(url, user, pwd);
    }
    
	/**
	 * get the list of the employees
	 * @return an ArrayList of all the employees
	 */
    public ArrayList<Employee> getEmployees() {
        listEmployees = new ArrayList<>();
        rs = db.getResultSet(SEL_EMPLOYEES);
        try {
            while (rs.next()) {
                Employee employeeBean = new Employee();
                employeeBean.setId(rs.getInt("ID"));
                employeeBean.setName(rs.getString("NAME"));
                employeeBean.setFirstname(rs.getString("FIRSTNAME"));
                employeeBean.setTelHome(rs.getString("TELHOME"));
                employeeBean.setTelMob(rs.getString("TELMOB"));
                employeeBean.setTelPro(rs.getString("TELPRO"));
                employeeBean.setAdress(rs.getString("ADRESS"));
                employeeBean.setPostalCode(rs.getString("POSTALCODE"));
                employeeBean.setCity(rs.getString("CITY"));
                employeeBean.setEmail(rs.getString("EMAIL"));
                listEmployees.add(employeeBean);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listEmployees;
    }
    
	/**
	 * get one specific employee by his id
	 * @param id
	 * @return the employee with this id
	 */
    public Employee getEmployee(String id) {
        Employee employeeBean = new Employee();
        String sql = SEL_EMPLOYEE + id;
        rs = db.getResultSet(sql);
        try {
            if(rs.next()) {
                employeeBean.setId(rs.getInt("ID"));
                employeeBean.setName(rs.getString("NAME"));
                employeeBean.setFirstname(rs.getString("FIRSTNAME"));
                employeeBean.setTelHome(rs.getString("TELHOME"));
                employeeBean.setTelMob(rs.getString("TELMOB"));
                employeeBean.setTelPro(rs.getString("TELPRO"));
                employeeBean.setAdress(rs.getString("ADRESS"));
                employeeBean.setPostalCode(rs.getString("POSTALCODE"));
                employeeBean.setCity(rs.getString("CITY"));
                employeeBean.setEmail(rs.getString("EMAIL"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employeeBean;
    }
	
	/**
	 * Add an employee in the database with the following parameters
	 * @param name
	 * @param firstname
	 * @param homePhone
	 * @param mobPhone
	 * @param proPhone
	 * @param address
	 * @param postcode
	 * @param city
	 * @param email 
	 */
    public void addEmployee(String name, String firstname, String homePhone,
                    String mobPhone, String proPhone, String address, String postcode,
                    String city, String email) {
            prepStmt = db.getPreparedStatement(INS_EMPLOYEE);
            try {
                    prepStmt.setString(1, name);
                    prepStmt.setString(2, firstname);
                    prepStmt.setString(3, homePhone);
                    prepStmt.setString(4, mobPhone);
                    prepStmt.setString(5, proPhone);
                    prepStmt.setString(6, address);
                    prepStmt.setString(7, postcode);
                    prepStmt.setString(8, city);
                    prepStmt.setString(9, email);
        prepStmt.executeUpdate();
    } catch (SQLException sqle) {
        System.out.println(sqle.getMessage());
    }
    }
    
	/**
	 * Update the modifications to an employee using his id
	 * @param id
	 * @param name
	 * @param firstname
	 * @param homePhone
	 * @param mobPhone
	 * @param proPhone
	 * @param address
	 * @param postcode
	 * @param city
	 * @param email 
	 */
    public void udapteEmployee(int id, String name, String firstname, String homePhone,
			String mobPhone, String proPhone, String address, String postcode,
			String city, String email) {
		prepStmt = db.getPreparedStatement(UPD_EMPLOYEE);
		try {
			prepStmt.setString(1, name);
			prepStmt.setString(2, firstname);
			prepStmt.setString(3, homePhone);
			prepStmt.setString(4, mobPhone);
			prepStmt.setString(5, proPhone);
			prepStmt.setString(6, address);
			prepStmt.setString(7, postcode);
			prepStmt.setString(8, city);
			prepStmt.setString(9, email);
            prepStmt.setInt(10, id);
            prepStmt.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
	}
	
	/**
	 * delete an employee using his id
	 * @param id 
	 */
	public void deleteEmployee(String id) {
		prepStmt = db.getPreparedStatement(DEL_EMPLOYEE);

		try {
			prepStmt.setString(1, id);
			prepStmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}

    
}

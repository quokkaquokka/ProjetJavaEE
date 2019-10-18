/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.abdmeziem.moutte.model;

/**
 *
 * @author Camille Moutte
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import se.abdmeziem.moutte.Employee;
import static se.abdmeziem.moutte.utils.Constantes.*;

public class DBActions {

    boolean test = false;
    Connection conn;
    Statement stmt;
    PreparedStatement prepStmt;
    ResultSet rs;
    Employee employee;
    ArrayList<Employee> listEmployees = null;

    public DBActions(String url, String user, String pwd) {
        try {
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public Statement getStatement() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return stmt;
    }
	
	public PreparedStatement getPreparedStatement(String sql) {
        try {
            prepStmt = conn.prepareStatement(sql);
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return prepStmt;
    }

    public ResultSet getResultSet(String sql) {
        stmt = getStatement();
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return rs;

    }
    
    public ArrayList<Employee> getEmployees() {
        listEmployees = new ArrayList<>();
        rs = getResultSet(SEL_EMPLOYEE);
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
	
	public void addEmployee(String name, String firstname, String homePhone,
			String mobPhone, String proPhone, String address, String postcode,
			String city, String email) {
		prepStmt = getPreparedStatement(INS_EMPLOYEE);
		
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
}

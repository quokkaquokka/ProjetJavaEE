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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import se.abdmeziem.moutte.Employee;
import static se.abdmeziem.moutte.utils.Constantes.SEL_EMPLOYEE;

public class DBActions {

    boolean test = false;
    Connection conn;
    Statement stmt;
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
}

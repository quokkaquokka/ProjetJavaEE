/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.se.abdmeziem.moutte.part2.Model;

import com.mycompany.se.abdmeziem.moutte.part2.Classes.Employees;
import static com.mycompany.se.abdmeziem.moutte.part2.Utils.Constantes.DEL_EMPLOYEE;
import static com.mycompany.se.abdmeziem.moutte.part2.Utils.Constantes.INS_EMPLOYEE;
import static com.mycompany.se.abdmeziem.moutte.part2.Utils.Constantes.SEL_EMPLOYEE;
import static com.mycompany.se.abdmeziem.moutte.part2.Utils.Constantes.SEL_EMPLOYEES;
import static com.mycompany.se.abdmeziem.moutte.part2.Utils.Constantes.UPD_EMPLOYEE;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author QuokkaKoala
 */
public class EmployeeDAO {
    Connection conn;
    Statement stmt;
    PreparedStatement prepStmt;
    ResultSet rs;
    Employees employee;
    ArrayList<Employees> listEmployees = null;
    DBActions db;
    private InputStream input;
    
    public EmployeeDAO(Properties prop){
        String url = prop.getProperty("dbUrl");
        String user = prop.getProperty("dbUser");
        String pwd = prop.getProperty("dbPwd");
        db = new DBActions(url, user, pwd);
    }
    
    public ArrayList<Employees> getEmployees() {
        listEmployees = new ArrayList<>();
        rs = db.getResultSet(SEL_EMPLOYEES);
        try {
            while (rs.next()) {
                Employees employeeBean = new Employees();
                employeeBean.setId(rs.getInt("ID"));
                employeeBean.setName(rs.getString("NAME"));
                employeeBean.setFirstname(rs.getString("FIRSTNAME"));
                employeeBean.setTelhome(rs.getString("TELHOME"));
                employeeBean.setTelmob(rs.getString("TELMOB"));
                employeeBean.setTelhome(rs.getString("TELPRO"));
                employeeBean.setAdress(rs.getString("ADRESS"));
                employeeBean.setPostalcode(rs.getString("POSTALCODE"));
                employeeBean.setCity(rs.getString("CITY"));
                employeeBean.setEmail(rs.getString("EMAIL"));
                listEmployees.add(employeeBean);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listEmployees;
    }
    
    public Employees getEmployee(String id) {
        Employees employeeBean = new Employees();
        String sql = SEL_EMPLOYEE + id;
        rs = db.getResultSet(sql);
        try {
            if(rs.next()) {
                employeeBean.setId(rs.getInt("ID"));
                employeeBean.setName(rs.getString("NAME"));
                employeeBean.setFirstname(rs.getString("FIRSTNAME"));
               employeeBean.setTelhome(rs.getString("TELHOME"));
                employeeBean.setTelmob(rs.getString("TELMOB"));
                employeeBean.setTelhome(rs.getString("TELPRO"));
                employeeBean.setAdress(rs.getString("ADRESS"));
                employeeBean.setPostalcode(rs.getString("POSTALCODE"));
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

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

	/**
	 * get a Statement to do SELECT on the database
	 * @return a Statement to read the database
	 */
    public Statement getStatement() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return stmt;
    }
	
	/**
	 * get a PreparedStatement to do INSERT, UPDATE or DELETE on the database
	 * @param sql the sql query to prepare
	 * @return a PreparedStatement to update the database
	 */
	public PreparedStatement getPreparedStatement(String sql) {
        try {
            prepStmt = conn.prepareStatement(sql);
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return prepStmt;
    }

	/**
	 * get the ResultSet from an sql query
	 * @param sql query to execute
	 * @return the ResultSet corresponding to the result of the query
	 */
    public ResultSet getResultSet(String sql) {
        stmt = getStatement();
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return rs;

    }
    
    }

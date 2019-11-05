/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.se.abdmeziem.moutte.part2.Utils;

/**
 *
 * @author Camille Moutte and Theo Abdmeziem
 */
public class Constantes {
    public static final String JSP_HOME_PAGE = "WEB-INF/home.jsp";
    public static final String JSP_LIST_EMPLOYEE_PAGE = "WEB-INF/listEmployee.jsp";
    public static final String JSP_DETAIL_EMPLOYEE_PAGE = "WEB-INF/detailsEmployee.jsp";
    public static final String JSP_GOODBYE_PAGE = "WEB-INF/goodbye.jsp";
    
    public static final String SEL_EMPLOYEES = "SELECT e FROM Employees e";
    public static final String SEL_EMPLOYEE = "SELECT e FROM Employees e WHERE e.id = :id";
    public static final String INS_EMPLOYEE = "INSERT INTO EMPLOYEES (NAME,FIRSTNAME,TELHOME,TELMOB,TELPRO,ADRESS,POSTALCODE,CITY,EMAIL) VALUES (?,?,?,?,?,?,?,?,?)";
    public static final String UPD_EMPLOYEE = "UPDATE Employees SET name = :n, firstname = :f, telhome = :th, telmob = :tm, telpro = :tp, adress = :a, postalcode = :p, city = :c, email = :em WHERE id = :id";
	public static final String DEL_EMPLOYEE = "DELETE FROM Employees e WHERE e.id = :id";
	
    public static final String ERR_EMPTY_FIELDS = "You must enter values in both fields";
    public static final String ERR_CONNECTION = "Connection failed! Verify your login/password and try again.";
    
}

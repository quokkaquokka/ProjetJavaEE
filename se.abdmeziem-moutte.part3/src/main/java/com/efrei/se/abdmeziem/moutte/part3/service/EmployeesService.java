/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efrei.se.abdmeziem.moutte.part3.service;

import com.efrei.se.abdmeziem.moutte.part3.model.Employees;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
 
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author QuokkaKoala
 */

public interface EmployeesService {
    public Response addEmployees(String data);
    public Response deleteEmployees(String data);
    public Response getEmployees(String id);
    public Response getAllEmployees();
    public Response updateEmployees(String employeeID);
    
   
    
    
    
}

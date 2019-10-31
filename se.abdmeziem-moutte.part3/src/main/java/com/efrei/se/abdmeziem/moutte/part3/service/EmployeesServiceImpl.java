/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efrei.se.abdmeziem.moutte.part3.service;

import com.algolia.search.DefaultSearchClient;
import com.efrei.se.abdmeziem.moutte.part3.model.Employees;
import com.algolia.search.SearchClient;
import com.algolia.search.SearchIndex;
import static com.efrei.se.abdmeziem.moutte.part3.utils.Constants.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author QuokkaKoala
 */
@Path("/employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeesServiceImpl implements EmployeesService {
    
    @Override
    @POST
    @Path("/add")
    public void addEmployees(){
     
        SearchClient client = DefaultSearchClient.create(DB_ADMIN, DB_ADMIN_KEY);
        SearchIndex<Employees> index = client.initIndex("Employees", Employees.class);

    }
    
    @Override
    @GET
    @Path("/getAll")
    @Produces("application/json")
    public String getAllEmployees(){
         //SearchClient client = DefaultSearchClient.create(DB_ADMIN, DB_ADMIN_KEY);
        //SearchIndex<Employees> index = client.initIndex("Employees", Employees.class);
        // System.out.print("Employess: " + index);
        return "Toto";
        //SearchIndex<Employees> result = index.search(new Query("jimmie"));
    }

    @Override
    public void deleteEmployees() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getEmployees() {
       
    }
    
}

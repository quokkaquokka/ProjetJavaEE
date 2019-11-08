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
import com.algolia.search.models.RequestOptions;
import com.algolia.search.models.indexing.Query;
import com.algolia.search.models.indexing.SearchResult;
import static com.efrei.se.abdmeziem.moutte.part3.utils.Constants.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    @Path("add")
    public void addEmployees(){
     
        SearchClient client = DefaultSearchClient.create(DB_ADMIN, DB_ADMIN_KEY);
        SearchIndex<Employees> index = client.initIndex("Employees", Employees.class);

    }
    
    @Override
    @GET
    @Path("getAll")
    @Produces("application/json")
    public Response getAllEmployees(){
        System.out.print(" API : getAll" );
        SearchClient client = DefaultSearchClient.create(DB_ADMIN, DB_ADMIN_KEY);
        SearchIndex<Employees> index = client.initIndex("employees", Employees.class);
        SearchResult<Employees> allEmployees = index.search(new Query());
        System.out.print("Employess: " + allEmployees);
        // "{\"name\": \"Toto\", \"klist\":[\"tata\", \"kiki\", \"kuku\"]}"
        return Response.ok(allEmployees).build();
        //SearchIndex<Employees> result = index.search(new Query("jimmie"));
    }

    @Override
    @GET
    @Path("delete/{objectID}")
    @Consumes("application/json")
    @Produces("text/plain")
    public Response deleteEmployees(@PathParam("objectID") String id) {
        id = id.substring(1, id.length() - 1);
        System.out.print("API : delete + " + id);
        SearchClient client = DefaultSearchClient.create(DB_ADMIN, DB_ADMIN_KEY);
        SearchIndex<Employees> index = client.initIndex("employees", Employees.class);
        
        try{
           index.deleteObject(id);
           return Response
            .ok("ok")
            .build();
        }
        catch(Exception e) {
            System.out.print(e);
            return Response
            .ok("ko")
            .build();
        }
    }

    @Override
    @GET
    @Path("get/{objectID}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getEmployees(@PathParam("objectID") String id) {
        System.out.print("API : get + " + id );
        id = id.substring(1, id.length() - 1);
        System.out.print(id.substring(1, id.length() - 1));
        SearchClient client = DefaultSearchClient.create(DB_ADMIN, DB_ADMIN_KEY);
        SearchIndex<Employees> index = client.initIndex("employees", Employees.class);
        SearchResult<Employees> employees = index.search(new Query()
         .setFilters("objectID:'" + id + "'"));
        System.out.print("Employess: " + employees);
        return Response.ok(employees).build();
       
    }
    
}

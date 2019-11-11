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
import com.efrei.se.abdmeziem.moutte.part3.model.EmployeesWithoutID;
import static com.efrei.se.abdmeziem.moutte.part3.utils.Constants.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;
/**
 *
 * @author Camille Moutte
 */
@Path("/employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeesServiceImpl implements EmployeesService {
    
    @Override
    @POST
    @Path("add")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("text/plain")
    public Response addEmployees(String data) {
        Map<String, String> dataMap = EmployeesServiceImpl.getQueryMap(data);
        Employees employees = new Employees();
        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            String key = entry.getKey();
            String val =  entry.getValue();
            switch(key) {
                case "name":
                    employees.setName(val);
                    break;                
                case "adress":
                    employees.setAdress(val);
                    break;
                case "city":
                    employees.setCity(val);
                    break;
                case "email":
                    employees.setEmail(val);
                    break;
                case "firstname":
                    employees.setFirstname(val);
                    break;
                case "postalcode":
                    employees.setPostalcode(val);
                    break;
                case "telhome":
                    employees.setTelhome(val);
                    break;
                case "telmob":
                    employees.setTelmob(val);
                    break;
                case "telpro":
                    employees.setTelpro(val);
                    break;
                
                default:
                    System.out.println(key + "Not found in switch case !!!!");
            }
	}
       
        SearchClient client = DefaultSearchClient.create(DB_ADMIN, DB_ADMIN_KEY);
        SearchIndex<Employees> index = client.initIndex("employees", Employees.class);
        try {        
              UUID uuid = UUID.randomUUID();
              String randomUUIDString = uuid.toString();
              employees.setObjectID(randomUUIDString);
              index.saveObject(employees).waitTask();
            return Response.ok("Ok").build();
        } catch(Error error) {
            System.err.println("ERRROOOOOOOOOOOOOOOOOOOOOOOOOOOOR" + error);
            return Response.ok("kO").build();
            
        }
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
        return Response.ok(allEmployees).build();
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
    
    public static Map<String, String> getQueryMap(String query)
    {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<>();
        for (String param : params)
        {
            String name = param.split("=")[0];
            String value = URLDecoder.decode(param.split("=")[1]);
            map.put(name, value);
        }
        return map;
    }    
    
    
    @Override
    @POST
    @Path("update")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("text/plain")
    public Response updateEmployees(String data) {
        System.out.print("DATA" + data);
        Map<String, String> dataMap = EmployeesServiceImpl.getQueryMap(data);
        Employees employees = new Employees();
        System.out.print(dataMap.values());
  
        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            String key = entry.getKey();
            String val =  entry.getValue();
            switch(key) {
                case "name":
                    employees.setName(val);
                    break;
                case "objectID":
                    employees.setObjectID(val);
                    break;                
                case "adress":
                    employees.setAdress(val);
                    break;
                case "city":
                    employees.setCity(val);
                    break;
                case "email":
                    employees.setEmail(val);
                    break;
                case "firstname":
                    employees.setFirstname(val);
                    break;
                case "postalcode":
                    employees.setPostalcode(val);
                    break;
                case "telhome":
                    employees.setTelhome(val);
                    break;
                case "telmob":
                    employees.setTelmob(val);
                    break;
                case "telpro":
                    employees.setTelpro(val);
                    break;
                
                default:
                    System.out.println(key + " not found in switch case. noobbb !!!!");
            }
	}
        
        
        System.out.print(employees.getName()+ " " + employees.getFirstname());
        SearchClient client = DefaultSearchClient.create(DB_ADMIN, DB_ADMIN_KEY);
        SearchIndex<Employees> index = client.initIndex("employees", Employees.class);
        try {        
            index.saveObject(employees).waitTask();
            //index.partialUpdateObject(employees);
            return Response.ok("Ok").build();
        } catch(Error error) {
            System.err.println("ERRROOOOOOOOOOOOOOOOOOOOOOOOOOOOR" + error);
            return Response.ok("kO").build();
            
        }
        // return Response.ok("Ok").build();
    }

    
}

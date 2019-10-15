<%-- 
    Document   : listEmployee
    Created on : 15 oct. 2019, 10:21:14
    Author     : QuokkaKoala
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="se.abdmeziem.moutte.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body style="width:500px;">
        <% 
           ArrayList<Employee> listEmployees = (ArrayList<Employee>) request.getAttribute("klistEmployees");
           pageContext.setAttribute("listEmployees", listEmployees);
           if(listEmployees.size() == 0) {
               %>
               <div class="alert alert-danger">The company are no employee</div>
               <%
           }
         
        %>
    
     <table class="table">
        <thead>
            <tr>
                <th>Details</th>
                <th>Name</th>
                <th>Firstname</th>
                <th>Phone Home</th>
                <th>Phone Mobile</th>
                <th>Phone Pro</th>
                <th>Adress</th>
                <th>Postal code</th>
                <th>City</th>
                <th>email</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${listEmployees}">
            <tr>
                <td><input type="radio" name="employeeDetails" id="ids" value="<c:out value="${employee.id}"> </c:out>" checked></td>
                <td> <c:out value="${employee.name}"/></td>
                <td> <c:out value="${employee.firstname}"/></td>
                <td> <c:out value="${employee.telHome}"/></td>
                <td> <c:out value="${employee.telMob}"/></td>
                <td> <c:out value="${employee.telPro}"/></td>
                <td> <c:out value="${employee.adress}"/></td>
                <td> <c:out value="${employee.postalCode}"/></td>
                <td> <c:out value="${employee.city}"/></td>
                <td> <c:out value="${employee.email}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
        
         <form  name='myform' action="ControllerListEmployee">
            <button type="submit" name="delete" class="btn btn-danger"> Delete</button>
            <button type="submit" name="details" value='ok' class="btn btn-info"> Details</button>
            <button type="submit" name="add" class="btn btn-primary"> Add</button>
            
        </form>
        
    </body>
</html>

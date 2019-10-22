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
		<!--bootstrap-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <% 
           ArrayList<Employee> listEmployees = (ArrayList<Employee>) request.getAttribute("klistEmployees");
           pageContext.setAttribute("listEmployees", listEmployees);
           if(listEmployees.size() == 0) {
               %>
               <div class="alert alert-danger">The company are no employee</div>
               <%
           }
		   
		    String role = (String) session.getAttribute("krole");
        %>
		
		<form  name='myform' action="ControllerListEmployee">
			<table class="table">
				<thead>
					<tr>
						<th>Details</th>
						<th>Name</th>
						<th>Firstname</th>
						<th>Phone Home</th>
						<th>Phone Mobile</th>
						<th>Phone Pro</th>
						<th>Address</th>
						<th>Postal code</th>
						<th>City</th>
						<th>email</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="employee" items="${listEmployees}">
					<tr>
						<td><input type="radio" name="ids" id="ids" value="<c:out value="${employee.id}"> </c:out>" checked></td>
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
			
			<div class="ml-2">
			<% if(role.equals("admin") ) { %>
				<button type="button" name="delete" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">Delete</button>
			<% } %>
                            <input type="submit" name="details" class="btn btn-info" value="Details">
			<% if(role.equals("admin") ) { %>
                            <button type="button" name="add" class="btn btn-primary" data-toggle="modal" data-target="#addModal">Add</button>
			<% } %>
			</div>
        </form>
        
		<!-- delete modal -->
		<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="deleteModalTitle">Confirm delete</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-footer">
						<form>
							<input type="submit" class="btn btn-danger" value="Confirm">
						</form>
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
					</div>
				</div>
			</div>
		</div>
		
		<!-- add modal -->
		<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="addModalTitle">Add an employee</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<form action="ControllerAddEmployee" method="post">
						<div class="modal-body">
							Name: <input type='text' name='nameField' class="form-control" required>
							Firstname: <input type='text' name='firstnameField' class="form-control" required>
							Home Phone: <input type='text' name='homePhoneField' class="form-control" required>
							Mobile Phone: <input type='text' name='mobPhoneField' class="form-control" required>
							Professional Phone: <input type='text' name='proPhoneField' class="form-control" required>
							Address: <input type='text' name='addressField' class="form-control" required>
							Postcode: <input type='text' name='postcodeField' class="form-control" required>
							City: <input type='text' name='cityField' class="form-control" required>
							Email: <input type='text' name='emailField' class="form-control" required>
						</div>
						<div class="modal-footer">
							<input type="submit" class="btn btn-primary" value="Save">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		
    </body>
</html>

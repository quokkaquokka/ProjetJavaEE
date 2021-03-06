<%-- 
    Document   : detailsEmployee
    Created on : 25 oct. 2019, 10:00:48
    Author     : Camille Moutte and Theo Abdmeziem
--%>

<%@page import="com.mycompany.se.abdmeziem.moutte.part2.Classes.Employees"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Font awesome -->
        <script src="https://kit.fontawesome.com/a7b762916d.js" crossorigin="anonymous"></script>
        <!--bootstrap-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		
        <title>Employee Details Page</title>
    </head>
    <body>
        <c:if test="${empty kEmployee}">
            <div class="alert alert-danger">The employee doesn't exist.</div>
        </c:if>
        <form name='loggout' action="ControllerDetailEmployee" class="float-right">
            <input type='submit' name='logout' value='Logout' class="btn btn-primary">
        </form>
        <div class="card" style="width: 800px">
            <div class="card-header">
                <h5 class="card-title">Details of Employee: ${kEmployee.firstname} ${kEmployee.name}</h5>
            </div>
            <div class="card-body">
                <form  name='myform' action="ControllerDetailEmployee">
                    <table class="">
                    <tbody>
                         <tr>
                            <td>ID</td>
                             <td><input type="text" name="id" value="${kEmployee.id}" class="form-control" readonly /></td>
                        </tr>
                        <tr>
                            <td>Name *</td>
                            <td><input type="text" name="name" value="${kEmployee.name}" class="form-control" ${isAdmin} required/></td>
                            
                        </tr>
                        <tr>
                            <td>Firstname *</td>
                            <td><input type="text" name="firstname" value="${kEmployee.firstname}" class="form-control" ${isAdmin} required/></td>
                        </tr>
                        <tr>
                            <td>Phone Home</td>
                            <td><input type="text" name="phonHome" value="${kEmployee.telhome}" class="form-control" ${isAdmin}/></td>
                        </tr>
                        <tr>
                            <td>Phone Mobile</td>
                            <td><input type="text" name="phonMob" value="${kEmployee.telmob}" class="form-control" ${isAdmin}/></td>
                        </tr>
                        <tr>
                            <td>Phone Pro</td>
                            <td><input type="text" name="phonPro" value="${kEmployee.telpro}" class="form-control" ${isAdmin}/></td>
                        </tr>
                        <tr>
                            <td>Address</td>
                            <td><input type="text" name="adress" value="${kEmployee.adress}" class="form-control" ${isAdmin}/></td>
                        </tr>
                        <tr>
                            <td>Postal code</td>
                            <td><input type="text" name="postCode" value="${kEmployee.postalcode}" class="form-control" ${isAdmin}/></td>
                        </tr>
                        <tr>
                            <td>City</td>
                            <td><input type="text" name="city" value="${kEmployee.city}" class="form-control" ${isAdmin}/></td>
                            <td>email *</td>
                            <td><input type="email" name="email" value="${kEmployee.email}" class="form-control" ${isAdmin} required/></td>
                        </tr>
                        <tr>
                            
                        </tr>
                </tbody>
               </table>    
                <c:if test="${krole == 'admin'}">
                    <input type='submit' name='update' value="Save" class="btn btn-primary">
                </c:if>
					<input type='submit'name="cancel" value="Cancel" class="btn btn-outline-primary float-right">
                </form>
            </div>
			
        </div>
        
    </body>
</html>

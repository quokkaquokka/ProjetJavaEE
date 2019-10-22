<%-- 
    Document   : detailsEmployee
    Created on : 15 oct. 2019, 11:20:12
    Author     : QuokkaKoala
--%>
<%@page import="se.abdmeziem.moutte.Employee"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
          Employee empl = (Employee) request.getAttribute("kEmployee");
           pageContext.setAttribute("employee", empl);
           pageContext.setAttribute("isAdmin", "disabled");
           
           String role = (String) session.getAttribute("krole");
           String disableInput = "";
           if(role.equals("admin"))
             disableInput = "";
           else
             disableInput = "disabled";
           
           pageContext.setAttribute("isAdmin", disableInput);
           
           if(empl == null) {
               %>
               <div class="alert alert-danger">The employee doesn't exist. </div>
               <%
           }
        %>
        <div class="card" style="width: 500px">
            <div class="card-header">
                <h5 class="card-title">Employee detail</h5>
            </div>
            <div class="card-body">
                <form  name='myform' action="ControllerDetailEmployee">
                    <table class="table">
                    <tbody>
                         <tr>
                            <td>ID</td>
                             <td><input type="text" name="id" value="<c:out value="${employee.id}" />" class="form-control" readonly/></td>
                        </tr>
                        <tr>
                            <td>Name</td>
                             <td><input type="text" name="name" value="<c:out value="${employee.name}" />" class="form-control" <c:out value="${isAdmin}" />/></td>
                        </tr>
                        <tr>
                            <td>Firstname</td>
                            <td><input type="text" name="firstname" value="<c:out value="${employee.firstname}"/>" class="form-control" <c:out value="${isAdmin}" />/></td>
                            
                        </tr>
                        <tr>
                            <td>Phone Home</td>
                            <td><input type="text" name="phonHome" value="<c:out value="${employee.telHome}"/>" class="form-control" <c:out value="${isAdmin}" />/></td>
                        </tr>
                        <tr>
                            <td>Phone Mobile</td>
                            <td><input type="text" name="phonMob" value="<c:out value="${employee.telMob}"/>" class="form-control" <c:out value="${isAdmin}" />/></td>
                        </tr>
                        <tr>
                            <td>Phone Pro</td>
                            <td><input type="text" name="phonPro" value="<c:out value="${employee.telPro}"/>" class="form-control" <c:out value="${isAdmin}" />/></td>
                        </tr>
                        <tr>
                            <td>Address</td>
                            <td><input type="text" name="adress" value="<c:out value="${employee.adress}"/>" class="form-control" <c:out value="${isAdmin}" />/></td>
                        </tr>
                        <tr>
                            <td>Postal code</td>
                            <td><input type="text" name="postCode" value="<c:out value="${employee.postalCode}"/>" class="form-control" <c:out value="${isAdmin}" />/></td>
                        </tr>
                        <tr>
                            <td>City</td>
                            <td><input type="text" name="city" value="<c:out value="${employee.city}"/>" class="form-control" <c:out value="${isAdmin}" />/></td>
                        </tr>
                        <tr>
                            <td>email</td>
                            <td><input type="text" name="email" value="<c:out value="${employee.email}"/>" class="form-control" <c:out value="${isAdmin}" />/></td>
                        </tr>
                </tbody>
               </table>
                        
               <%
                    if(role.equals("admin")) { %>
                        <input type='submit' name='update' class="btn btn-primary"> <%
                    }
                %>
               
                </form>
            </div>
        </div>
        
    </body>
</html>

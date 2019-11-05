<%-- 
    Document   : home
    Created on : 25 oct. 2019, 09:34:38
    Author     : Camille Moutte and Theo Abdmeziem
--%>

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
		
        <title>JSP Page</title>
    </head>
    <body>
         <div class="card mx-auto mt-5" style="max-width: 500px;">
            <div class="card-header">
                 Login
            </div>
             <div class="card-body">
                <form>
                    <c:if test="${!empty errKey}">
                        <div class="alert alert-danger">${errKey}</div>
                    </c:if>
                    
                    Login :<input type='text' name='loginField' class="form-control"><br/>
                    Password :<input type='password' name='pwdField' class="form-control"><br/>
                    <input type='submit' name='action' value='Login' class="btn btn-primary">
                </form>
             </div>
         </div>
    </body>
</html>

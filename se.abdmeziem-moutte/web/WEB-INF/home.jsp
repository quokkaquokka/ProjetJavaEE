<%-- 
    Document   : home
    Created on : 15 oct. 2019, 09:34:33
    Author     : QuokkaKoala
--%>

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
         <div class="card w-25 mx-auto mt-5">
            <div class="card-header">
                 Login
            </div>
             <div class="card-body">
                <form>
                    <% if(request.getAttribute("errKey") != null) { %>
                    <div class="alert alert-danger">${errKey}</div>
                    <% } %>
                    
                    Login :<input type='text' name='loginField' class="form-control"><br/>
                    Password :<input type='password' name='pwdField' class="form-control"><br/>
                    <input type='submit' name='action' value='Login' class="btn btn-primary">
                </form>
             </div>
             
             
         </div>
         
    </body>
</html>

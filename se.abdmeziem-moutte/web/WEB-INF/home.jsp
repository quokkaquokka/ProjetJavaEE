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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body style="width:500px;">
        <h1>Hello World!</h1>
         <div class="card">
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

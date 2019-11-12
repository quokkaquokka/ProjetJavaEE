<%-- 
    Document   : goodbye
    Created on : 31 oct. 2019, 19:19:44
    Author     : QuokkaKoala
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Font awesome -->
        <script src="https://kit.fontawesome.com/a7b762916d.js" crossorigin="anonymous"></script>
		<!--bootstrap-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 class="m-2">Goodbye!</h1>
		<form action="Controller">
			<button type="submit" name='logout' class="btn btn-primary m-2" ><i class="fas fa-home"></i> Return home</button>
		</form>
    </body>
</html>

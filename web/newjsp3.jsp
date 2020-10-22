<%-- 
    Document   : newjsp3
    Created on : 1 mars 2020, 14:44:50
    Author     : palaye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>BIENVENU!</h1>
        
        <mark>  ${login} </mark> <h2> AUTHENTIFICATION REUSSIE </h2> 
        
        <div class="container" id="principal2">
	
	<CENTER>

            <center><div class="ab1"><a href="<c:url value="/test2"></c:url>" >  LIste des clients </b></a></div></center>
 
	<center><div class="ab1"><a href="<c:url value="/test3"></c:url>" >  INSCRIPTION  </b></a></div></center>
 
	<center><div class="ab1"><a href="<c:url value="/test2"></c:url>" > MOdifier </b></a></div></center>

	<center><div class="ab1"><a href="<c:url value="/test2"></c:url>" > SUPPRIMER </b></a></div></center>
	


</div>

	<br><center><div class="ab"><a href="deconnexion.php" ><b>Deconnexion</b></a></div></center>
        
        </center>
        
    </body>
</html>

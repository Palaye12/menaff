<%-- 
    Document   : newjsp2
    Created on : 20 févr. 2020, 18:33:07
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
        <h1>Hello World!</h1>
        
              <center>
             <h2>liste des utilisateurs </h2>
  <table class="table table-hover"  border="2px " width="300px" height="100px">
    <thead>
      <tr>
        <th>id</th>
        
        <th>Prenom</th>
		<th>nom</th>
                
		<th>telephone</th>
		
       
      </tr>
    </thead>
    <tbody>
        <tr>
          <c:forEach items="${users}" var="r">
            
       
	
          <TH><c:out value="${r.id}" /> </TH> 
	 <TH><c:out value="${r.prenom}"/> </TH>
	 <TH><c:out value="${r.nom}" /> </TH>
	 <TH><c:out value="${r.telephone}" /> </TH>
					   
                   
				 
	</tr>			     
 </c:forEach>
    
    </tbody>
  </table>
</center>
    </body>
</html>

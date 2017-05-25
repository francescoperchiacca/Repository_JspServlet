<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage = "true" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  
    PAGINA DI ERRORE<br>
    
       <% if (request.getAttribute("error") == null || request.getAttribute("error") == "") {
        	// request.getAttribute("error");
	  		   out.println("Campo vuoto. Devi inserire qualcosa!!!");
	 	   	   session.removeAttribute("error");
	   	   }else if (request.getAttribute("error") != null || request.getAttribute("error") != "") {
        	 //  request.getAttribute("error");
	  		   out.println("valore inserito!!!");
	 	   	   session.removeAttribute("error");
	   	   }
	    %>
  </body>
</html>

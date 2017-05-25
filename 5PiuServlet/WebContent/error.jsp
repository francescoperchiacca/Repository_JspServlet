<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage = "true" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  
    PAGINA DI ERRORE<br>
    
       <% if (request.getAttribute("notificaStato") != null || request.getAttribute("notificaStato") != "ErrorValidazione") {
    	   out.println("Notificazione: " );   
    	   out.println("Campo vuoto. Devi inserire qualcosa!!!");
	 	   	   session.removeAttribute("notificaStato");
	   	   }else if (request.getAttribute("notificaStato") == null || request.getAttribute("notificaStato") == "ok") {
        	 //  request.getAttribute("error");
	  		   out.println("valore inserito!!!");
	 	   	   session.removeAttribute("notificaStato");
	   	   }
	    %>
  </body>
</html>

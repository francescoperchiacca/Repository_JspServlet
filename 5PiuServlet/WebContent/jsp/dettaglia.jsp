<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="servlet.LeggiTuttoServlet"%>
<%@page import="servlet.Tabella"%>
<%@ page errorPage ="./error.jsp" %>


<html>
 <head>
		
  </head>
<body> 
	<form method="post" name="form" action="../DettagliaServlet">
	 <%
		ArrayList<Tabella> miaLista = new ArrayList<Tabella>();
		miaLista =  (ArrayList<Tabella>)session.getAttribute("lista");
	 %>
		
		  
				<%
					   Iterator<Tabella> it = miaLista.iterator();
					   while (it.hasNext()){
					   Tabella t = it.next();
				%>
		   
		     	<input type="text" value="<%=t.getId()%>" disabled="disabled"/> <br></br>
		     
		        <input type="text" value="<%=t.getDescrizione()%>" disabled="disabled"/> 
		    
		      	
			       <%
	  	   	}
	  	   %>
	  	   
	 	
    </form>	
  </body>
</html>

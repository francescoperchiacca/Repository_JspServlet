<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="servlet.LeggiTuttoServlet"%>
<%@page import="servlet.Tabella"%>
<%@ page errorPage ="./error.jsp" %>


<html>
 <head>
		
  </head>
<body> 
	<form method="post" name="form" action="/5PiuServlet/DettagliaServlet">
	 <%
		ArrayList<Tabella> miaLista = new ArrayList<Tabella>();
		miaLista =  (ArrayList<Tabella>)session.getAttribute("lista");
	 %>
		<table border="1">
		  	<tr>
		  		<td>ID</td>
		        <td>DESCRIZIONE</td>
		        <td>Operazioni</td>
		  	</tr>
				<%
					   Iterator<Tabella> it = miaLista.iterator();
					   while (it.hasNext()){
					   Tabella t = it.next();
				%>
		   <tr>
		     <td>
		     	<%=t.getId()%> 
		     </td>
		     <td>
		        <%=t.getDescrizione()%> 
		     </td>  
		      <td>
			        Dettaglia<input type="checkbox" name="op1" value="<%=t.getId()%>" />
			        Modifica<input type="checkbox" name="op2" value="<%=t.getId()%>"/>
			        Elimina<input type="checkbox" name="op3" value="<%=t.getId()%>"/>
		     </td> 
		   </tr><%
	  	   	}
	  	   %>
	  	   <tr>
	  	   	<td></td>
	  	   	<td></td>
	  	   	<td><input type="submit" name="esegui" value="Esegui"></input></td>
	  	   </tr>
	 	</table>
	 	
    </form>	
  </body>
</html>

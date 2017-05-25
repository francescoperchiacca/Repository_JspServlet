<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage = "true" %>
<%@ page errorPage = "error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	 
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="Pagina di Login">
		
		<title>Insert title here</title>
	</head>
	<body>
		<form method="post" name="form" action="../4InserisciServlet/MiaServlet">
	    	<input type="text" name="descrizione"/>
	    	<input type="submit" value="inserisci"/> 
	    	
		</form>
		<a href="../4InserisciServlet/MiaServlet?descrizione=xxx">passare parametri a servlet con link</a>
	</body>
		

</html>
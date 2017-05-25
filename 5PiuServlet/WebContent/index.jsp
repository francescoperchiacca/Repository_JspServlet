<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<html>
	<head>
	</head>
	<body>
		<form method="post" name="form1" action="../5PiuServlet/InserisciServlet">
	    	<input type="text" name="descrizione"/>
	    	<input type="submit" value="Inserisci"/> 	
		</form>
		<form method="post" name="form2" action="../5PiuServlet/LeggiTuttoServlet">
	    	<input type="submit" value="Visualizza"/> 	
		</form>
		<form method="post" name="form3" action="../5PiuServlet/CercaServlet">
			<input type="text" name="descrizione"/>
	    	<input type="submit" value="Cerca"/> 	
		</form>
		
	</body>
	
</html>
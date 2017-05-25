package pak;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

public class MiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public MiaServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String valoreRichiesto = request.getParameter("descrizione");
	//	
		String rispostaPagina = "../4InserisciServlet/error.jsp";
		
		if(valoreRichiesto == "" || valoreRichiesto == null){
			
			request.setAttribute("error", valoreRichiesto);
			response.sendRedirect(rispostaPagina);
		}
		else{
	    rispostaPagina = "../4InserisciServlet/index.jsp";
		System.out.println("Faccio fare una connessione al database inserendo delle info nel database");
		Connection con = null;
		Statement st = null;
		try {
			// Carichiamo un driver di tipo 1 (bridge jdbc-odbc)
			String driver = "com.mysql.jdbc.Driver";
			try {
				Class.forName(driver);
			} 
			catch (ClassNotFoundException e) {
				System.out.println("Manca il driver!!!");
				e.printStackTrace();
			}
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/framar";
			// Otteniamo una connessione con username e password
			con = DriverManager.getConnection (url, "francesco", "");
			// Creiamo un oggetto Statement per poter interrogare il db
		
			// Eseguiamo una query e immagazziniamone i risultati
			// in un oggetto ResultSet
		
		String sql = "insert into regione (descrizione) VALUES ('"+valoreRichiesto+"')" ;
		try { 
		  
		   System.out.println("hai inserito regione: " + valoreRichiesto);
		   st = con.createStatement(); 
		   st.execute(sql);
		   System.out.println(sql);
		  
		  } catch (SQLException e) { 
			  System.out.println("Query fallita: "+sql);
			  e.printStackTrace();
		  } 
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
		response.sendRedirect(rispostaPagina);
		}
			
	}
}
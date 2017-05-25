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

public class MiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
    public MiaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			try {
				// Carichiamo un driver di tipo 1 (bridge jdbc-odbc)
				String driver = "com.mysql.jdbc.Driver";
				try {
					Class.forName(driver);
				} catch (ClassNotFoundException e) {
					System.out.println("Manca il driver!!!");
					e.printStackTrace();
				}
				// Creiamo la stringa di connessione
				String url = "jdbc:mysql://localhost:3306/framar";
				// Otteniamo una connessione con username e password
				Connection con =
				DriverManager.getConnection (url, "francesco", "");
				// Creiamo un oggetto Statement per poter interrogare il db
				Statement cmd = con.createStatement ();
				// Eseguiamo una query e immagazziniamone i risultati
				// in un oggetto ResultSet
				String qry = "SELECT * FROM regione";
				ResultSet res = cmd.executeQuery(qry);
				System.out.println("Query effettuata: " + qry);
				// Stampiamone i risultati riga per riga
				while (res.next()) {
					System.out.println(res.getString("id")+ " -- "+ res.getString("descrizione"));
				}
			res.close();
			cmd.close();
			con.close();

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Query non eseguita!");
			}
	}
}

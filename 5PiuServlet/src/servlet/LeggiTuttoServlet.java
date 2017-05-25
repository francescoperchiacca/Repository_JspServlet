package servlet;

import servlet.Tabella;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class leggiTuttoServlet
 */
public class LeggiTuttoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeggiTuttoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Sono finalmente entrato nella mia Servlet di lettura all");
		String rispostaPagina = "../5PiuServlet/jsp/visualizza.jsp";
		
		System.out.println("Faccio fare una connessione al database raccogliendo delle informazioni");
		ArrayList<Tabella> listaR = new ArrayList<Tabella>();
		Tabella t = new Tabella();
		Connection conn = null;
		ResultSet res = null;
		Statement cmd = null;
		
		try {
			String driver = "com.mysql.jdbc.Driver";
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				System.out.println("Manca il driver!!!");
				e.printStackTrace();
			}
			String url = "jdbc:mysql://localhost:3306/framar";
			conn = DriverManager.getConnection (url, "francesco", "");
			cmd = conn.createStatement ();
			String qry = "SELECT id, descrizione FROM regione ORDER BY ID DESC";
			res = cmd.executeQuery(qry);
			System.out.println("Query effettuata: " + qry);
			while (res.next()) {
				System.out.println(res.getString("id")+ " -- "+ res.getString("descrizione"));
			//	System.out.println(res.getString(1)+" - "+ res.getString(2)); //getString(indice colonna)
				t = new Tabella();
				String id = res.getString("id");
				String descrizione = res.getString("descrizione");
				t.setId(id);
				t.setDescrizione(descrizione);
				listaR.add(t);	
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query non eseguita!");
		}finally{
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				cmd.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		HttpSession session = request.getSession();
		session.setAttribute("lista", listaR);
		response.sendRedirect(rispostaPagina);
	}
}

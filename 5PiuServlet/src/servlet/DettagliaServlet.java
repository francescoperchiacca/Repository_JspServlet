package servlet;

import servlet.Tabella;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DettagliaServlet
 */
public class DettagliaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DettagliaServlet() {
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
	
		String dettaglia = request.getParameter("op1");
		String modifica = request.getParameter("op2");
		String elimina = request.getParameter("op3");
		
		System.out.println("-----------> "+dettaglia);
		
		System.out.println("sono dentro DettagliaServlet");
		String risposta = "../5PiuServlet/jsp/dettaglia.jsp";		
		Tabella form = new Tabella();
	
		String idreg = request.getParameter("operazione");
		//form.setId(idreg);
		if((dettaglia == null) && (modifica == null) && (elimina ==null)){
			System.out.println("Nessuna selezione");
			risposta = "../5PiuServlet/error.jsp";
			
		}
		else {
			System.out.println("ho assunto il valore: " + dettaglia);
			System.out.println("Sono finalmente entrato nella mia Servlet di lettura all");
		
			
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
				
				String qry = "SELECT * FROM regione where id="+dettaglia+"";
			
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
		}/*else if(idreg.equalsIgnoreCase("modifica")){
			System.out.println("ho assunto il valore: " + idreg);
		}else if(idreg.equalsIgnoreCase("elimina")){
			System.out.println("ho assunto il valore: " + idreg);
		}
		*/
		response.sendRedirect(risposta);
	}
	
public List<?> getRegione(int idRegione){
		
		ArrayList<Tabella> listaP = new ArrayList<Tabella>();
		Tabella t = new Tabella();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement st = null;
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
			String select ="select id, descrizione from regione where id="+idRegione;
			st = conn.prepareStatement(select);
			rs = st.executeQuery();
			while (rs.next()){
				t = new Tabella();
				System.out.println(rs.getString(1)+" - "+ rs.getString(2));
				String id = rs.getString("id");
				String descrizione = rs.getString("descrizione");
				t.setId(id);
				t.setDescrizione(descrizione);
				listaP.add(t);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			String notifica = "Errore caricamento dati in menu Combo: " + e.getMessage();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaP;
	}	

}

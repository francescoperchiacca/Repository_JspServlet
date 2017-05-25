package servlet;

public class Tabella {
	
	private String id;
	private String descrizione;
	private String id_regione;
	private String id_provincia;
	
	public Tabella(){
		id = "";
		descrizione = "";
		id_regione = "";
		id_provincia = "";
	}

	public Tabella(String descrizione) {
		super();
		this.descrizione = descrizione;
	}
	
	public Tabella(String id, String descrizione, String idRegione, String idProvincia) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.id_regione = idRegione;
		this.id_provincia = idProvincia;
	}
	
	public String valida(){
  		StringBuffer sb = new StringBuffer();
    	if(descrizione == null || descrizione == "" || descrizione.length() < 1){
    		sb.append("Valorizzare La tendina provincia");	
        }
  		if(sb.length() > 1){
  		 	return sb.toString();
  		}else{
  			return null;
  		} 		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getId_regione() {
		return id_regione;
	}
	public void setId_regione(String idRegione) {
		id_regione = idRegione;
	}
	public String getId_provincia() {
		return id_provincia;
	}
	public void setId_provincia(String idProvincia) {
		id_provincia = idProvincia;
	}
	
}

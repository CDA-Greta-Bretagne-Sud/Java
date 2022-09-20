import java.text.SimpleDateFormat;
import java.util.Date;

public class Emprunt {
	private static int lastId=0;
	private int Id;
	private Date dateEmprunt;
	private Livre livre;
	private Personne Pers;
	

	public Emprunt(Date dateEmprunt, Livre livre, Personne pers) {
		
		Id = lastId++;
		this.dateEmprunt = dateEmprunt;
		this.livre = livre;
		Pers = pers;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Personne getPers() {
		return Pers;
	}

	public void setPers(Personne pers) {
		Pers = pers;
	}

	@Override
	public String toString() {
		SimpleDateFormat ft =  new SimpleDateFormat("dd/MM/YYYY hh:mm");
		
		return "Emprunt [getId()=" + getId() + ", getDateEmprunt()=" + ft.format(getDateEmprunt()) + ", getLivre()=" + getLivre()
				+ ", getPers()=" + getPers() + "]";
	}
	
}


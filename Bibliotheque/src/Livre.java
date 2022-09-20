
public class Livre {
	private int Id;
	private String Titre;
	private String Auteur;
	private String Editeur;
	//variable auto-incrémenté l'id livre
	private static int lastId=0;
	
	

	public Livre(String titre, String auteur, String editeur) {
		//incrémentation de 1 pour chaque l'id de chaque nouveau livre
		Id =  lastId++;
		Titre = titre;
		Auteur = auteur;
		Editeur = editeur;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	public String getAuteur() {
		return Auteur;
	}
	public void setAuteur(String auteur) {
		Auteur = auteur;
	}
	public String getEditeur() {
		return Editeur;
	}
	public void setEditeur(String editeur) {
		Editeur = editeur;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	@Override
	public String toString() {
		return "Livre [ id="+getId() +" titre="+ getTitre() +" Auteur = "+ getAuteur() + ", getEditeur()=" + getEditeur()
				+ "]";
	}
	
	
}

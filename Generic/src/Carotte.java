
public class Carotte implements Legume {
	private String nom;
	private String variete;

	public Carotte(String nom, String variete) {
		super();
		this.nom = nom;
		this.variete = variete;
	}
public String getLegume(){
	return  this.getVariete();
}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVariete() {
		return variete;
	}

	public void setVariete(String variete) {
		this.variete = variete;
	}

	@Override
	public String toString() {
		return "Carotte [nom=" + nom + ", variete=" + variete + "]";
	}

}

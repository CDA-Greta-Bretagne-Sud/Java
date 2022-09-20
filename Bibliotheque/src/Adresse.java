
public class Adresse {
	private static int lastId=0;
	private int Id;
	private String Numero;
	private String Rue;
	private int codePostal;
	private String Ville;
	public Adresse(String numero, String rue, int codePostal, String ville) {
		Id=lastId++;
		Numero = numero;
		Rue = rue;
		this.codePostal = codePostal;
		Ville = ville;
	}
	public String getNumero() {
		return Numero;
	}
	public void setNumero(String numero) {
		Numero = numero;
	}
	public String getRue() {
		return Rue;
	}
	public void setRue(String rue) {
		Rue = rue;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return Ville;
	}
	public void setVille(String ville) {
		Ville = ville;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	@Override
	public String toString() {
		return "Adresse [Id ="+getId()+ " numero=" + getNumero() + ", getRue()=" + getRue() + ", getCodePostal()=" + getCodePostal()
				+ ", getVille()=" + getVille() + "]";
	}
	
}

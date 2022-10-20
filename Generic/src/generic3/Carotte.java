package generic3;

public class Carotte<L,J> implements Legume<L,J>  {
	private String nom;
	private L variete;
	private J jardin;

	public Carotte( L v, J j, String nom) {
		
		this.variete = v;
		this.jardin = j;
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public L getLegume(){
		return this.variete;
	}
public void setLegume(L a){
	this.variete=a;
		
}
	public J getJardin(){
		return this.jardin;
	}
public void setJardin(J b){
	this.jardin=b;
}

@Override
public String toString() {
	return "Carotte [nom=" + nom + ", variete=" + variete + ", jardin=" + jardin + "]";
}


}

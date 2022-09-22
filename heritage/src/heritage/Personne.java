package heritage;

public class Personne {
	LaDate naissance;
	String nom;
	
	public Personne(String name, LaDate naiss) {
		this. nom = name;
		this.naissance = naiss;
		}
		public void ecrire() {
		Terminal.ecrireStringln(nom+" (");
		naissance.ecrire();
		Terminal.ecrireStringln(")");
		}
}

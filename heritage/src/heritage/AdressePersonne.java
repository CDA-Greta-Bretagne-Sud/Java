package heritage;

public class AdressePersonne extends Personne {

	public String lieuNaissance;
	
	
	public AdressePersonne(String name, LaDate naiss, String lieuNaissance) {
		super(name, naiss);
		this.lieuNaissance = lieuNaissance;
	}

@Override

	public void ecrire() {
		super.ecrire();
		Terminal.ecrireString("Lieu de naissance: " + lieuNaissance);
		
	}


	
}


class Compte implements Convertible {
	int solde;
	String titulaire;
	int numero;

	public Compte(String n, int num) {
		titulaire = n;
		numero = num;
		solde = 0;
	}

	void afficher() {
		Terminal.ecrireString("solde" + this.solde);
	}

	void deposer(int montant) {
		this.solde = this.solde + montant;
	}

	void retirer(int montant) {
		this.solde = this.solde - montant;
	}

	public int toInt() {
		return solde;
	}
}

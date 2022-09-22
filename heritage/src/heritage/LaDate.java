package heritage;

public class LaDate {

	int jour;
	int mois;
	int annee;
	// ===================================================
	// l’année en cours ...
	static int CETTE_ANNE = 2021;

	public LaDate(int j, int m, int a) {
		this.jour = j;
		this.mois = m;
		this.annee = a;
	}

	public void ecrire() {
		Terminal.ecrireString(jour + "/" + mois + "/" + annee);
	}
}

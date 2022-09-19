import java.util.ArrayList;
import java.util.StringTokenizer;

public class Exercice3 {

	public static void main(String[] args) {

		Terminal.ecrireString("Saisir la phrase: ");
		String phrase = Terminal.lireString(); // Saisi
		String[] mots = isolerMots(phrase); // Traitement
		for (String m : mots) { // Affichage
			Terminal.ecrireStringln(m);
		}

		Terminal.ecrireStringln("Le mot le plus grand est :" + motPlusLong(phrase));

		recherchePersonne(phrase);
	}

	/**
	 * Méthode qui isole de maniere unique chacun des mots d'une phrase
	 * 
	 * @param phrase
	 * @return tableau de string
	 */
	static String[] isolerMots(String phrase) {
		// On isole les mots grace au string token
		StringTokenizer stringok = new StringTokenizer(phrase);
		//on compte le nbre de mots
		int n = stringok.countTokens();

		// Tableau qui contiendra les mots
		// au maximume ce tableau est de la dimension des mots de la phrase
		ArrayList<String> tabMots = new ArrayList<String>();
		// On parcourt les mots de la phrase et on l'ajoute dans le
		// tableau de mot s'il n'existe pas deja
		//
		while (stringok.hasMoreTokens()) {

			String mot = stringok.nextToken();
			Terminal.ecrireStringln("[" + mot + "]");
			// On recherche s'il n'existe pas deja pour ensuite le rajouter
			if (!tabMots.contains(mot)) {
				tabMots.add(mot);
			}
		}
		// on initialise un tableau de string
		String[] t = new String[tabMots.size()];
		// on y insere notre tableau de mot
		tabMots.toArray(t);
		// on retourne le tableau
		return (t);

	}
/**
 * Méthode permettant de retourner le mot le plus long dans une phrase
 * @param phrase
 * @return mot le plus long
 */
	static String motPlusLong(String phrase) {
		// on isole les mots
		StringTokenizer stringok = new StringTokenizer(phrase);
		String motTrouve = "";
		int nbcar = 0;
		while (stringok.hasMoreTokens()) {
			String mot = stringok.nextToken();
			if (mot.length() >= nbcar) {
				nbcar = mot.length();
				motTrouve = mot;
			}
		}
		return motTrouve;

	}
/**
 * méthode permettant de rechercher a partir d'un nom et d'un prenom une personne dans le fichier Annuaire.txt
 * @param phrase
 */
	static void recherchePersonne(String phrase) {
		boolean continuer = true;
		while (continuer) {
			Terminal.ecrireString("Voulez-vous chercher une personne (o/n):");
			char res = Terminal.lireChar();
			if (res == 'n') {
				continuer = false;
				continue;
			}
			String pers ="";
			Terminal.ecrireString("Saisir le nom et/ou le prenom de la personne: ");
			pers = Terminal.lireString(); // Saisi
			// on isole le nom et le prénom
			String[] tab = null;
			tab = pers.split(" ");
			String prenom = "";
			String nom = "";
			// on crontrole si l'utisateur a saisi un prenom et un nom
			if (tab.length > 1) {
				nom = tab[0];
				prenom = tab[1];
			} else
				nom = tab[0];

			String[] listePers = Terminal.lireFichierTexte("Annuaire.txt");
			boolean trouve = false;
			for (String p : listePers) {
				// Terminal.ecrireStringln(p);
				StringTokenizer detailPers = new StringTokenizer(p, ";");

				String motNom = detailPers.nextToken();
				String motPrenom = detailPers.nextToken();

				if (motNom.equals(nom) || motNom.equals(prenom)||motPrenom.equals(nom) || motPrenom.equals(prenom)) {
					trouve = true;
					Terminal.ecrireStringln("La personne " + nom + " a été trouvé !");
					Terminal.ecrireStringln("nom: " + motNom);
					Terminal.ecrireStringln("prenom: " + motPrenom);
					Terminal.ecrireStringln("adresse: " + detailPers.nextToken());
					Terminal.ecrireStringln("Tel: " + detailPers.nextToken());
				}

			}
			if (!trouve) {
				Terminal.ecrireStringln("la personne " + nom + " " + prenom + " n'a pas été trouvée dans l'annuaire!");
			}
		}
	}
}

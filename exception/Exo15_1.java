class Exo15_1 {

	static int[] tableau = { 17, 12, 15, 38, 29, 157, 89, -22, 0, 5 };

	static int division(int indice, int diviseur) {
		return tableau[indice] / diviseur;
		
	}

	public static void main(String[] args) {
		int x, y;
		boolean ok = false;
		do {

			try {
				
				Terminal.ecrireString("Entrez l’indice de l’entier a diviser: ");
				x = Terminal.lireInt();
				Terminal.ecrireString("Entrez le diviseur: ");
				y = Terminal.lireInt();
				Terminal.ecrireStringln("Le resultat de la division est: ");
				Terminal.ecrireIntln(division(x, y));
				ok=true;

			} catch (ArithmeticException e) {
				Terminal.ecrireStringln("Le diviseur ne doit pas etre null");
			
			} catch (ArrayIndexOutOfBoundsException e) {
				Terminal.ecrireString("L’indice doit etre compris entre 0 ");
				Terminal.ecrireStringln("et " + (tableau.length - 1) + ".");
				
			} catch (TerminalException e) {
				Terminal.ecrireStringln("Vous devez entrer un nombre entier.");
				
			}
		} while (!ok);
	}
}

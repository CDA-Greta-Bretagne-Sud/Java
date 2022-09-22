package heritage;

public class Main {
	public static void main(String[] args) {
		
		LaDate d1 = new LaDate(22, 9, 2022 );
		
		Personne p1 = new Personne("bob",d1);
		Personne p2 = new AdressePersonne("Marcel", d1, "Vannes");
		
		p1.ecrire();
		p2.ecrire();
	}
}

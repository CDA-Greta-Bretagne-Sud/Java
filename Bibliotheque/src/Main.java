import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Livre l1=new Livre("Les Miserables", "Victor Hugo", "Gallimard");
		Livre l2=new Livre("1984", "Georges Orwell", "Flamarion");
		
		Bibliotheque b=new Bibliotheque();
		
		b.AjoutLivre(l1);
		b.AjoutLivre(l2);
		b.AfficherLivres();
		b.rechercheLivre("1984");
		
		//emprunt
		
		Adresse ad1= new Adresse("6", "rue sainte croix", 44000, "Nantes");
		Adresse ad2= new Adresse("56", "faubourd saint denis", 75000, "Paris");
		
		Personne p1=new Personne("macron", "Brigitte", ad1, "bmacron@free.Fr");
		Personne p2=new Personne("Chirac", "Bernadette", ad1, "bchirac@free.Fr");
		Personne p3=new Personne("Hollande", "Francois", ad1, "fhollande@free.Fr");
		//Date
		Date d1 =new Date();
		Date d2 =new Date();
		
		Emprunt e1= new Emprunt(d1,l1,p1);
		Emprunt e2= new Emprunt(d2,l2,p2);
		
		b.AjouterEmprunt(e1);
		b.AjouterEmprunt(e2);
		b.AfficherEmprunts();
		b.rechercheEmprunt(l1);
		b.rechercheEmprunt(p2);
		b.SupprimerEmprunt(e2);
		b.AfficherEmprunts();
		try {
		b.rechercheEmprunt(p3);
		
		}catch(EnregNonTrouve e) {
			System.out.println("Enregistrement non trouvé dans la bibliotheque");
		}
	}

}

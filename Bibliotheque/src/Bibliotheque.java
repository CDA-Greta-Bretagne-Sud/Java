import java.util.ArrayList;

public class Bibliotheque {

	private ArrayList<Livre> Listelivre;
	private ArrayList<Emprunt> ListeEmprunt;
	public Bibliotheque() {
	
		Listelivre =  new ArrayList<>();
		ListeEmprunt = new ArrayList<>();
	}
	
	public void AjoutLivre(Livre l) {
		//ajout Livre
		if(l!=null) {
		Listelivre.add(l);
		}
	}
	public void AfficherLivres() {
		//afficher listelivre
		for(int i=0;i<Listelivre.size();i++) {
			System.out.println(Listelivre.get(i));
		}
	}
	public void rechercheLivre(String t) {
		
		boolean trouve=false; 
		//rechercher dans arraylist livre 
		for(int i=0;i<Listelivre.size();i++) {
			if(Listelivre.get(i).getTitre().equals(t)) {
			System.out.println("Livre trouvé:"+Listelivre.get(i));
			trouve=true;
			}
		} 
		//si livre pas trouvé -> message
		if(!trouve) {
			System.out.println("Livre non trouvé!");
		}		
	}
	public void rechercheEmprunt(Personne p) {		
		
		//TODO recherche emprunt dans arraylist
		boolean trouve=false; 
		//rechercher dans arraylist livre 
		for(int i=0;i<ListeEmprunt.size();i++) {
			if(ListeEmprunt.get(i).getPers().equals(p)) {
			System.out.println("personne trouvé:"+ListeEmprunt.get(i));
			trouve=true;
			}
		}
		//si personne pas trouvé -> message
				if(!trouve) {
						throw new EnregNonTrouve();
				}
		
	}
	public void rechercheEmprunt(Livre l) {
		//TODO recherche emprunt dans arraylist
				boolean trouve=false; 
				//rechercher dans arraylist
				for(int i=0;i<ListeEmprunt.size();i++) {
					if(ListeEmprunt.get(i).getLivre().equals(l)) {
					System.out.println("livre trouvé:"+ListeEmprunt.get(i));
					trouve=true;
					}
				}
				//si personne pas trouvé -> message
						if(!trouve) {
							throw new EnregNonTrouve();
						}
				
	}
	public void AfficherEmprunts() {
		//afficher listeEmprunt
				for(int i=0;i<ListeEmprunt.size();i++) {
					System.out.println(ListeEmprunt.get(i));
				}
	}
	public void AjouterEmprunt(Emprunt e) {
		if(e!=null) {
			ListeEmprunt.add(e);
			}
	}
	public void SupprimerEmprunt(Emprunt e) {
		//TODO
	}
}

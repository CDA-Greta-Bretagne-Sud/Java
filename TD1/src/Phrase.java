/**
   Classe de d�finition d'une phrase.<br>
   Une phrase est avant tout une cha�ne de caract�res dont les mots sont espac�s par des caract�res blancs.
*/
public class Phrase {

	private String phrase;
	
	/** constructeur par d�faut */
	public Phrase() {
		this.phrase=new String("");
	}
	/** constructeur qui cr�� une phrase � partir de son argument 
	 * 
	 * @param in: string */
	public Phrase(String in) {
		this.phrase=new String(in);
	}
	/** getter , retourne la chaine phrase 
	 *
	 * @return String
	 */
	public String getPhrase() {
		return phrase;
	}
	/** setter
	 * modifie la phrase
	 * @param phrase
	 */
	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}
	@Override
	/**
	 * methode toString qui retourne le contenu de la phrase
	 * 
	 */
	public String toString() {
		return "Phrase [phrase=" + phrase + "]";
	}
	/**
	 * M�thode qui permet d'afficher un ennonc� demandant � l'utilisateur de saisir une chaine de caracteres
	 * Cette chaine de caractere est ensuite affect�e a l'attribut phrase
	 * @param ennonce
	 */
	public void saisirPhrase(String ennonce) {
		Terminal.ecrireStringln(ennonce+ " : ");
		this.phrase=Terminal.lireString();
	}
	/** m�thode qui teste si la phrase est un palindrome.
        Algorithme : parcours si les caract�res sont en miroir
        @return true ou flase suivant que la phrase est ou non un palindrome */
	public boolean palindrome() {
		
		String chaine;
		chaine=this.phrase;
		boolean est_palindrome=true;;
		for (int i=0;i<chaine.length()/2;i++) {
			if(chaine.charAt(i)!=chaine.charAt(chaine.length()-i-1)) {
				est_palindrome=false;
				break;
			}
		}
		if(est_palindrome) {
			return true;	
		}
		else return false;
	}
	/** methode permettant d'enlever les blancs de la phrase
	 * 
	 */
	public void supprimerBlanc() {
		
		String chaine,res;
		res="";
		chaine=this.getPhrase();
		for (int i=0;i<chaine.length();i++) {
			
			if(chaine.charAt(i)!=' ') {
				res=res+chaine.charAt(i);
			}
			else continue;
			
		}
		this.setPhrase(res);
	}
	
	/** methode permettant d'enlever les blancs en d�but et fin de phrase
	 * 
	 */
	public void diminuerBlanc() {
		
		String chaine,res;
		res="";
		chaine=this.getPhrase();
		int compteur=0;
		for (int i=0;i<chaine.length();i++) {
			//si caractere non blanc en rajoute � res
			if(chaine.charAt(i)!=' ') {
				res=res+chaine.charAt(i);
				//on reinitialise le compteur � 0
				compteur=0;
			}
			else
			{// on increment le compteur de 1
				compteur++;
				// on rajoute un expace entre les mots, ainsi on a 1 blanc entre chaques mots
				if(compteur==1) {
					res=res+' ';
				}
			}
		}
		this.setPhrase(res);
		//suppression des espaces en d�but et fin de phrase
		
		res="";
		chaine=this.getPhrase();
		
		if(chaine.charAt(0)==' ') {
			
		}
		for (int i=0;i<chaine.length();i++) {
			
			if((i==0) && chaine.charAt(i)==' ') {
				
				continue;
	
			}
			else if((i==chaine.length()-1) && chaine.charAt(i)==' ') {
				
				continue;
	
			}
			else
				res=res+chaine.charAt(i);
			
		}
		
		
		this.setPhrase(res);
	}
	
	public String[] isolerMots() {
		String[] tab = null;

        // On enl�ve les blancs superflus de la phrase
        this.diminuerBlanc();
		
        tab=this.getPhrase().split(" ");
        return tab;
	}
	
}

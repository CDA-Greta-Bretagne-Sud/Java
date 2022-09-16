
public class Exercice01 {

	public static void main(String[] args) {
		
		Phrase ph=new Phrase();
		ph.saisirPhrase("Veuillez entrer une phrase");
		if(ph.palindrome()) {
			Terminal.ecrireStringln("La phrase :"+ ph.getPhrase() +" est un palindrome");
		}else
			Terminal.ecrireStringln("La phrase :"+ ph.getPhrase() +" n'est pas un palindrome");
		
		Terminal.ecrireStringln("La phrase :"+ ph.getPhrase());
		ph.diminuerBlanc();
		Terminal.ecrireStringln("La phrase :"+ ph.getPhrase());
		
		String tab[]=ph.isolerMots();
		
		for (int i =0; i<tab.length;i++) {
			Terminal.ecrireStringln("tab["+i+"]= "+ tab[i]);
		}
		
		
	}

}

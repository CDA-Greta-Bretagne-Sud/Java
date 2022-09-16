
public class Exercice2 {
	
	public static void main(String[] args) {
		// Lecture du fichier contenant les mots a decouvrir
        //
        String[] listeMots = Terminal.lireFichierTexte("Pendu.txt");
     // On prend un mot aleatoirement : modulo du temps courant
        //   
        int aleat  = Math.abs( (int)(System.currentTimeMillis()) );
        int numero = aleat%listeMots.length;
        String mot = listeMots[numero];
        Terminal.ecrireStringln("index aleatoire="+numero+" Mot trouvé:"+ mot);
        // Le mot a trouver est transformé en tableau de char
        char[] motATrouve = mot.toCharArray();
        // Le mot cache de la longueur du mot a trouver contient au départ que des "-"
        char[] motCache   = new char[motATrouve.length];
        for(int i=0;i<motCache.length;i++) motCache[i] = '-';
     // Nombre d'erreur du joueur. A plus de 7 erreurs il a perdu.
        int nbErreur = 0;
        int nbMaxErreur = 7;
        
        // Les lettrejouees par le joueur et son nombre de coup joues
        char[] lettreJouees = new char[26];
        int nbCoupJoues = 0;

        // Boucle de jeu
        //
        boolean fini = false;
        
        while(!fini)
        {
            // Si le joueur a perdu
            if (nbErreur>nbMaxErreur)
                {
                    Terminal.ecrireString("Perdu! Le mot est: "+mot);
                    fini = true;
                }
            else
                {
                    Terminal.ecrireString("Mot a trouver  : ");
                    Terminal.ecrireStringln(new String(motCache));
                    Terminal.ecrireString("Lettres jouees : ");
                    Terminal.ecrireStringln(new String(lettreJouees));
                    Terminal.ecrireString("Nb erreurs     : ");
                    Terminal.ecrireStringln(""+nbErreur);
                    Terminal.ecrireString("Saisir un car  : ");
                    char caracJoue = Terminal.lireChar();
                    
                    // Si le caractere joue a deja ete jouee
                    if (caracDansTab(caracJoue,lettreJouees))
                        System.out.println("Caractere deja joue");
                    else
                        {
                            // Si le caractere joue fait parti du mot a trouve
                            //  alors on decouvre les lettres
                            //  sinon le joueur a fait une erreur
                            //
                            if (caracDansTab(caracJoue,motATrouve))
                                {
                                    if (majMotCache(caracJoue,motCache,motATrouve))
                                        {
                                            fini=true;
                                            Terminal.ecrireStringln("Bravo!!");
                                        }
                                }
                            else
                                {
                                    nbErreur++;
                                }
                            
                            // On stocke le caractère joué
                            lettreJouees[nbCoupJoues]=caracJoue;
                            //on incréemente le nombre de coup joués
                            nbCoupJoues++;
                                
                        }
                }
        }
        }
        // Recherche si le caractere est dans un tableau de caractère
        //
        static boolean caracDansTab(char c,char[] tab)
        {
            for(char e:tab)
                {
                    if (c==e) 
                        return true;
                }
            return false;
        }
     // Remplace les '-' par le caractère joue si il existe.
        // Retourne true si toutes les lettres ont été trouvées
        //
        static boolean majMotCache(char c,char[] motCache,char[] motATrouve)
        {
            int nbc=0;
            for(int i=0;i<motCache.length;i++)
                {
                    if(motATrouve[i]==c)
                        motCache[i]=c;
                    if(motCache[i]=='-')
                        nbc++;
                }
            if (nbc==0) return(true);
            else return false;
        }
}


